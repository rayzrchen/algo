package section2

class MyHeap {

    var size = 10
    var items: Array<Int> = Array(size) { 0 }
    var count = 0


    fun insert(content: Int) {
        if (isFull()) {
            throw IllegalStateException()
        }
        items[count++] = content
        bubbleUp(count - 1)
    }

    private fun bubbleUp(initIndex: Int) {
        var index = initIndex
        var parentIndex = parentIndex(index)

        while (index > 0 && items[index] > items[parentIndex]) {
            swap(index, parentIndex)
            index = parentIndex
            parentIndex = parentIndex(index)
        }
    }

    private fun parentIndex(index: Int) = (index - 1) / 2

    fun remove(content: Int) {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        var index = -1

        for (i in 0 until count) {
            if (items[i] == content) {
                index = i
                break
            }
        }

        if (index == -1) {
            throw IllegalStateException()
        }

        items[index] = items[--count]
        bubbleDown(index)
    }

    private fun bubbleDown(initIndex: Int) {
        var index = initIndex
        while (index <= count && isNotValidParent(index)) {
            val largerChildIndex = getLargerChildIndex(index)
            swap(index, largerChildIndex)
            index = largerChildIndex
        }
    }

    private fun getLargerChildIndex(index: Int): Int {
        return when {
            hasNoLeftChild(index) -> index
            hasNoRightChild(index) -> leftChildIndex(index)
            getLeftChild(index) > getRightChild(index) -> leftChildIndex(index)
            else -> rightChildIndex(index)
        }
    }

    private fun hasNoRightChild(index: Int) = rightChildIndex(index) > count

    private fun hasNoLeftChild(index: Int) = leftChildIndex(index) > count

    private fun isNotValidParent(index: Int): Boolean {
        return when {
            hasNoRightChild(index) -> false
            hasNoRightChild(index) -> items[index] < getLeftChild(index)
            else -> items[index] < getLeftChild(index) || items[index] < getRightChild(index)
        }
    }

    private fun leftChildIndex(index: Int): Int {
        return (index * 2) + 1
    }

    private fun rightChildIndex(index: Int): Int {
        return (index * 2) + 2
    }

    private fun getRightChild(index: Int): Int {
        return items[rightChildIndex(index)]

    }

    private fun getLeftChild(index: Int): Int {
        return items[leftChildIndex(index)]
    }

    private fun isEmpty(): Boolean {
        return count == 0
    }

    private fun swap(first: Int, second: Int) {
        val temp = items[first]
        items[first] = items[second]
        items[second] = temp
    }

    private fun isFull(): Boolean {
        return count == size
    }

    fun size(): Int {
        return count
    }

    override fun toString(): String {
        return (0 until count).map { items[it] }.toString()
    }
}

