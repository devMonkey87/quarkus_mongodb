import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import io.quarkus.runtime.annotations.QuarkusMain
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

@QuarkusMain
class Main {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main().run()
        }
    }

    fun run() = runBlocking {
        println("Ejecucion normal init")
        val normalExecutionTime = measureTimeMillis {
            callApi()
            heavyOperation()
        }
        println("Ejecucion normal end - Tiempo total: $normalExecutionTime ms")

        println("Ejecucion paralelizada init")
        val parallelExecutionTime = measureTimeMillis {
            launch {
                callApi()
                heavyOperation()
            }.join() // Esperar a que la corutina paralela termine
        }
        println("Ejecucion paralelizada end - Tiempo total: $parallelExecutionTime ms")
    }

    private suspend fun heavyOperation() {
        var value = 1
        for (i in 1..8000) {
            value += i
        }
    }

    private suspend fun callApi() {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://burgers-hub.p.rapidapi.com/burgers")
            .get()
            .addHeader("X-RapidAPI-Key", "94ee14ffabmshfbfd83af1fe237ep166202jsn5bd8d48365f2")
            .addHeader("X-RapidAPI-Host", "burgers-hub.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        println("RESPONSE: ${response}")
    }
}
