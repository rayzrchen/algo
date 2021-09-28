package section2

class MyGraph {
    class Node(var label: String) {
        override fun toString(): String {
            return "label=$label"
        }

        override fun equals(other: Any?): Boolean {
            if (other == null) {
                return false
            }
            return if (other is Node) {
                other.label == label
            } else {
                false
            }
        }

        override fun hashCode(): Int {
            return label.hashCode()
        }
    }

    var nodes = mutableMapOf<String, Node>()
    var adjacencyList = mutableMapOf<Node, MutableList<Node>>()

    fun addNode(label: String) {
        val node = Node(label)
        nodes.putIfAbsent(label, node)
        adjacencyList[node] = mutableListOf()
    }

    fun removeNode(label: String) {
        val removed = nodes.remove(label) ?: return
        adjacencyList.remove(removed)
        adjacencyList.forEach { (_, u) ->
            u.remove(removed)
        }
    }

    fun addEdge(from: String, to: String) {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()

        adjacencyList[fromNode]!!.add(toNode)
    }

    fun removeEdge(from: String, to: String) {
        val fromNode = nodes[from] ?: return
        val toNode = nodes[to] ?: return

        adjacencyList[fromNode]!!.remove(toNode)
    }

    fun print() {
        adjacencyList.forEach { (t, u) ->
            if (u.isNotEmpty()) {
                println("${t.label} is connected to ${u.map { it.label }}")
            }
        }
    }

    fun traverseDepthFirst(root: String) {
        val node = nodes[root] ?: return
        traverseDepthFirstR(node, mutableSetOf())
    }

    private fun traverseDepthFirstR(startingNode: Node, visited: MutableSet<Node>) {
        println(startingNode.label)
        visited.add(startingNode)

        adjacencyList[startingNode]!!.forEach {
            if (!visited.contains(it)) traverseDepthFirstR(it, visited)
        }
    }


}