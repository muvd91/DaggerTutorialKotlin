import Command.Status
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : Command {

    override fun handleInput(input: List<String>): Status =
        Status.HANDLED.also { outputter.output("world!") }
}