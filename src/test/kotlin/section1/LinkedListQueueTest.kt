package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LinkedListQueueTest {
    @Test
    fun enqueueTest() {
        val queue = LinkedListQueue()
        queue.enqueue(10)
        queue.enqueue(20)
        queue.enqueue(30)
        assertEquals(listOf(10, 20, 30).toString(), "$queue")

        assertEquals(10, queue.dequeue())
        assertEquals(listOf(20, 30).toString(), "$queue")
        assertEquals(20, queue.peek())
        assertEquals(2, queue.size())
        assertEquals(false, queue.isEmpty())
        queue.dequeue()
        queue.dequeue()
        assertEquals(true, queue.isEmpty())
    }
}