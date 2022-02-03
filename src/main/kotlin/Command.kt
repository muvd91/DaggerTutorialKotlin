interface Command {

    fun key(): String

    fun handleInput(input: List<String>): Status

    enum class Status {
        INVALID,
        HANDLED
    }
}