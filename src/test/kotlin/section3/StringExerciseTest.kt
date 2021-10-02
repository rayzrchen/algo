package section3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringExerciseTest {
    @Test
    fun reverseStringTest() {
        assertThat(StringExercise.reverse("hello")).isEqualTo("olleh")
        assertThat(StringExercise.reverse("")).isEqualTo("")
    }

    @Test
    fun findVowelsTest() {
        assertThat(StringExercise.findVowels("hello")).isEqualTo(2)
        assertThat(StringExercise.findVowels("Egg")).isEqualTo(1)
        assertThat(StringExercise.findVowels("Egg Plant")).isEqualTo(2)
        assertThat(StringExercise.findVowels("")).isEqualTo(0)
    }

    @Test
    fun reverseWordsInASentenceTest() {
        assertThat(StringExercise.reverseWordsInASentence("Trees are beautiful")).isEqualTo("beautiful are Trees")
        assertThat(StringExercise.reverseWordsInASentence("aa bb cc dd")).isEqualTo("dd cc bb aa")
        assertThat(StringExercise.reverseWordsInASentence("Trees")).isEqualTo("Trees")
        assertThat(StringExercise.reverseWordsInASentence("")).isEqualTo("")

        assertThat(StringExercise.reverseWordsInASentence2("Trees are beautiful")).isEqualTo("beautiful are Trees")
        assertThat(StringExercise.reverseWordsInASentence2("aa bb cc dd")).isEqualTo("dd cc bb aa")
        assertThat(StringExercise.reverseWordsInASentence2("Trees")).isEqualTo("Trees")
        assertThat(StringExercise.reverseWordsInASentence2("")).isEqualTo("")
    }

    @Test
    fun checkRotationTest() {
        assertThat(StringExercise.checkRotation("ABCD", "DABC")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("ABCD", "ABCD")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("ABCD", "CDAB")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("ABCD", "BCDA")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("ABCDE", "DEABC")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("A", "DABC")).isEqualTo(false)
        assertThat(StringExercise.checkRotation("", "aa")).isEqualTo(false)
        assertThat(StringExercise.checkRotation("", "")).isEqualTo(true)
        assertThat(StringExercise.checkRotation("aaaab", "aabaa")).isEqualTo(true)
    }

    @Test
    fun removeDuplicateTest() {
        assertThat(StringExercise.removeDuplicate("Hellooo!!")).isEqualTo("Helo!")
        assertThat(StringExercise.removeDuplicate("")).isEqualTo("")
        assertThat(StringExercise.removeDuplicate("  ")).isEqualTo(" ")
    }


    @Test
    fun mostRepeatedTest() {
        assertThat(StringExercise.mostRepeated("Hellooo!!")).isEqualTo("o")
        assertThat(StringExercise.mostRepeated("")).isEqualTo("")
        assertThat(StringExercise.mostRepeated("   ")).isEqualTo(" ")
    }

    @Test
    fun capitalizeFirstLetterOfEachWordTest() {
        assertThat(StringExercise.capitalizeFirstLetterOfEachWord("trees are beautiful")).isEqualTo("Trees Are Beautiful")
        assertThat(StringExercise.capitalizeFirstLetterOfEachWord("   trees    are    beautiful")).isEqualTo("Trees Are Beautiful")
        assertThat(StringExercise.capitalizeFirstLetterOfEachWord("       ")).isEqualTo("")
    }

    @Test
    fun checkAnagramTest() {
        assertThat(StringExercise.checkAnagram("abcd", "adbc")).isEqualTo(true)
        assertThat(StringExercise.checkAnagram("abcd", "cadb")).isEqualTo(true)
        assertThat(StringExercise.checkAnagram("abcd", "abcd")).isEqualTo(true)
        assertThat(StringExercise.checkAnagram("abcd", "abce")).isEqualTo(false)
    }

    @Test
    fun checkPalindromeTest() {
        assertThat(StringExercise.checkPalindrome("abba")).isEqualTo(true)
        assertThat(StringExercise.checkPalindrome("abcba")).isEqualTo(true)
        assertThat(StringExercise.checkPalindrome("abca")).isEqualTo(false)
    }

}