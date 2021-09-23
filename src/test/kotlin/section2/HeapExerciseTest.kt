package section2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.util.*

internal class HeapExerciseTest {
    @Test
    fun test1() {
        val array = arrayOf(5, 3, 8, 4, 1, 2, 10, 20, 30, 0, 6, 7)
        HeapExercise.heapify(array)
        assertEquals("[30, 20, 10, 5, 6, 7, 8, 3, 4, 0, 1, 2]", array.contentToString())
    }

    @Test
    fun test3() {
        val queue = PriorityQueue<Int>(Comparator.reverseOrder())
        arrayOf(5, 3, 8, 4, 1, 2, 10, 20, 30, 0, 6, 7).forEach { queue.add(it) }
        while (queue.isNotEmpty()) {
            print( "${queue.remove()}, ")
        }
        println()
    }


    @Test
    fun test2() {
        val array = arrayOf(5, 3, 8, 4, 1, 2)
        assertThrows(IllegalArgumentException::class.java) { HeapExercise.getKthLargest(array, 0) }
        assertEquals(8, HeapExercise.getKthLargest(array, 1))
        assertEquals(5, HeapExercise.getKthLargest(array, 2))
        assertEquals(1, HeapExercise.getKthLargest(array, 6))
        assertThrows(IllegalArgumentException::class.java) { HeapExercise.getKthLargest(array, 7) }
    }


}
