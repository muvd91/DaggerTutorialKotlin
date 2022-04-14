import Command.*
import Database.Account
import java.util.*
import javax.inject.Inject

class LoginCommand @Inject constructor(
    val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory,
    private val account: Optional<Account>) : SingleArgCommand() {

    override fun handleArg(arg: String): Result {
        if (account.isPresent) return Result.handled()
        val account = database.getAccount(arg)
        outputter.output("$arg is logged in with balance: ${account.balance}")
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }

}

