import javax.inject.Inject

class HelloWorldCommand @Inject constructor() : Command {
    override fun key(): String = "hello"

    override fun handleInput(input: List<String>): Command.Status
        = if (input.isNotEmpty()) Command.Status.INVALID
            else Command.Status.HANDLED.also { println("world!") }
}