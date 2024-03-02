import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain
import playgrounds.KotlinCollections


@QuarkusMain
object Main {

    private val kotlinCol: KotlinCollections = KotlinCollections()

    @JvmStatic
    fun main(args: Array<String>) {
        Quarkus.run(*args)


    }

}
