package section3

import kotlin.system.measureTimeMillis

class Search {
    fun linearSearch(array: Array<Int>, num: Int): Int {
        for (i in array.indices) {
            if (array[i] == num) {
                return i
            }
        }
        return -1
    }

    fun binarySearch(array: Array<Int>, num: Int): Int {
        return binarySearchR(array, num, 0, array.size - 1)
    }

    private fun binarySearchR(array: Array<Int>, num: Int, left: Int, right: Int): Int {
        if (left > right) {
            return -1
        }

        val middle = left + (right - left) / 2
        return when {
            array[middle] == num -> middle
            num < array[middle] -> binarySearchR(array, num, left, middle - 1)
            else -> binarySearchR(array, num, middle + 1, right)
        }
    }

    fun binarySearch2(array: Array<Int>, num: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left <= right) {
            val middle = left + (right - left) / 2
            when {
                array[middle] == num -> return middle
                num < array[middle] -> right = middle - 1
                else -> left = middle + 1
            }
        }
        return -1
    }

}