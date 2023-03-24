#!/bin/sh

echo "--Step 1: Building projects.--"
./gradlew clean build

echo "--Step 2: Creating cpb file.--"
cordapp-builder create --cpk contracts/build/libs/corda5-template-contracts-1.0-SNAPSHOT-cordapp.cpk --cpk workflows/build/libs/corda5-template-workflows-1.0-SNAPSHOT-cordapp.cpk -o template.cpb

echo "--Step 3: Configure the network.--"
corda-cli network config docker-compose template-network

echo "--Step 4: Creating docker compose yaml file and starting docker containers.--"
corda-cli network deploy -n template-network -f c5cordapp-template.yaml | docker-compose -f - up -d

echo "--Listening to the docker processes.--"
corda-cli network wait -n template-network

echo "--Step 5: Install the cpb file into the network.--"
corda-cli package install -n template-network template.cpb

echo "--Listening to the docker processes.--"
corda-cli network wait -n template-network

echo "++Cordapp Setup Finished, Nodes Status: ++"
corda-cli network status -n template-network