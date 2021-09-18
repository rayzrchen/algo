package section1

class MyStack {

    private var size = 3
    private var items = Array(size) { 0 }
    private var current = 0

    fun push(item: Int) {
        if (current >= size) {
            size = (size * 1.5).toInt()
            val newArray = Array(size) { 0 }
            items.forEachIndexed { index, i -> newArray[index] = i }
            items = newArray
        }
        items[current] = item
        current++
    }

    override fun toString(): String {
        return (0 until current).joinToString(", ", "[", "]") { "${items[it]}" }
    }

    fun pop(): Int {
        return items[--current]
    }

    fun peek(): Int {
        return items[current - 1]
    }

    fun isEmpty(): Boolean {
        return current == 0
    }
}