import java.lang.annotation.Documented
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@Documented
@Retention(RUNTIME)
annotation class PerSession()
