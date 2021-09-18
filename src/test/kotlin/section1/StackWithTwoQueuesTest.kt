package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.concurrent.ArrayBlockingQueue

internal class StackWithTwoQueuesTest {
    @Test
    fun test1() {
        val stack = StackWithTwoQueues()
        stack.push(10)
        stack.push(20)
        stack.push(30)
        assertEquals(10, stack.pop())
        assertEquals(20, stack.peek())
        assertEquals(2, stack.size())
        assertEquals(false, stack.isEmpty())
        stack.pop()
        stack.pop()
        assertEquals(true, stack.isEmpty())
        stack.push(30)
        assertEquals(1, stack.size())
    }

    @Test
    fun test2() {
        val queue = ArrayBlockingQueue<Int>(10)
        queue.add(10)
        queue.add(20)
        queue.add(30)
        println(queue.remove())
        println(queue.remove())
        println(queue.remove())

    }
}