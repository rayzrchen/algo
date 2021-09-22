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
        var index  = initIndex
        var parentIndex = parentIndex(index)

        while (index > 0 && items[index] > items[parentIndex]) {
            swap(index, parentIndex)
            index = parentIndex
            parentIndex = parentIndex(index)
        }
    }

    private fun parentIndex(index: Int) = (index - 1) / 2

    fun remove() {

        count--
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
        return (0 until count).map { items[it] }.joinToString(",")
    }
}

