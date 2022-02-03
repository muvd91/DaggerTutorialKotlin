import Command.*
import javax.inject.Inject

class LoginCommand @Inject constructor(private val outputter: Outputter) : SingleArgCommand() {

    override fun key(): String = "login"

    override fun handleArg(arg: String): Status =
        Status.HANDLED.also { outputter.output("$arg is logged in") }

}