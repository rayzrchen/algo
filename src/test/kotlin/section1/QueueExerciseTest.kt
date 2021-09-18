package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class QueueExerciseTest {
    @Test
    fun reverseTest() {
        val linkedList = LinkedList(listOf(1, 2, 3))
        QueueExercise().reverse(linkedList)
        assertEquals("[3, 2, 1]", linkedList.toList().toString())
    }
}