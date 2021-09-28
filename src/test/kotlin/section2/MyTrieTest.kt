package section2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

internal class MyTrieTest {
    @Test
    fun test1() {
        val trie = MyTrie()
        trie.insert("app")
        trie.insert("apple")
        trie.insert("abc")
        trie.insert("about")
        assertEquals(false, trie.contains("ap"))
        assertEquals(true, trie.contains("app"))
        assertEquals(false, trie.contains("apple2"))
        assertEquals(false, trie.contains(""))

        trie.remove("app2")
        assertEquals(true, trie.contains("apple"))
        assertEquals(true, trie.contains("app"))

    }

    @Test
    fun test2() {
        val trie = MyTrie()
        trie.insert("app")
        trie.insert("apple")
        trie.insert("abc")
        trie.insert("about")

        trie.remove("app")
        assertEquals(false, trie.contains("app"))
        assertEquals(true, trie.contains("apple"))
    }

    @Test
    fun test3() {
        val trie = MyTrie()
        trie.insert("app")
        trie.insert("apple")
        trie.insert("abc")
        trie.insert("about")

        trie.remove("apple")
        assertEquals(true, trie.contains("app"))
        assertEquals(false, trie.contains("apple"))

        assertEquals(true, trie.containsRecursive("app"))
        assertEquals(false, trie.containsRecursive("apple"))
    }

    @Test
    fun test4() {
        val trie = MyTrie()
        trie.insert("care")
        trie.insert("car")

        trie.remove("care")
        assertEquals(false, trie.contains("care"))
        assertEquals(true, trie.contains("car"))
    }


    @Test
    fun test5() {
        val trie = MyTrie()
        trie.insert("card")
        trie.insert("car")
        trie.insert("care")
        trie.insert("egg")
        assertThat(trie.findWords("car")).containsExactlyInAnyOrder("card", "care",  "car")
        assertThat(trie.findWords("")).containsExactlyInAnyOrder("card", "care",  "car", "egg")
        assertThat(trie.findWords("egg")).containsExactlyInAnyOrder("egg")
        assertThat(trie.findWords("cc")).containsExactlyInAnyOrder()
    }


    @Test
    fun test6() {
        val trie = MyTrie()
        trie.add("card")
        trie.add("car")
        trie.add("care")
        trie.add("egg")
        assertThat(trie.findWords("car")).containsExactlyInAnyOrder("card", "care",  "car")
        assertThat(trie.findWords("")).containsExactlyInAnyOrder("card", "care",  "car", "egg")
        assertThat(trie.findWords("egg")).containsExactlyInAnyOrder("egg")
        assertThat(trie.findWords("cc")).containsExactlyInAnyOrder()

        trie.add("egg")
        trie.add("egg1")
        trie.add("eggplant")
        assertThat(trie.countWords()).isEqualTo(6)
    }

    @Test
    fun test7() {
        val trie = MyTrie()
        assertThat(trie.longestCommonPrefix("care", "card")).isEqualTo("car")
        assertThat(trie.longestCommonPrefix("car", "care")).isEqualTo("car")
        assertThat(trie.longestCommonPrefix("car", "dog")).isEqualTo("")
        assertThat(trie.longestCommonPrefix("car")).isEqualTo("car")


    }

}