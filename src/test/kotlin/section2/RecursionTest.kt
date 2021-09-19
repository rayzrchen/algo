package section2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RecursionTest {
    @Test
    fun test1() {
        val factorial2 = Recursion().factorial2(5)
        assertEquals(factorial2, Recursion().factorial(5))
    }
}