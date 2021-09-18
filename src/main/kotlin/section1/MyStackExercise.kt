package section1

import java.lang.StringBuilder
import java.util.*

class MyStackExercise {
    fun reverse(s: String): String {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            stack.push(it)
        }
        val result = StringBuilder()
        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }
        return result.toString()
    }

    private val leftBrackets: CharArray
        get() = "([<{".toCharArray()

    private val rightBrackets: CharArray
        get() = ")]>}".toCharArray()

    fun checkBalance(s: String): Boolean {
        val stack = Stack<Char>()
        s.toCharArray().forEach {
            when {
                leftBrackets.contains(it) -> stack.push(it)
                rightBrackets.contains(it) -> {
                    if (stack.isNotEmpty()) {
                        if (isRightCharMatchedLeft(stack, it)) return false
                    } else {
                        return false
                    }
                }
                else -> {
                }
            }
        }
        return stack.isEmpty()
    }

    private fun isRightCharMatchedLeft(stack: Stack<Char>, rightChar: Char): Boolean {
        return leftBrackets.indexOf(stack.pop()) == rightBrackets.indexOf(rightChar)
    }
}