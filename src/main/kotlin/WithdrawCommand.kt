import Database.Account
import java.math.BigDecimal
import javax.inject.Inject

class WithdrawCommand @Inject constructor(private val account: Account,
                                          private val outputter: Outputter,
                                          private val withdrawalLimiter: WithdrawalLimiter,
                                          @MinimumBalance private val minimumBalance: BigDecimal,
                                          @MaximumWithdrawal private val maximumWithdrawal: BigDecimal)
    : BigDecimalCommand(outputter){

    override fun handleAmount(amount: BigDecimal) {
        var remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit
        if (amount > remainingWithdrawalLimit) {
            outputter.output("you may not withdraw $amount; you may withdraw $remainingWithdrawalLimit in this session")
            return;
        }
        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("account balance should have at least $minimumBalance")
            return;
        } else {
            account.withdraw(amount)
            withdrawalLimiter.recordWithdrawal(amount)
            outputter.output("your new balance is ${account.balance}")
        }
    }
}