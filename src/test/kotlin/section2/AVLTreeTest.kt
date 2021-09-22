package section2

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AVLTreeTest {
    @Test
    fun test1() {
        val tree = AVLTree()
        val range = (1..20).toList()
        range.forEach { tree.insert(it) }
        assertEquals(range.toString(), range.toString())
    }
}