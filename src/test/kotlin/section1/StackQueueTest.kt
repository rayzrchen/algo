package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StackQueueTest {

    @Test
    fun enqueueTest() {
        val myQueue = StackQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        assertEquals(listOf(10, 20, 30).toString(), myQueue.toString())
    }

    @Test
    fun dequeueTest() {
        val myQueue = StackQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        myQueue.dequeue()
        myQueue.dequeue()
        myQueue.dequeue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        assertEquals(listOf(10, 20, 30).toString(), myQueue.toString())
    }

    @Test
    fun peekTest() {
        val myQueue = StackQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)

        assertEquals(10, myQueue.peek())
        assertEquals(listOf(10, 20, 30).toString(), myQueue.toString())
    }

    @Test
    fun isEmptyTest() {
        val myQueue = StackQueue()
        assertEquals(true, myQueue.isEmpty())
        myQueue.enqueue(10)
        assertEquals(false, myQueue.isEmpty())
    }


}