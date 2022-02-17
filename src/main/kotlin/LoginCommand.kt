import Command.*
import javax.inject.Inject

class LoginCommand @Inject constructor(val database: Database, private val outputter: Outputter) : SingleArgCommand() {

    override fun handleArg(arg: String): Status {
        var account = database.getAccount(arg)
        outputter.output("$arg is logged in with balance: ${account.balance}")
        return Status.HANDLED
    }

}

