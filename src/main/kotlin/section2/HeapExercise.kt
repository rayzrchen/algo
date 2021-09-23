package section2

import java.util.*

class HeapExercise {
    companion object {
        fun heapify(array: Array<Int>) {
            for (i in (array.size / 2 - 1 downTo 0)) {
                heapifyRecursive(array, i, array.size)
            }
        }

        private fun heapifyRecursive(array: Array<Int>, i: Int, size: Int) {
            var largerIndex = i
            val leftIndex = i * 2 + 1
            if (leftIndex < size && array[leftIndex] > array[i]) {
                largerIndex = leftIndex
            }

            val rightIndex = i * 2 + 2
            if (rightIndex < size && array[rightIndex] > array[largerIndex]) {
                largerIndex = rightIndex
            }

            if (i == largerIndex) {
                return
            }

            swap(array, i, largerIndex)
            heapifyRecursive(array, largerIndex, size)

        }

        private fun swap(array: Array<Int>, i: Int, j: Int) {
            val tmp = array[i]
            array[i] = array[j]
            array[j] = tmp
        }

        fun getKthLargest(array: Array<Int>, k: Int): Int? {
            if (k < 1 || k > array.size) {
                throw IllegalArgumentException()
            }
            val queue = PriorityQueue<Int>(Comparator.reverseOrder())
            array.forEach {
                queue.add(it)
            }

            repeat(k - 1) {
                queue.remove()
            }

            return queue.peek()
        }
    }
}