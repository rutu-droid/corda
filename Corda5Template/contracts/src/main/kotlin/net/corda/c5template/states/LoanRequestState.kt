package net.corda.c5template.states

import net.corda.c5template.contracts.TemplateContract
import net.corda.v5.application.identity.AbstractParty
import net.corda.v5.ledger.UniqueIdentifier
import net.corda.v5.application.identity.Party
import net.corda.v5.ledger.contracts.BelongsToContract
import net.corda.v5.ledger.contracts.ContractState
import net.corda.v5.ledger.contracts.LinearState


@BelongsToContract(TemplateContract::class)
data class LoanRequestState (
    val requestValue: String,
    val requester: Party,
    val bank: Party,
    override val linearId: UniqueIdentifier = UniqueIdentifier(),
) : LinearState{

    override val participants: List<AbstractParty> get() = listOf(requester,bank)

}