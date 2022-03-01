import UserCommandsRouter.InstallationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginCommandModule::class,
    HelloWorldModule::class,
    SystemOutModule::class,
    InstallationModule::class])
interface CommandProcessorFactory {
    fun processor(): CommandProcessor
}