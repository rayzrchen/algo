package section3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchTest {
    @Test
    fun linearSearchTest1() {
        assertThat(Search().linearSearch(arrayOf(1, 4, 3, 10, 5), 10)).isEqualTo(3)
        assertThat(Search().linearSearch(arrayOf(1, 4, 3, 10, 5), 2)).isEqualTo(-1)
    }

    @Test
    fun binarySearchTest1() {
        assertThat(Search().binarySearch(arrayOf(1, 3, 5, 7, 10), 10)).isEqualTo(4)
        assertThat(Search().binarySearch(arrayOf(1, 3, 5, 7, 10), 2)).isEqualTo(-1)
        assertThat(Search().binarySearch2(arrayOf(1, 3, 5, 7, 10), 10)).isEqualTo(4)
        assertThat(Search().binarySearch2(arrayOf(1, 3, 5, 7, 10), 2)).isEqualTo(-1)


    }

    @Test
    fun test1() {
        println(listOf(1, 2, 3, 5, 6, 10).binarySearch(10))
    }
}