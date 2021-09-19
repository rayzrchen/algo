package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyHashTableTest {
    @Test
    fun test1() {
        val hashTable = MyHashTable()
        hashTable.put(1, "a")
        hashTable.put(3, "q")
        hashTable.put(5, "u")
        assertEquals("q", hashTable.get(3))
        hashTable.put(3, "v")
        assertEquals("v", hashTable.get(3))
        hashTable.remove(5)
        assertNull(hashTable.get(5))
        assertThrows(IllegalArgumentException::class.java) { hashTable.remove(5) }

        hashTable.put(6, "1111")
        hashTable.put(11, "2222")
        assertEquals("1111", hashTable.get(6))
        assertEquals("2222", hashTable.get(11))

        hashTable.remove(6)
        hashTable.remove(11)
        assertNotEquals("1111", hashTable.get(6))
        assertNotEquals("2222", hashTable.get(11))
    }
}