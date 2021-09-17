package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyArrayTest {

    @Test
    fun testInit() {
        assertNotNull(MyArray(3))
    }

    @Test
    fun testInitException() {
        assertThrows(IllegalArgumentException::class.java) {
            MyArray(0)
        }
    }

    @Test
    fun testInsert() {
        val myArray = MyArray(2)
        myArray.insert(1)
        assertEquals(listOf(1).toString(), myArray.print())
        myArray.insert(2)
        myArray.insert(3)
        assertEquals(listOf(1, 2, 3).toString(), myArray.print())
        myArray.insert(4)
        (10 until 20 step 2).forEach { myArray.insert(it) }
        assertEquals(listOf(1, 2, 3, 4, 10, 12, 14, 16, 18).toString(), myArray.print())
    }

    @Test
    fun testRemove() {
        val myArray = MyArray(3)
        myArray.insert(1)
        myArray.insert(2)
        myArray.insert(3)
        myArray.removeAt(0)
        assertEquals(listOf(2, 3).toString(), myArray.print())
        myArray.removeAt(1)
        assertEquals(listOf(2).toString(), myArray.print())
        myArray.insert(10)
        myArray.insert(20)
        myArray.insert(30)
        assertEquals(listOf(2, 10, 20, 30).toString(), myArray.print())
    }

    @Test
    fun testRemoveException() {
        val myArray = MyArray(3)
        myArray.insert(1)
        myArray.insert(2)
        assertThrows(IllegalArgumentException::class.java) {
            myArray.removeAt(-1)
        }
        assertThrows(IllegalArgumentException::class.java) {
            myArray.removeAt(2)
        }
    }

    @Test
    fun testIndexOf() {
        val myArray = MyArray(3)
        myArray.insert(1)
        myArray.insert(2)
        myArray.insert(3)
        assertEquals(-1, myArray.indexOf(10))
        assertEquals(1, myArray.indexOf(2))
    }
}