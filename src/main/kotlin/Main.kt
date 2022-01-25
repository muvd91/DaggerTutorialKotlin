import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val commandRouter = CommandRouter()

    while (scanner.hasNextLine()) {
        commandRouter.route(scanner.nextLine())
    }

}