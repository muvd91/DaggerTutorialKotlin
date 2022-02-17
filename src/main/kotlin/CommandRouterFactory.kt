import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginCommandModule::class,
    HelloWorldModule::class,
    SystemOutModule::class,
    UsersCommandModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}