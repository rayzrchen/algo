package section2

class MyTrie {
    class Node(
        var value: Char,
        var children: MutableMap<Char, Node> = mutableMapOf(),
        var isEndOfWord: Boolean = false
    ) {
        override fun toString(): String {
            return "$value"
        }

        fun hasChild(it: Char) = children[it] != null
        fun addChild(it: Char) {
            children[it] = Node(it)
        }

        fun getChild(it: Char) = children[it]
        fun getChildren() = children.map { it.value }.toList()
        fun remove(ch: Char) {
            children.remove(ch)
        }

        fun hasNoChildren() = children.isEmpty()

        fun setChild(node: Node) {
            children[node.value] = node
        }
    }

    var root: Node = Node(' ')

    fun add(word: String) {
        root = addR(root, word)
    }

    private fun addR(node: Node, word: String, index: Int = 0): Node {
        if (index == word.length) {
            node.isEndOfWord = true
            return node
        }

        val char = word[index]
        val child = node.getChild(char) ?: Node(char)

        node.setChild(addR(child, word, index + 1))

        return node
    }

    fun insert(word: String) {
        var current = root
        word.forEach {
            if (!current.hasChild(it)) {
                current.addChild(it)
            }
            current = current.getChild(it)!!
        }
        current.isEndOfWord = true
    }


    fun contains(word: String): Boolean {
        var current = root
        word.forEach {
            if (!current.hasChild(it)) {
                return false
            }
            current = current.getChild(it)!!
        }
        return current.isEndOfWord
    }

    fun traverse() {
        traverseRecursive(root)
    }

    private fun traverseRecursive(node: Node) {
        node.getChildren().forEach {
            traverseRecursive(it)
        }
        println(node.value)
    }

    fun remove(word: String) {
        remove(root, word)
    }

    private fun remove(node: Node, word: String, i: Int = 0) {
        if (i == word.length) {
            node.isEndOfWord = false
            return
        }

        val ch = word[i]
        val child = node.getChild(ch) ?: return
        remove(child, word, i + 1)

        if (child.hasNoChildren() && !child.isEndOfWord) {
            node.remove(ch)
        }
    }

    fun findWords(prefix: String): MutableList<String> {
        val result = mutableListOf<String>()
        val lastNode = findLastNode(prefix)
        findWordsRecursive(lastNode, prefix, result)
        return result
    }

    private fun findLastNode(prefix: String): Node? {
        var current = root
        prefix.forEach {
            current = current.getChild(it) ?: return null
        }
        return current
    }

    private fun findWordsRecursive(node: Node?, prefix: String, words: MutableList<String>) {
        if (node == null) {
            return
        }

        if (node.isEndOfWord) {
            words.add(prefix)
        }

        for (child in node.getChildren()) {
            findWordsRecursive(child, prefix + child.value, words)
        }

    }

    fun containsRecursive(word: String): Boolean {
        return containsRecursiveR(root, word)
    }

    private fun containsRecursiveR(root: Node, word: String, index: Int = 0): Boolean {
        if (index == word.length) {
            return root.isEndOfWord
        }

        val char = word[index]
        val child = root.getChild(char) ?: return false

        return containsRecursiveR(child, word, index + 1)

    }

    fun countWords(): Int {
        val ints = Array(1) { 0 }
        countWordsR(root, ints)
        return ints[0]
    }

    private fun countWordsR(root: Node, ints: Array<Int>) {
        if (root.isEndOfWord) {
            ints[0]++
        }

        for (child in root.getChildren()) {
            countWordsR(child, ints)
        }

    }

    fun longestCommonPrefix(vararg array: String): String {
        root = Node(' ')

        array.forEach {
            insert(it)
        }
        val result = StringBuilder()

        var current = root
        while (current.children.size == 1 ) {
            val node = current.getChildren()[0]
            result.append(node.value)
            if (node.isEndOfWord) {
                break
            }
            current = node
        }

        return result.toString()

    }


}