import Command.*
import javax.inject.Inject

class HelloWorldCommand @Inject constructor(private val outputter: Outputter) : Command {

    override fun handleInput(input: List<String>): Result =
        Result.handled().also { outputter.output("world!") }
}