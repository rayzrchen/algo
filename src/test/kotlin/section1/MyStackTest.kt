package section1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MyStackTest {
    @Test
    fun pushTest() {
        val myStack = MyStack()
        myStack.push(1)
        myStack.push(2)
        myStack.push(3)
        assertEquals(listOf(1, 2, 3).toString(), myStack.toString())
        myStack.push(4)
        myStack.push(5)
        assertEquals(listOf(1, 2, 3, 4, 5).toString(), myStack.toString())
    }

    @Test
    fun popTest() {
        val myStack = MyStack()
        myStack.push(1)
        myStack.push(2)
        myStack.push(3)
        assertEquals(3, myStack.pop())
        assertEquals(listOf(1, 2).toString(), myStack.toString())
    }

    @Test
    fun peekTest() {
        val myStack = MyStack()
        myStack.push(1)
        myStack.push(2)
        myStack.push(3)
        assertEquals(3, myStack.peek())
        assertEquals(listOf(1, 2,3).toString(), myStack.toString())
    }

    @Test
    fun isEmptyTest() {
        val myStack = MyStack()
        assertEquals(true, myStack.isEmpty())
        myStack.push(1)
        assertEquals(false, myStack.isEmpty())
        myStack.pop()
        assertEquals(true, myStack.isEmpty())
    }

}