import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Database @Inject constructor() {
    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(username: String) = accounts.getOrPut(username) { Account(username) }

    data class Account(val username: String) {
        var balance: BigDecimal = BigDecimal.ZERO

        fun deposit(amount: BigDecimal) {
            checkNonNegative(amount, "deposit")
            balance = balance.add(amount)
        }

        fun withdraw(amount: BigDecimal) {
            checkNonNegative(amount, "deposit")
            balance = balance.subtract(amount)
        }

        private fun checkNonNegative(amount: BigDecimal, action: String) {
            if (amount.signum() == -1) throw IllegalArgumentException("Cannot $action negative amounts: $amount")
        }
    }
}

