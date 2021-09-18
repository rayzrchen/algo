package section1

class MyQueue {

    var size = 5
    var front = 0
    var rear = 0
    var items = Array(size) { 0 }
    var count = 0

    fun enqueue(item: Int) {
        if (isFull()) {
            throw IllegalStateException()
        }
        items[rear] = item
        rear = (rear + 1) % size
        count++
    }

    override fun toString(): String {
        return items.toList().toString()
    }

    fun dequeue(): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        val res = items[front]
        items[front] = 0
        front = (front + 1) % size
        count--
        return res
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }
        return items[front]
    }

    fun isEmpty(): Boolean {
        return count == 0
    }

    fun isFull(): Boolean {
        return count >= size
    }

}

class PriorityQueue {

    var size = 5
    var items = Array(size) { 0 }
    var count = 0

    fun insert(item: Int) {
        if (isFull()) {
            throw IllegalStateException()
        }
        val i = shiftItemsToInsert(item)
        items[i] = item
        count++
    }

    fun remove(): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }
        return items[--count]
    }

    private fun shiftItemsToInsert(item: Int): Int {
        var currentPos = count - 1

        while (currentPos >= 0 && items[currentPos] > item) {
            items[currentPos + 1] = items[currentPos]
            currentPos--
        }

        return currentPos + 1
    }

    override fun toString(): String {
        return items.toList().toString()
    }

    private fun isFull(): Boolean = count == size
    private fun isEmpty(): Boolean = count == 0


}