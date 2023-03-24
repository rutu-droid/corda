package net.corda.c5template.contracts

import net.corda.c5template.states.LoanRequestState
import net.corda.v5.ledger.contracts.CommandData
import net.corda.v5.ledger.contracts.Contract
import net.corda.v5.ledger.contracts.requireSingleCommand
import net.corda.v5.ledger.contracts.requireThat
import net.corda.v5.ledger.transactions.LedgerTransaction
import net.corda.v5.ledger.transactions.outputsOfType

class TemplateContract : Contract {
    companion object {
        // Used to identify our contract when building a transaction.
        @JvmStatic
        val ID = "net.corda.c5template.contracts.TemplateContract"
    }

    // A transaction is valid if the verify() function of the contract of all the transaction's input and output states
    // does not throw an exception.
    override fun verify(tx: LedgerTransaction) {
        // Verification logic goes here.
        
    }

    // Used to indicate the transaction's intent.
    interface Commands : CommandData {
        class Create : Commands
    }
}
