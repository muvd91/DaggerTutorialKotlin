import Command.Result
import Database.Account
import javax.inject.Inject

class LogoutCommand @Inject constructor(private val outputter: Outputter, private val account: Account) : Command {
    override fun handleInput(input: List<String>): Command.Result =
        if (input.isEmpty()) Result.inputCompleted().also { outputter.output("logged out ${account.username}")}
        else Result.invalid()
}