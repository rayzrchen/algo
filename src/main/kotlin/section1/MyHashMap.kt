package section1

class MyHashMap {

    private class Entry(var k: Int, var v: String)

    private val size = 5
    private var entries = Array<Entry?>(size) { null }
    private var count = 0

    fun put(k: Int, v: String) {
        if (isFull()) {
            throw IllegalStateException()
        }

        val newEntry = Entry(k, v)
        val hash = getEmptyHash(k)
        entries[hash] = newEntry
        count++
    }

    private fun getEmptyHash(k: Int): Int {
        val initHash = getInitHash(k)
        var hash = initHash
        while (entries[hash] != null) {
            hash += 1
            if (hash == size) {
                hash = 0
            }
        }
        return hash
    }

    private fun getInitHash(k: Int) = k % 5

    fun get(k: Int): String? {
        val hash = getHashFor(k) ?: return null
        return entries[hash]!!.v
    }

    private fun getHashFor(k: Int): Int? {
        var hash = getInitHash(k)
        while (entries[hash] != null) {
            if (entries[hash]!!.k == k) {
                return hash
            }
            hash += 1
            if (hash == size) {
                hash = 0
            }

        }
        return null
    }

    fun remove(k: Int) {
        if (isEmpty()) {
            throw IllegalStateException()
        }
        val hash = getHashFor(k) ?: throw IllegalStateException()

        entries[hash] = null
        count--
    }

    fun size(): Int {
        return count
    }

    private fun isFull(): Boolean {
        return count == size
    }

    private fun isEmpty(): Boolean {
        return count == 0
    }

}