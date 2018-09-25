import kotlinx.coroutines.experimental.*
import kotlinx.coroutines.experimental.selects.select
import kotlin.test.Test

class Test {
    @Test
    fun test0() = GlobalScope.promise {
        fun asyncDelay(millis: Long) = async {
            println("Delay $millis")
            delay(millis)
            millis
        }

        val list: List<Deferred<Long>> = (0L..3L).map { asyncDelay(it) }

        val res: Long = select {
            for (item in list) {
                item.onAwait { it }
            }
        }
        println("Done $res")
    }

    @Test
    fun test1() = GlobalScope.promise {
        fun asyncDelay(millis: Long) = async {
            println("Delay $millis")
            delay(millis)
            millis
        }

        val list: List<Deferred<Long>> = (1L..3L).map { asyncDelay(it) }

        val res: Long = select {
            for (item in list) {
                item.onAwait { it }
            }
        }
        println("Done $res")
    }

}
