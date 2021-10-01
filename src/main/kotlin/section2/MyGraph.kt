package section2

import java.util.*
import kotlin.collections.ArrayDeque

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
        println()
    }

    private fun traverseDepthFirstR(startingNode: Node, visited: MutableSet<Node>) {
        print("${startingNode.label}, ")
        visited.add(startingNode)

        adjacencyList[startingNode]!!.forEach {
            if (!visited.contains(it)) traverseDepthFirstR(it, visited)
        }
    }

    fun traverseDepthFirstStack(root: String) {
        val stack = Stack<Node>()
        val visited = mutableSetOf<Node>()

        val node = nodes[root] ?: return
        stack.push(node)

        while (stack.isNotEmpty()) {
            val current = stack.pop()

            print("${current.label}, ")
            visited.add(current)

            adjacencyList[current]!!.forEach {
                if (!visited.contains(it)) {
                    stack.push(it)
                }
            }
        }
        println()

    }

    fun traverseBreathFirst(root: String) {
        val deque = ArrayDeque<Node>()
        val visited = mutableSetOf<Node>()

        val node = nodes[root] ?: return
        deque.add(node)

        while (deque.isNotEmpty()) {
            val current = deque.removeFirst()

            print("${current.label}, ")
            visited.add(current)

            adjacencyList[current]!!.forEach {
                if (!visited.contains(it)) {
                    deque.addLast(it)
                }
            }
        }
        println()

    }

    fun topologicalSort(): List<String> {

        val stack = Stack<Node>()
        val visited = mutableSetOf<Node>()

        nodes.values.forEach {
            topologicalSortR(it, visited, stack)
        }

        return stack.map { it.label }.toList().reversed()
    }

    private fun topologicalSortR(node: Node, visited: MutableSet<Node>, stack: Stack<Node>) {
        if (visited.contains(node)) {
            return
        }
        visited.add(node)

        adjacencyList[node]!!.forEach {
            topologicalSortR(it, visited, stack)
        }

        stack.push(node)
    }

    fun hasCycle(): Boolean {
        val all = mutableSetOf<Node>()
        val visited = mutableSetOf<Node>()
        val visiting = mutableSetOf<Node>()

        all.addAll(nodes.values)

        while (all.isNotEmpty()) {
            if (hasCycleR(all.first(), all, visited, visiting))
            return true
        }
        return false

    }

    private fun hasCycleR(node: Node, all: MutableSet<Node>,visited: MutableSet<Node>, visiting: MutableSet<Node>): Boolean {
        all.remove(node)
        visiting.add(node)

        for (neighbour in adjacencyList[node]!!) {
            if (visited.contains(neighbour)) {
                continue
            }

            if (visiting.contains(neighbour)) {
                return true
            }

            if (hasCycleR(neighbour, all, visited, visiting)) {
                return true
            }
        }

        visiting.remove(node)
        visited.add(node)
        return false
    }


}