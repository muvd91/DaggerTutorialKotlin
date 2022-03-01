import Command.Result
import java.lang.NumberFormatException
import java.math.BigDecimal

abstract class BigDecimalCommand(private val outputter: Outputter) : SingleArgCommand() {
    override fun handleArg(arg: String): Result {
        val amount = tryParse(arg)
        if (amount == null) {
            outputter.output("$arg is not a valid number")
        } else if (amount.signum() <= 0) {
            outputter.output("amount must be positive")
        } else {
            handleAmount(amount)
        }
        return Result.handled()
    }


    private fun tryParse(arg: String): BigDecimal? {
        return try {
            BigDecimal(arg)
        } catch (e: NumberFormatException) {
            null
        }
    }

    protected abstract fun handleAmount(amount: BigDecimal): Unit
}