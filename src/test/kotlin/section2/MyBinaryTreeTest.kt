package section2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

internal class MyBinaryTreeTest {
    @Test
    fun test1() {
        val tree = MyBinaryTree()
        tree.insert(7)
        tree.insert(4)
        tree.insert(9)
        tree.insert(1)
        tree.insert(6)
        tree.insert(8)
        tree.insert(10)

        assertEquals(true, tree.find(10))
        assertEquals(false, tree.find(15))
//        tree.traversePreOrder()
//        tree.traverseInOrder()
//        tree.traversePostOrder()
        println(tree.toString())
    }

    @Test
    fun test3() {
        val tree = MyBinaryTree()
        assertEquals(-1, tree.height())
        tree.insert(7)
        assertEquals(0, tree.height())
        tree.insert(4)
        assertEquals(1, tree.height())
        tree.insert(9)
        tree.insert(1)
        tree.insert(6)
        tree.insert(8)
        tree.insert(10)
        assertEquals(2, tree.height())
        assertEquals(1, tree.min())
        assertEquals(tree.quickMin(), tree.min())

        val tree2 = MyBinaryTree()
        tree2.insert(7)
        tree2.insert(4)
        tree2.insert(9)
        tree2.insert(1)
        tree2.insert(6)
        tree2.insert(8)
        tree2.insert(10)
        assertEquals(tree, tree2)
    }

    @Test
    fun test2() {
        val tree = MyBinaryTree()
        val range1 = 10 until 100 step 10
        range1.forEach {
            tree.insert(it)
        }
        range1.forEach {
            assertEquals(true, tree.find(it))
        }
        tree.traversePreOrder()
    }


    @Test
    fun isValidTest() {
        val tree2 = MyBinaryTree()
        tree2.insert(20)
        tree2.insert(10)
        tree2.insert(30)
        assertTrue(tree2.isValid())

    }

    @Test
    fun exerciseTest() {
        val tree = MyBinaryTree()
        val list = listOf(20, 10, 30, 6, 14, 24, 3, 8, 26)
        list
            .forEach {
                tree.insert(it)
            }
        tree.traversePreOrder()
        tree.traverseInOrder()
        tree.traversePostOrder()
        tree.traverseBreathFirst()

        assertEquals(list.size, tree.size())
        assertEquals(4, tree.countLeaves())
        assertEquals(30, tree.max())
        assertEquals(true, tree.contains(30))
        assertEquals(true, tree.contains(8))
        assertEquals(false, tree.contains(29))
        assertEquals(true, tree.areSibling(6, 14))
        assertEquals(true, tree.areSibling(14, 6))
        assertEquals(false, tree.areSibling(6, 8))
        assertEquals(listOf(6, 10, 20), tree.getAncestors(3))
        assertEquals(listOf(6, 10, 20), tree.ancestorsOf(3))
    }

}