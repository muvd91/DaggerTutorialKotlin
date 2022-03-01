import Command.Result
import Command.Status
import javax.inject.Inject

@JvmSuppressWildcards
class CommandRouter @Inject constructor(private val commands: Map<String, Command>) {

    fun route(input: String): Result {
        val splitInput = split(input)
        if (splitInput.isEmpty()) return invalidCommand(input)

        val command: Command = commands[splitInput[0]] ?: return invalidCommand(input)

        val args = splitInput.subList(1, splitInput.size)
        val result = command.handleInput(args)
        return if (result.status() == Status.INVALID) invalidCommand(input) else result
    }

    private fun invalidCommand(input: String): Result = Result.invalid().also {
        println("couldn't understand $input. please try again.")
    }
    private fun split(input: String) = input.trim().split("\\s+".toRegex())
}