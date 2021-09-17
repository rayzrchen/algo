package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class MyLinkedListTest {
    @Test
    fun testInit() {
        assertNotNull(MyLinkedList())
    }

    @Test
    fun testAddFirst() {
        val linkedList = MyLinkedList()
        assertEquals("[]", linkedList.toString())
        linkedList.addFirst(10)
        assertEquals(listOf(10).toString(), linkedList.toString())
        linkedList.addFirst(20)
        linkedList.addFirst(30)
        assertEquals(listOf(30, 20, 10).toString(), linkedList.toString())
        assertEquals(3, linkedList.size())

    }

    @Test
    fun testAddLast() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        assertEquals(listOf(10).toString(), linkedList.toString())
        linkedList.addLast(20)
        linkedList.addLast(30)
        assertEquals(listOf(10, 20, 30).toString(), linkedList.toString())
        assertEquals(3, linkedList.size())
    }

    @Test
    fun testDeleteFirst() {
        val linkedList = MyLinkedList()
        linkedList.addFirst(10)
        linkedList.addFirst(20)
        linkedList.addFirst(30)
        assertEquals(listOf(30, 20, 10).toString(), linkedList.toString())
        linkedList.deleteFirst()
        linkedList.deleteFirst()
        assertEquals(listOf(10).toString(), linkedList.toString())
        linkedList.deleteFirst()
        assertEquals("[]", linkedList.toString())
        assertEquals(0, linkedList.size())
    }


    @Test
    fun testDeleteLast() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.deleteLast()
        assertEquals(listOf(10, 20).toString(), linkedList.toString())
        linkedList.deleteLast()
        linkedList.deleteLast()
        assertEquals("[]", linkedList.toString())
        assertEquals(0, linkedList.size())
    }

    @Test
    fun containsTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        assertEquals(true, linkedList.contains(10))
        assertEquals(true, linkedList.contains(30))
    }

    @Test
    fun indexOfTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        assertEquals(-1, linkedList.indexOf(1))
        assertEquals(2, linkedList.indexOf(30))
    }

    @Test
    fun reverseTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.reverse()
        assertEquals(listOf(30, 20, 10).toString(), linkedList.toString())
    }

    @Test
    fun kFromTheEndTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.addLast(40)
        linkedList.addLast(50)

        assertEquals(50, linkedList.getKthFromTheEnd(1))
        assertEquals(30, linkedList.getKthFromTheEnd(3))
        assertEquals(50, linkedList.getKthFromTheEndWithoutSize(1))
        assertEquals(30, linkedList.getKthFromTheEndWithoutSize(3))
        assertThrows(IllegalArgumentException::class.java) {
            linkedList.getKthFromTheEndWithoutSize(-1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            linkedList.getKthFromTheEndWithoutSize(6)
        }
        assertThrows(IllegalStateException::class.java) {
            MyLinkedList().getKthFromTheEndWithoutSize(1)
        }

    }

    @Test
    fun printMiddleTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.addLast(40)
        linkedList.addLast(50)
        assertEquals("30", linkedList.printMiddle())

        linkedList.addLast(60)
        assertEquals("30\n40", linkedList.printMiddle())
    }
    @Test
    fun hasLoopTest() {
        val linkedList = MyLinkedList()
        linkedList.addLast(10)
        linkedList.addLast(20)
        linkedList.addLast(30)
        linkedList.addLast(40)
        linkedList.addLast(50)
        assertEquals("30", linkedList.printMiddle())

        linkedList.addLast(60)
        assertEquals("30\n40", linkedList.printMiddle())
    }



}