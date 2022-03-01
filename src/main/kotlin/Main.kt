import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val commandProcessor = DaggerCommandProcessorFactory.create().processor()

    while (scanner.hasNextLine()) {
        commandProcessor.process(scanner.nextLine())
    }

}