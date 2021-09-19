package section2

class MyBinaryTree {
    private class Node(var value: Int, var leftChild: Node? = null, var rightChild: Node? = null) {
        override fun toString(): String {
            return "Node = $value"
        }
    }

    private var root: Node? = null

    fun insert(v: Int) {

        val newNode = Node(v)

        if (root == null) {
            root = newNode
            return
        }

        var current = root
        while (true) {
            if (v > current!!.value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode
                    break
                }
                current = current.rightChild
            } else {
                if (current.leftChild == null) {
                    current.leftChild = newNode
                    break
                }
                current = current.leftChild
            }
        }
    }

    fun find(v: Int): Boolean {
        var current = root
        while (current != null) {
            current = when {
                current.value > v -> current.leftChild
                current.value < v -> current.rightChild
                else -> return true
            }
        }

        return false
    }

    fun traversePreOrder() {
        traversePreOrder(root)
        println()
    }

    private fun traversePreOrder(node: Node?) {
        if (node == null) {
            return
        }
        print("${node.value}, ")
        traversePreOrder(node.leftChild)
        traversePreOrder(node.rightChild)
    }

    fun traverseInOrder() {
        traverseInOrder(root)
        println()
    }

    private fun traverseInOrder(node: Node?) {
        if (node == null) {
            return
        }
        traverseInOrder(node.leftChild)
        print("${node.value}, ")
        traverseInOrder(node.rightChild)
    }

    fun traversePostOrder() {
        traversePostOrder(root)
        println()
    }

    private fun traversePostOrder(node: Node?) {
        if (node == null) {
            return
        }
        traversePostOrder(node.leftChild)
        traversePostOrder(node.rightChild)
        print("${node.value}, ")
    }

    fun height(): Int {
        return height(root)
    }

    private fun height(node: Node?): Int {
        if (node == null) {
            return -1
        }

        if (isLeaf(node)) {
            return 0
        }

        return 1 + maxOf(
            height(node.leftChild),
            height(node.rightChild)
        )
    }

    private fun isLeaf(node: Node) = node.leftChild == null && node.rightChild == null

    fun min(): Int {
        return minRecursive(root)
    }

    private fun minRecursive(node: Node?): Int {
        if (node == null) {
            return Int.MIN_VALUE
        }

        if (isLeaf(node)) {
            return node.value
        }

        return minOf(minRecursive(node.leftChild), minRecursive(node.rightChild), root!!.value)
    }

    fun quickMin(): Int {
        if (root == null) {
            return Int.MIN_VALUE
        }
        var current = root
        var last = current
        while (current != null) {
            last = current
            current = current.leftChild
        }

        return last!!.value
    }

    override fun equals(other: Any?): Boolean {
        val objectEqual = super.equals(other)
        return objectEqual || equals(root, (other as MyBinaryTree).root)
    }

    private fun equals(first: Node?, second: Node?): Boolean {
        return when {
            first == null && second == null -> true
            first != null && second != null -> (first.value == second.value)
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild)
            else -> false
        }
    }

    override fun toString(): String {
        return traverseTreeRecursive(root).toString()
    }

    private fun traverseTreeRecursive(node: Node?): List<String> {
        if (node == null) {
            return emptyList()
        }
        return listOf("${node.value}")
            .plus(traverseTreeRecursive(node.leftChild))
            .plus(traverseTreeRecursive(node.rightChild))
    }

    override fun hashCode(): Int {
        return root?.hashCode() ?: 0
    }


    fun isValid(): Boolean {
        return isValidRecursive(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun isValidRecursive(node: Node?, min: Int, max: Int): Boolean {
        if (node == null) {
            return true
        }
        return node.value in (min until max)
                && isValidRecursive(node.leftChild, min, node.value)
                && isValidRecursive(node.rightChild, node.value, max)
    }

    fun traverseBreathFirst() {
        val height = height()
        for (i in 0..height) {
            printCurrentLevel(root, i)
        }
        println()
    }

    private fun printCurrentLevel(node: Node?, height: Int) {
        if (node == null) {
            return
        }
        if (height == 0) {
            print("${node.value} ")
        } else {
            printCurrentLevel(node.leftChild, height - 1)
            printCurrentLevel(node.rightChild, height - 1)
        }
    }

    fun size(): Int {
        return sizeRecursive(root)
    }

    private fun sizeRecursive(node: Node?): Int {
        if (node == null) {
            return 0
        }

        return 1 + sizeRecursive(node.leftChild) + sizeRecursive(node.rightChild)
    }

    fun countLeaves(): Int {
        return countLeavesRecursive(root)
    }

    private fun countLeavesRecursive(node: Node?): Int {
        if (node == null) {
            return 0
        }

        return if (isLeaf(node)) {
            1
        } else {
            countLeavesRecursive(node.leftChild) + countLeavesRecursive(node.rightChild)
        }
    }

    fun max(): Int {
        return maxRecursive(root)
    }

    private fun maxRecursive(node: Node?): Int {
        if (node == null) {
            return Int.MIN_VALUE
        }

        return maxOf(node.value, maxRecursive(node.leftChild), maxRecursive(node.rightChild))
    }

    fun contains(v: Int): Boolean {
        return containsRecursive(v, root)
    }

    private fun containsRecursive(v: Int, node: Node?): Boolean {
        if (node == null) {
            return false
        }

        if (node.value == v) {
            return true
        }

        return containsRecursive(v, node.leftChild) || containsRecursive(v, node.rightChild)
    }

    fun areSibling(value1: Int, value2: Int): Boolean {
        return areSiblingRecursive(value1, value2, root)
    }

    private fun areSiblingRecursive(value1: Int, value2: Int, node: Node?): Boolean {
        if (node == null) {
            return false
        }

        if (node.leftChild != null && node.rightChild != null) {
            return (node.leftChild!!.value == value1 && node.rightChild!!.value == value2)
                    || (node.leftChild!!.value == value2 && node.rightChild!!.value == value1)
                    || areSiblingRecursive(value1, value2, node.leftChild)
                    || areSiblingRecursive(value1, value2, node.rightChild)
        }

        return false

    }

    fun getAncestors(v: Int): List<Int> {
        if (!find(v)) return emptyList()

        val result = mutableListOf<Int>()
        findAndPopulateResult(v, result)
        while (result.last() != root!!.value) {
            findAndPopulateResult(result.last(), result)
        }
        return result
    }

    private fun findAndPopulateResult(v: Int, result: MutableList<Int>) {
        var current = root
        var previous: Node? = null
        while (current != null) {
            when {
                current.value > v -> {
                    previous = current
                    current = current.leftChild
                }
                current.value < v -> {
                    previous = current
                    current = current.rightChild
                }
                else -> {
                    result.add(previous!!.value)
                    return
                }
            }
        }
    }

    fun ancestorsOf(v: Int): List<Int> {
        val list = mutableListOf<Int>()
        printAncestorsRecursive(v, root, list)
        return list
    }

    private fun printAncestorsRecursive(v: Int, node: Node?, result: MutableList<Int>): Boolean {
        if (node == null) {
            return false
        }

        if (node.value == v) {
            return true
        }

        if (printAncestorsRecursive(v, node.leftChild, result) || printAncestorsRecursive(v, node.rightChild, result)) {
            result.add(node.value)
            return true
        }

        return false
    }

}