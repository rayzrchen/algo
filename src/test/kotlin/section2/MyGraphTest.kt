package section2

import org.junit.jupiter.api.Test

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
        graph.addEdge("a", "c")
        graph.addEdge("c", "d")
        graph.addEdge("b", "a")
        graph.traverseDepthFirst("a")
    }


}