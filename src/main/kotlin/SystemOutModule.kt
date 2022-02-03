import dagger.Module
import dagger.Provides

@Module
abstract class SystemOutModule {
    companion object {
        @Provides
        fun textOutputter(): Outputter = Outputter(::println)
    }
}