package section1

import java.lang.IllegalArgumentException
import java.util.*

class MyHashTable {

    private class Entry(var key: Int, var value: String) {
        override fun equals(other: Any?): Boolean {
            return super.equals(other) || (other as Entry).key == key
        }

        override fun hashCode(): Int {
            var result = key
            result = 31 * result + value.hashCode()
            return result
        }
    }

    //    private var list = LinkedList<Entry>()
    private val size = 5
    private var items = Array<LinkedList<Entry>?>(size) { null }

    fun put(key: Int, value: String) {
        val hashPosition = getPosition(key)
        if (items[hashPosition] == null) {
            val linkedList = LinkedList<Entry>()
            linkedList.addLast(Entry(key, value))
            items[hashPosition] = linkedList
        } else {
            val linkedList = items[hashPosition]

            if (linkedList!!.contains(Entry(key, value))) {
                linkedList.remove(Entry(key, value))
            }

            linkedList.addLast(Entry(key, value))

        }

    }

    private fun getPosition(key: Int) = key % size


    fun get(key: Int): String? {
        val hashPosition = getPosition(key)
        val linkedList = items[hashPosition] ?: return null
        linkedList.iterator().forEach { if (it.key == key) return it.value }
        return null
    }

    fun remove(key: Int) {
        val hashPosition = getPosition(key)
        val linkedList = items[hashPosition] ?: throw IllegalArgumentException()

        val entry = linkedList.firstOrNull { it.key == key } ?: throw IllegalArgumentException()
        linkedList.remove(entry)

    }
}