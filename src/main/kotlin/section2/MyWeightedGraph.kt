package section2

import java.util.*

class MyWeightedGraph {
    class Node(var label: String) {
        private val edges: MutableList<Edge> = mutableListOf()

        fun addEdge(to: Node, weight: Int) {
            edges.add(Edge(this, to, weight))
        }

        fun getEdges(): MutableList<Edge> {
            return edges
        }

        override fun toString(): String {
            return if (edges.isNotEmpty()) {
                "$label is connected to $edges"
            } else {
                "$label connects to nothing"
            }
        }
    }

    class Edge(var from: Node, var to: Node, var weight: Int) : Comparable<Edge> {
        override fun toString(): String {
            return "${from.label}->${to.label}"
        }

        override fun compareTo(other: Edge): Int {
            return weight - other.weight
        }

    }

    class NodeEntry(val node: Node, val priority: Int) : Comparable<NodeEntry> {
        override fun compareTo(other: NodeEntry): Int {
            return priority - other.priority
        }
    }

    var nodes: MutableMap<String, Node> = mutableMapOf()

    fun addNode(label: String) {
        nodes[label] = Node(label)
    }

    fun addEdge(from: String, to: String, weight: Int) {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()
        fromNode.addEdge(toNode, weight)
        toNode.addEdge(fromNode, weight)
    }

    fun print() {
        nodes.values.forEach {
            println(it)
        }
    }


    fun getShortestDistance(from: String, to: String): Int {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()

        val distances = nodes.values.associateWith {
            Int.MAX_VALUE
        }.toMutableMap()

        distances[fromNode] = 0

        val visited = mutableSetOf<Node>()

        val queue = PriorityQueue<NodeEntry>()
        queue.add(NodeEntry(fromNode, 0))

        while (queue.isNotEmpty()) {
            val current = queue.remove().node
            visited.add(current)

            for (edge in current.getEdges()) {
                if (visited.contains(edge.to)) {
                    continue
                }
                val newDistance = distances[current]!! + edge.weight
                if (newDistance < distances[edge.to]!!) {
                    distances[edge.to] = newDistance
                    queue.add(NodeEntry(edge.to, newDistance))
                }
            }
        }
        return distances[toNode]!!
    }

    fun getShortestPath(from: String, to: String): Path {
        val fromNode = nodes[from] ?: throw IllegalArgumentException()
        val toNode = nodes[to] ?: throw IllegalArgumentException()

        val visited = mutableSetOf<Node>()
        val distances = initDistances(fromNode)
        val previousNodes = mutableMapOf<Node, Node>()

        traverseGraph(fromNode, visited, distances, previousNodes)

        return buildPath(toNode, previousNodes)
    }

    private fun traverseGraph(
        fromNode: Node,
        visited: MutableSet<Node>,
        distances: MutableMap<Node, Int>,
        previousNodes: MutableMap<Node, Node>,
    ) {
        val queue = PriorityQueue<NodeEntry>()
        queue.add(NodeEntry(fromNode, 0))

        while (queue.isNotEmpty()) {
            val current = queue.remove().node
            visited.add(current)

            for (edge in current.getEdges()) {
                if (visited.contains(edge.to)) {
                    continue
                }
                val newDistance = distances[current]!! + edge.weight
                if (newDistance < distances[edge.to]!!) {
                    distances[edge.to] = newDistance
                    previousNodes[edge.to] = current
                    queue.add(NodeEntry(edge.to, newDistance))
                }
            }
        }
    }

    private fun initDistances(fromNode: Node): MutableMap<Node, Int> {
        val distances = nodes.values.associateWith {
            Int.MAX_VALUE
        }.toMutableMap()
        distances[fromNode] = 0
        return distances
    }

    private fun buildPath(toNode: Node, previousNodes: MutableMap<Node, Node>): Path {
        val result = Path()
        result.addNode(toNode.label)
        var current = previousNodes[toNode]
        while (current != null) {
            result.addNode(current.label)
            current = previousNodes[current]
        }
        return result
    }

    fun hasCycle(): Boolean {
        val visited = mutableSetOf<Node>()
        for (node in nodes.values) {
            if (!visited.contains(node) && hasCycleR(node, null, visited)) {
                return true
            }
        }

        return false
    }

    private fun hasCycleR(node: Node, parent: Node?, visited: MutableSet<Node>): Boolean {
        visited.add(node)
        for (edge in node.getEdges()) {
            if (edge.to == parent) {
                continue
            }
            if (visited.contains(edge.to) ||
                hasCycleR(edge.to, node, visited)
            ) {
                return true
            }
        }
        return false
    }
}

class Path {
    private val nodes = mutableListOf<String>()
    fun addNode(node: String) {
        nodes.add(node)
    }

    override fun toString(): String {
        return nodes.reversed().toString()
    }
}

