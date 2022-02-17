import java.math.BigDecimal
import javax.inject.Inject

class Database @Inject constructor() {
    private val accounts: MutableMap<String, Account> = mutableMapOf()

    fun getAccount(username: String) = accounts.getOrPut(username) { Account(username) }

    data class Account(val username: String) {
        var balance: BigDecimal = BigDecimal.ZERO
    }
}

