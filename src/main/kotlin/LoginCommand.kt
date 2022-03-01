import Command.*
import javax.inject.Inject

class LoginCommand @Inject constructor(
    val database: Database,
    private val outputter: Outputter,
    private val userCommandsRouterFactory: UserCommandsRouter.Factory) : SingleArgCommand() {

    override fun handleArg(arg: String): Result {
        val account = database.getAccount(arg)
        outputter.output("$arg is logged in with balance: ${account.balance}")
        return Result.enterNestedCommandSet(userCommandsRouterFactory.create(account).router())
    }

}

