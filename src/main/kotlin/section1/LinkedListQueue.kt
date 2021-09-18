package section1

import java.util.*

class LinkedListQueue {

    var items = LinkedList<Int>()


    fun enqueue(item: Int) {
        items.addLast(item)
    }

    fun dequeue(): Int {
        return items.removeFirst()
    }

    override fun toString(): String {
        return items.toList().toString()
    }

    fun peek(): Int {
        return items.peekFirst()
    }

    fun size(): Int {
        return items.size
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }


}