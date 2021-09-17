package section1

class MyArray(intSize: Int) {

    private var items = Array(intSize) { 0 }
    private var currentSize = intSize
    private var current = 0

    fun insert(value: Int) {
        if (current >= currentSize) {
            currentSize = (currentSize * 1.5).toInt()
            val newArray = Array(currentSize) { 0 }
            items.forEachIndexed { index, i ->
                newArray[index] = i
            }
            items = newArray
        }

        items[current] = value
        current++
    }

    fun print(): String {
        return (0 until current).joinToString(", ", prefix = "[", postfix = "]") { items[it].toString() }
    }

    fun removeAt(index: Int) {
        if (index < 0 || index >= current) {
            throw IllegalArgumentException()
        }

        (index until current - 1).forEach {
            items[it] = items[it + 1]
        }
        current--
    }

    fun indexOf(value: Int): Int {
        (0 until current).forEach { if (items[it] == value) return it }
        return -1
    }


    init {
        if (intSize <= 0) {
            throw IllegalArgumentException()
        }
    }

}