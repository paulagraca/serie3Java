package series.serie3.graphCollections;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GraphTest {

    @Test
    public void graph_empty() {
        GraphStructure<Integer, String> graph = new GraphStructure<>();
        assertEquals(0, graph.size());
    }

    @Test
    public void graph_singleton() {
        GraphStructure<Integer, String> graph = new GraphStructure<>();
        graph.addVertex(1, "V1");
        graph.addVertex(1, "V1");
        assertEquals(1, graph.size());
        assertEquals("V1", graph.getVertex(1).getData());
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        assertTrue(graph.getEdge(1, 2) != null);
        assertTrue(graph.getEdge(1, 3) != null);
        graph.addEdge(1, 4);
        assertTrue(graph.getEdge(1, 4) != null);
    }

    @Test
    public void graph_equalElements() {
        GraphStructure<Integer, String> graph = new GraphStructure();
        HashSet<String> setV = new HashSet();
        for (int id = 1; id <= 4; id++)
            graph.addVertex(id, "V" + id);
        assertEquals(4, graph.size());
        for (int id= 1; id <= 4; id++)
            for (int id2 = 1; id2 <= 4; id2++)
                if (id2 != id) graph.addEdge(id, id2);
        for (Graph.Vertex<Integer, String > v: graph)
            setV.add(v.getData());
        HashSet<String> set = new HashSet();
        set.add("V1"); set.add("V2"); set.add("V3"); set.add("V4");
        assertEquals(setV, set);
        for (int id = 1; id <= 4; id++) {
            HashSet<Integer> setE = new HashSet();
            for (Graph.Edge<Integer> e: graph.getVertex(id).getAdjacencies())
                setE.add(e.getIdAdj());
            HashSet<Integer> set2 = new HashSet();
            for (int id2 = 1; id2 <= 4; id2++)
                if (id2 != id) set2.add(id2);
            assertEquals(setE, set2);
        }
    }

    @Test
    public void graph_someElements() {
        GraphStructure<Integer, String> graph = new GraphStructure();
        for (int id = 0; id <= 99; id++)
            graph.addVertex(id, "V" + id);
        assertEquals(100, graph.size());
        for (int id= 0; id <= 99; id++)
            for (int id2 = 0; id2 <= 99; id2++)
                if (id2 != id) graph.addEdge(id, id2);
        HashSet<String> setV = new HashSet();
        for (int id = 0; id <= 99; id++)
            setV.add(graph.getVertex(id).getData());
        HashSet<String> set = new HashSet();
        for (int id = 0; id <= 99; id++)
            set.add("V" + id);
        assertEquals(setV, set);
    }

}

















