import Command.*
import Database.Account
import java.math.BigDecimal
import javax.inject.Inject

class DepositCommand @Inject constructor(private val account: Account, private val outputter: Outputter) :
    BigDecimalCommand(outputter) {

    override fun handleAmount(amount: BigDecimal): Unit {
        account.deposit(amount)
        outputter.output("${account.username} now has: ${account.balance}")
    }
}