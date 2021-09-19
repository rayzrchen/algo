package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyHashMapTest {
    @Test
    fun test1() {
        val hashMap = MyHashMap()
        hashMap.put(1, "A")
        hashMap.put(2, "B")
        hashMap.put(6, "C")
        assertEquals("C", hashMap.get(6))
        hashMap.remove(2)
        assertEquals(null, hashMap.get(2))
        assertEquals(2, hashMap.size())
    }
}