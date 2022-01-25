import Command.Status

class CommandRouter {
    private val commands: Map<String, Command> = emptyMap()

    fun route(input: String): Status {
        val splitInput = split(input)
        if (splitInput.isEmpty()) return invalidCommand(input)

        val command: Command = commands[splitInput[0]] ?: return invalidCommand(input)

        return command.handleInput(splitInput.subList(1, splitInput.size)).also {
            if (it == Status.INVALID) println("${splitInput[0]} : invalid arguments")
        }

    }

    private fun invalidCommand(input: String): Status = Status.INVALID.also {
        println("couldn't understand $input. please try again.")
    }
    private fun split(input: String) = input.trim().split("\\s+".toRegex())

}