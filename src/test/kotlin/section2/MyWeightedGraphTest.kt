package section2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class MyWeightedGraphTest {
    @Test
    fun test1() {
        val graph = MyWeightedGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addEdge("a", "b", 1)
        graph.print()
    }

    @Test
    fun testShortestDistance() {
        val graph = MyWeightedGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addEdge("a", "b", 1)
        graph.addEdge("a", "c", 10)
        graph.addEdge("b", "c", 2)
        assertThat(graph.getShortestDistance("a", "c")).isEqualTo(3)
    }

    @Test
    fun testShortestPath() {
        val graph = MyWeightedGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addNode("d")
        graph.addEdge("a", "b", 1)
        graph.addEdge("a", "c", 10)
        graph.addEdge("b", "d", 2)
        graph.addEdge("d", "c", 3)
        assertThat(graph.getShortestPath("a", "c").toString()).isEqualTo(listOf("a", "b", "d", "c").toString())
    }

    @Test
    fun hasCycleTest() {
        val graph = MyWeightedGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addNode("d")
        graph.addEdge("a", "b", 1)
        graph.addEdge("b", "d", 2)
        graph.addEdge("d", "c", 3)
        assertThat(graph.hasCycle()).isFalse
        graph.addEdge("a", "c", 10)
        assertThat(graph.hasCycle()).isTrue
    }

    @Test
    fun getMinimumSpanningTreeTest() {
        val graph = MyWeightedGraph()
//        graph.addNode("a")
//        graph.addNode("b")
//        graph.addNode("c")
//        graph.addNode("d")
//        graph.addEdge("a", "b", 3)
//        graph.addEdge("b", "d", 4)
//        graph.addEdge("c", "d", 5)
//        graph.addEdge("a", "c", 1)
//        graph.addEdge("b", "c", 2)
        assertThat(graph.getMinimumSpanningTree().toString()).isEqualTo("[]")
//        assertThat(graph.getMinimumSpanningTree().toString()).isEqualTo(listOf("a", "c", "b","d").toString())
    }

    @Test
    fun priorityQueueTest() {
        val queue = PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        queue.add(3)
        queue.add(5)
        queue.add(1)
        while (queue.isNotEmpty()) {
            println(queue.remove())
        }
    }

    @Test
    fun priorityQueue2Test() {
        val queue = PriorityQueue<MyClass> { o1, o2 -> o2.compareTo(o1) }
        queue.add(MyClass("a", 3))
        queue.add(MyClass("b", 5))
        queue.add(MyClass("c", 1))
        while (queue.isNotEmpty()) {
            println(queue.remove())
        }
    }



}

class MyClass(private val lastName: String, private val age: Int) : Comparable<MyClass> {
    override fun compareTo(other: MyClass): Int {
        return lastName.compareTo(other.lastName)
    }

    override fun toString(): String {
        return lastName
    }
}