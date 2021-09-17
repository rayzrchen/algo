package section1

import java.lang.IllegalArgumentException


class MyLinkedList {

    class Node(val value: Int) {
        var next: Node? = null
    }

    private var size = 0

    fun addFirst(item: Int) {
        val newNode = Node(item)
        if (isEmpty()) {
            first = newNode
            last = newNode
        } else {
            newNode.next = first
            first = newNode
        }
        size++
    }

    fun addLast(item: Int) {
        val newNode = Node(item)
        if (isEmpty()) {
            last = newNode
            first = newNode
        } else {
            last!!.next = newNode
            last = newNode
        }
        size++
    }

    override fun toString(): String {
        val result = mutableListOf<String>()

        var currentNode = first

        while (currentNode != null) {
            result.add("${currentNode.value}")
            currentNode = currentNode.next
        }

        return result.joinToString(", ", prefix = "[", postfix = "]")
    }

    fun deleteLast() {
        if (last == null) {
            throw IllegalStateException()
        }

        if (first == last) {
            first = null
            last = null
            size--
            return
        }

        last = getPreviousNode(last)
        last!!.next = null

        size--
    }

    private fun getPreviousNode(node: Node?): Node? {
        var currentNode = first
        while (currentNode != null) {
            if (currentNode.next == node) {
                return currentNode
            }
            currentNode = currentNode.next
        }
        return null
    }

    fun deleteFirst() {
        if (isEmpty()) {
            throw NoSuchElementException()
        }

        if (first == last) {
            first = null
            last = null
            size--
            return
        }

        val second = first!!.next
        first!!.next = null
        first = second
        size--
    }

    private fun isEmpty() = first == null

    fun contains(item: Int): Boolean {
        return indexOf(item) != -1
    }

    fun indexOf(item: Int): Int {
        var index = 0
        var current = first
        while (current != null) {
            if (current.value == item) return index
            current = current.next
            index++
        }
        return -1
    }

    fun size(): Int {
        return size
    }

    fun reverse() {
        if (isEmpty() || first == last) {
            return
        }

        var previous = first
        var current = first!!.next
        while (current != null) {
            val next = current.next
            current.next = previous
            previous = current
            current = next
        }

        last = first
        last!!.next = null
        first = previous

    }

    fun getKthFromTheEnd(k: Int): Int {
        if (k <= 0 || k > size) {
            throw IllegalArgumentException()
        }

        var index = 0
        val resultIndex = size - k

        var current = first
        while (current != null) {
            if (index == resultIndex) {
                return current.value
            }
            index++
            current = current.next
        }

        return -1
    }

    fun getKthFromTheEndWithoutSize(k: Int): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        if (k <= 0) {
            throw IllegalArgumentException()
        }

        var head = first
        var tail = first

        repeat(k - 1) {
            tail = tail!!.next
            if (tail!!.next == null) {
                throw IllegalArgumentException()
            }
        }

        while (tail!!.next != null) {
            head = head!!.next
            tail = tail!!.next
        }

        return head!!.value
    }

    fun printMiddle(): String {
        if (isEmpty()) {
            throw IllegalStateException()
        }
        var a = first
        var b = first
        while (b != last && b!!.next != last) {
            b = b.next!!.next
            a = a!!.next
        }

        return if (b == last) {
            a!!.value.toString()
        } else {
            a!!.value.toString() + "\n" + a.next!!.value.toString()
        }

    }

    var first: Node? = null
    var last: Node? = null

}