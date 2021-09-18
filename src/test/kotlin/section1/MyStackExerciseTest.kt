package section1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MyStackExerciseTest {
    @Test
    fun reverseTest() {
        assertEquals("dcba", MyStackExercise().reverse("abcd"))
    }

    @Test
    fun checkBalanceTest() {
        assertEquals(true, MyStackExercise().checkBalance("()"))
        assertEquals(false, MyStackExercise().checkBalance(")("))
        assertEquals(false, MyStackExercise().checkBalance("(()"))
        assertEquals(true, MyStackExercise().checkBalance("([avv asd ])"))
        assertEquals(true, MyStackExercise().checkBalance("[(<aa>) + (1+1)]"))
        assertEquals(false, MyStackExercise().checkBalance("[(<qwe]) + (1+1)]"))
        assertEquals(false, MyStackExercise().checkBalance("[<123-12>) + (1+1)]"))
    }
}