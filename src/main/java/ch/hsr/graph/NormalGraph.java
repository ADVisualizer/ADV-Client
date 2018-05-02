package ch.hsr.graph;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;
import ch.hsr.graph.model.MyGraph;

public class NormalGraph {

    public static void main(String[] args) throws ADVException {
        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        MyGraph graph = new MyGraph();
        GraphModule<String, Integer> module = new GraphModule<>("Normal Graph Session", graph);
     //   ADV.snapshot(module, "Initial empty graph");

        ADVVertex<String> a = graph.insertVertex("A");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        ADVVertex<String> b = graph.insertVertex("B");
        b.setFixedPosX(140);
        b.setFixedPosY(50);
        ADVVertex<String> c = graph.insertVertex("C");
        c.setFixedPosX(180);
        c.setFixedPosY(100);
        ADVVertex<String> d = graph.insertVertex("D");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        ADVVertex<String> e = graph.insertVertex("E");
        e.setFixedPosX(20);
        e.setFixedPosY(100);
        ADV.snapshot(module, "Insert vertices");

        graph.insertEdge(1, a, b);
        graph.insertEdge(2, a, c);
        graph.insertEdge(3, c, b);
        graph.insertEdge(4, e, d);
        graph.insertEdge(5, e, b);
        ADV.snapshot(module, "Insert edges");

        ADV.disconnect();
    }
}
