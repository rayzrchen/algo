package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyQueueTest {
    @Test
    fun enqueueTest() {
        val myQueue = MyQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        assertEquals(listOf(10, 20, 30, 0, 0).toString(), myQueue.toString())
    }

    @Test
    fun dequeueTest() {
        val myQueue = MyQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        myQueue.dequeue()
        myQueue.dequeue()
        myQueue.dequeue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)
        assertEquals(listOf(30, 0, 0, 10, 20).toString(), myQueue.toString())
    }

    @Test
    fun peekTest() {
        val myQueue = MyQueue()
        myQueue.enqueue(10)
        myQueue.enqueue(20)
        myQueue.enqueue(30)

        assertEquals(10, myQueue.peek())
        assertEquals(listOf(10, 20, 30, 0, 0).toString(), myQueue.toString())
    }

    @Test
    fun isEmptyTest() {
        val myQueue = MyQueue()
        assertEquals(true, myQueue.isEmpty())
        myQueue.enqueue(10)
        assertEquals(false, myQueue.isEmpty())
    }

    @Test
    fun isFullTest() {
        val myQueue = MyQueue()
        assertEquals(false, myQueue.isFull())
        (0 until 5).forEach {
            myQueue.enqueue(it * 10)
        }
        assertEquals(true, myQueue.isFull())
    }


}