package ch.hsr.graph;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;
import ch.hsr.graph.model.MyGraph;

public class MultipleEdgesGraph {

    public static void main(String[] args) throws ADVException {
        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        MyGraph graph = new MyGraph();
        GraphModule<String, Integer> module = new GraphModule<>("Multiple Edges", graph);
     //   ADV.snapshot(module, "Initial empty graph");

        ADVVertex<String> a = graph.insertVertex("A");
        a.setFixedPosX(200);
        a.setFixedPosY(50);
        ADVVertex<String> b = graph.insertVertex("B");
        b.setFixedPosX(500);
        b.setFixedPosY(50);
        ADVVertex<String> c = graph.insertVertex("C");
        c.setFixedPosX(650);
        c.setFixedPosY(200);
        ADVVertex<String> d = graph.insertVertex("D");
        d.setFixedPosX(500);
        d.setFixedPosY(350);
        ADVVertex<String> e = graph.insertVertex("E");
        e.setFixedPosX(200);
        e.setFixedPosY(350);
        ADVVertex<String> f = graph.insertVertex("F");
        f.setFixedPosX(50);
        f.setFixedPosY(200);

        graph.insertEdge(1, a, b);
        graph.insertEdge(11, a, b);
        graph.insertEdge(2, a, c);
        graph.insertEdge(22, a, c);
        graph.insertEdge(3, a, d);
        graph.insertEdge(33, a, d);
        graph.insertEdge(4, a, e);
        graph.insertEdge(44,a, e);
        graph.insertEdge(5, a, f);
        graph.insertEdge(55, a, f);

        ADV.snapshot(module, "Insert edges");

        ADV.disconnect();
    }
}
