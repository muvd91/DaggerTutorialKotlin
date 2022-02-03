import Command.*

abstract class SingleArgCommand : Command {

    override fun handleInput(input: List<String>): Status =
        if (input.size == 1) handleArg(input[0]) else Status.INVALID

    protected abstract fun handleArg(arg: String): Status
}