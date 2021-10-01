package section3

class Sort {

    fun bubbleSort(numbers: Array<Int>) {
        var isSorted: Boolean
        for (i in numbers.indices) {
            isSorted = true
            for (j in 1 until numbers.size - i) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1)
                    isSorted = false
                }
            }
            if (isSorted) {
                return
            }
        }
    }

    private fun swap(array: Array<Int>, i: Int, j: Int) {
        val temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }

    fun selectionSort(list: Array<Int>) {
        for (i in list.indices) {
            val minIndex = findMinIndex(i, list)
            swap(list, minIndex, i)
        }
    }

    private fun findMinIndex(i: Int, list: Array<Int>): Int {
        var minIndex = i
        for (j in i until list.size) {
            if (list[j] < list[minIndex]) {
                minIndex = j
            }
        }
        return minIndex
    }

    fun insertionSort(list: Array<Int>) {
        if (list.isEmpty()) {
            return
        }

        for (i in 1 until list.size) {
            val current = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > current) {
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = current
        }
    }

    fun mergeSort(list: Array<Int>) {
        if (list.size < 2) {
            return
        }

        val middle = list.size / 2
        val left = Array(middle) { 0 }
        list.copyInto(left, 0, 0, middle)
        val right = Array(list.size - middle) { 0 }
        list.copyInto(right, 0, middle, list.size)

        mergeSort(left)
        mergeSort(right)

        merge(left, right, list)
    }

    private fun merge(left: Array<Int>, right: Array<Int>, result: Array<Int>) {
        var i = 0
        var j = 0
        var k = 0
        while (i < left.size && j < right.size) {
            result[k++] = if (left[i] <= right[j]) {
                left[i++]
            } else {
                right[j++]
            }
        }
        while (i < left.size) {
            result[k++] = left[i++]
        }
        while (j < right.size) {
            result[k++] = right[j++]
        }
    }

    fun quickSort(list: Array<Int>) {
        quickSortR(list, 0, list.size - 1)
    }

    private fun quickSortR(list: Array<Int>, left: Int, right: Int) {
        if (left >= right) {
            return
        }
        val boundary = partition(list, left, right)
        quickSortR(list, left, boundary - 1)
        quickSortR(list, boundary + 1, right)
    }

    private fun partition(list: Array<Int>, left: Int, right: Int): Int {
        val pivot = list[right]
        var boundary = left - 1
        for (i in left until right + 1) {
            if (list[i] <= pivot) {
                swap(list, i, ++boundary)
            }
        }
        return boundary
    }

    fun countingSort(list: Array<Int>) {
        val k = list.maxOrNull() ?: throw IllegalArgumentException()
        val countingArray = Array(k + 1) { 0 }

        list.forEach {
            countingArray[it]++
        }

        var j = 0
        countingArray.forEachIndexed { index, count ->
            for (i in 0 until count) {
                list[j++] = index
            }
        }
    }

    fun bucketSort(list: Array<Int>) {
        val bucketNumber = 10

        val buckets = Array(bucketNumber) { mutableListOf<Int>() }
        list.forEach {
            buckets[it / bucketNumber].add(it)
        }

        var i = 0
        buckets.forEach { bucket ->
            bucket.sort()
            bucket.forEach {
                list[i++] = it
            }
        }
    }


}