package section3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SortTest {
    @Test
    fun bubbleSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().bubbleSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun bubbleSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().bubbleSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

    @Test
    fun selectionSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().selectionSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun selectionSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().selectionSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

    @Test
    fun insertionSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().insertionSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun insertionSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().insertionSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

    @Test
    fun mergeSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().mergeSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun mergeSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().mergeSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

    @Test
    fun quickSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().quickSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun quickSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().quickSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

   @Test
    fun countingSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().countingSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun countingSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().countingSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }

   @Test
    fun bucketSortTest() {
        val list = listOf(7, 3, 1, 4, 6, 2, 3).toTypedArray()
        Sort().bucketSort(list)
        assertThat(list.contentToString()).isEqualTo(listOf(1, 2, 3, 3, 4, 6, 7).toString())
    }

    @Test
    fun bucketSortTest2() {
        val list = emptyList<Int>().toTypedArray()
        Sort().bucketSort(list)
        assertThat(list.contentToString()).isEqualTo("[]")
    }
}