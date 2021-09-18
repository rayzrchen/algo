package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class PriorityQueueTest {
    @Test
    fun insertTest() {
        val queue = PriorityQueue()
        queue.insert(1)
        queue.insert(3)
        queue.insert(5)
        queue.insert(7)
        queue.insert(2)
        assertEquals(listOf(1, 2, 3, 5, 7).toString(), "$queue")
        queue.remove()
        queue.insert(4)
        assertEquals(listOf(1, 2, 3, 4, 5).toString(), "$queue")
    }
}