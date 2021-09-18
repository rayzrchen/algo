package section1

import java.util.concurrent.ArrayBlockingQueue

class StackWithTwoQueues {

    var queue1 = ArrayBlockingQueue<Int>(10)
    var queue2 = ArrayBlockingQueue<Int>(10)

    fun push(item: Int) {
        queue1.add(item)
    }

    fun pop(): Int {
        moveFrom1To2()
        return queue2.remove()
    }

    private fun moveFrom1To2() {
        if (queue2.isEmpty()) {
            while (queue1.isNotEmpty()) {
                queue2.add(queue1.remove())
            }
        }
        queue2.reversed()
    }

    fun peek(): Int {
        moveFrom1To2()
        return queue2.peek()
    }

    fun size(): Int {
        return queue1.size + queue2.size
    }

    fun isEmpty(): Boolean {
        return queue1.isEmpty() && queue2.isEmpty()
    }
}