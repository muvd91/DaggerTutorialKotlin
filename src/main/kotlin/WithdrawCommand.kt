import Database.Account
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(private val account: Account,
                                          private val outputter: Outputter,
                                          @MinimumBalance private val minimumBalance: BigDecimal,
                                          @MaximumWithdrawal private val maximumWithdrawal: BigDecimal)
    : BigDecimalCommand(outputter){

    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("amount is greater than the maximum allowed withdrawal")
            return;
        }
        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("account balance should have at least $minimumBalance")
            return;
        } else {
            account.withdraw(amount)
            outputter.output("your new balance is ${account.balance}")
        }
    }
}