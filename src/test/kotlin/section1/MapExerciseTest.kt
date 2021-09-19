package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MapExerciseTest {
    @Test
    fun getFirstNonRepeatedCharacterTest() {
        assertEquals("g", MapExercise().getFirstNonRepeatedCharacter("a green apple"))
    }

    @Test
    fun getFirstRepeatedCharacterTest() {
        assertEquals("e", MapExercise().getFirstRepeatedCharacter("green apple"))
    }

    @Test
    fun mostFrequentTest() {
        assertEquals(3, MapExercise().mostFrequent(listOf(1, 2, 2, 3, 3, 3, 4)))
    }


    @Test
    fun countPairsWithDiffTest() {
        assertEquals(4, MapExercise().countPairsWithDiff(listOf(1, 7, 5, 9, 2, 12, 3), 2))
    }

    @Test
    fun twoSumTest() {
        assertEquals(listOf(0, 1), MapExercise().twoSum(listOf(2, 7, 11, 15), 9))
    }
}