import java.util.*

interface Command {

    fun handleInput(input: List<String>): Result

    class Result(private val status: Status,
                 private val nestedCommandRouter: Optional<CommandRouter>) {

        fun status() = status

        fun nestedCommandRouter(): Optional<CommandRouter> = nestedCommandRouter

        companion object {
            fun invalid(): Result = Result(Status.INVALID, Optional.empty())
            fun handled(): Result = Result(Status.HANDLED, Optional.empty())
            fun inputCompleted(): Result = Result(Status.INPUT_COMPLETED, Optional.empty())

            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result =
                Result(Status.HANDLED, Optional.of(nestedCommandRouter))
        }
    }

    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}