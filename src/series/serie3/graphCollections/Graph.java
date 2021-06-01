package series.serie3.graphCollections;

import java.util.Iterator;
import java.util.Set;

public interface Graph<I, D> extends Iterable<Graph.Vertex<I,D>>{
    interface Vertex<I, D> {
        I getId();
        D getData();
        D setData(D newData);
        Set<Edge<I>> getAdjacencies();
    }
    interface Edge<I> {
        I getId();
        I getIdAdj();
    }

    int size();
    D addVertex(I id, D d);
    I addEdge(I id, I idAdj);
    Vertex<I, D> getVertex(I id);
    Edge<I> getEdge(I id, I idAdj);
    Iterator<Vertex<I, D>> iterator();
}

