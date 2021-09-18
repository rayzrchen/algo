package section1

import java.util.*

class StackQueue {

    var stack1 = Stack<Int>()
    var stack2 = Stack<Int>()

    fun enqueue(item: Int) {
        stack1.push(item)
    }

    fun dequeue(): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        moveStackFrom1To2()

        return stack2.pop()
    }

    private fun moveStackFrom1To2() {
        if (stack2.isEmpty()) {
            while (stack1.isNotEmpty()) {
                stack2.push(stack1.pop())
            }
        }
    }

    fun isEmpty(): Boolean {
        return stack1.isEmpty() && stack2.isEmpty()
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw IllegalStateException()
        }

        moveStackFrom1To2()

        return stack2.peek()
    }

    override fun toString(): String {
        while (stack2.isNotEmpty()) {
            stack1.push(stack2.pop())
        }
        return stack1.toString()
    }

}