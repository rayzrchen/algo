package section2


class AVLNode(
    var content: Int,
    var left: AVLNode? = null,
    var right: AVLNode? = null,
    var height: Int = 0
) {
    override fun toString(): String {
        return "$content"
    }
}

class AVLTree {
    var root: AVLNode? = null

    fun insert(content: Int) {
        root = insertRecursive(root, content)
    }

    private fun insertRecursive(node: AVLNode?, content: Int): AVLNode {
        if (node == null) {
            return AVLNode(content)
        }

        if (node.content > content) {
            node.left = insertRecursive(node.left, content)
        } else {
            node.right = insertRecursive(node.right, content)
        }

        setHeight(node)

        return balance(node)
    }

    private fun balance(node: AVLNode): AVLNode {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.left) < 0) {
                node.left = leftRotate(node.left!!)
            }
            return rightRotate(node)
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.right) > 0) {
                node.right = rightRotate(node.right!!)
            }
            return leftRotate(node)
        }
        return node
    }

    private fun rightRotate(node: AVLNode): AVLNode {
        val newRoot = node.left
        node.left = newRoot?.right
        newRoot!!.right = node
        return newRoot
    }

    private fun leftRotate(node: AVLNode): AVLNode {
        val newRoot = node.right
        node.right = newRoot?.left
        newRoot!!.left = node
        setHeight(node)
        setHeight(newRoot)
        return newRoot
    }

    private fun setHeight(node: AVLNode) {
        node.height = maxOf(height(node.left), height(node.right)) + 1
    }

    private fun isRightHeavy(node: AVLNode?): Boolean = balanceFactor(node) < -1

    private fun isLeftHeavy(node: AVLNode?): Boolean = balanceFactor(node) > 1

    private fun balanceFactor(node: AVLNode?) = if (node == null) 0 else height(node.left) - height(node.right)

    private fun height(node: AVLNode?): Int {
        if (node == null) {
            return -1
        }
        return node.height
    }

    override fun toString(): String {
        return traverseTreeRecursive(root).toString()
    }

    private fun traverseTreeRecursive(node: AVLNode?): List<String> {
        if (node == null) {
            return emptyList()
        }
        return traverseTreeRecursive(node.left)
            .plus(listOf("${node.content}"))
            .plus(traverseTreeRecursive(node.right))
    }

}