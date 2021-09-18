package section1

import java.util.*
import kotlin.collections.ArrayDeque

class QueueExercise {
    fun reverse(arrayDeque: Queue<Int>) {
        val stack = Stack<Int>()

        while (arrayDeque.isNotEmpty()) {
            stack.push(arrayDeque.remove())
        }

        while (stack.isNotEmpty()) {
            arrayDeque.add(stack.pop())
        }

        ArrayDeque<Int>().reverse()

    }

}