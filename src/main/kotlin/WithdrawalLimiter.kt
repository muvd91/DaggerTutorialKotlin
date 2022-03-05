import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor(@MaximumWithdrawal private val maximumWithdrawal: BigDecimal) {
    var remainingWithdrawalLimit: BigDecimal = maximumWithdrawal
        private set

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.add(amount)
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawalLimit = remainingWithdrawalLimit.subtract(amount)
    }

}