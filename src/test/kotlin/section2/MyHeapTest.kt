package section2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class MyHeapTest {
    @Test
    fun test1() {
        val heap = MyHeap()
        heap.insert(10)
        heap.insert(20)
        heap.insert(30)
        assertEquals(listOf(30, 10, 20).toString(), heap.toString())
    }

    @Test
    fun test2() {
        val heap = MyHeap()
        heap.insert(10)
        heap.insert(20)
        heap.insert(30)
        heap.insert(40)
        assertEquals(listOf(40, 30, 20, 10).toString(), heap.toString())
        heap.remove(40)
        assertEquals(listOf(30, 10, 20).toString(), heap.toString())
    }

    @Test
    fun test3() {
        val queue = PriorityQueue<Int>(Comparator.reverseOrder())
        queue.add(10)
        queue.add(20)
        queue.add(80)
        queue.add(30)
        queue.add(50)
        queue.remove()
        println(queue.toList())

    }


}