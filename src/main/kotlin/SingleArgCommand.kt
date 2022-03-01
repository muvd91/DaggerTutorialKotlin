import Command.*

abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Result =
        if (input.size == 1) handleArg(input[0]) else Result.invalid()

    protected abstract fun handleArg(arg: String): Result
}