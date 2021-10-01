package section2

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

internal class MyGraphTest {
    @Test
    fun test1() {
        val graph = MyGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addEdge("a", "b")
        graph.addEdge("a", "c")
        graph.addEdge("b", "a")
        graph.print()
        graph.removeEdge("a", "c")
        graph.print()
        graph.removeNode("a")
        graph.print()
    }

    @Test
    fun test2() {
        val graph = MyGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addNode("d")
        graph.addEdge("a", "b")
        graph.addEdge("b", "d")
        graph.addEdge("d", "c")
        graph.addEdge("a", "c")
        graph.traverseDepthFirst("a")
        graph.traverseDepthFirstStack("a")
    }

    @Test
    fun test3() {
        val graph = MyGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addNode("d")
        graph.addEdge("a", "b")
        graph.addEdge("a", "c")
        graph.addEdge("b", "d")
        graph.addEdge("d", "c")
        graph.traverseBreathFirst("a")

    }

    @Test
    fun test4() {
        val graph = MyGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("x")
        graph.addNode("p")
        graph.addEdge("x", "a")
        graph.addEdge("x", "b")
        graph.addEdge("b", "p")
        graph.addEdge("a", "p")
        graph.topologicalSort()
            .also { println(it) }

    }

    @Test
    fun test5() {
        val graph = MyGraph()
        graph.addNode("a")
        graph.addNode("b")
        graph.addNode("c")
        graph.addNode("d")
        graph.addEdge("a", "b")
        graph.addEdge("b", "c")
        graph.addEdge("c", "a")
        graph.addEdge("d", "a")
        assertTrue(graph.hasCycle())

        graph.removeEdge("c", "a")
        graph.addEdge("a", "c")
        assertFalse(graph.hasCycle())
    }


}