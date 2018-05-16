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

        ADVVertex<String> a = graph.insertVertex("A");
        a.setFixedPosX(200);
        a.setFixedPosY(200);
        ADVVertex<String> b = graph.insertVertex("B");
        b.setFixedPosX(200);
        b.setFixedPosY(100);
        ADVVertex<String> c = graph.insertVertex("C");
        c.setFixedPosX(280);
        c.setFixedPosY(120);
        ADVVertex<String> d = graph.insertVertex("D");
        d.setFixedPosX(300);
        d.setFixedPosY(200);
        ADVVertex<String> e = graph.insertVertex("E");
        e.setFixedPosX(280);
        e.setFixedPosY(280);
        ADVVertex<String> f = graph.insertVertex("F");
        f.setFixedPosX(200);
        f.setFixedPosY(300);
        ADVVertex<String> g = graph.insertVertex("G");
        g.setFixedPosX(120);
        g.setFixedPosY(280);
        ADVVertex<String> h = graph.insertVertex("H");
        h.setFixedPosX(100);
        h.setFixedPosY(200);
        ADVVertex<String> i = graph.insertVertex("I");
        i.setFixedPosX(120);
        i.setFixedPosY(120);

        graph.insertEdge(1, a, b);
        graph.insertEdge(2, a, c);
        graph.insertEdge(3, a, d);
        graph.insertEdge(4, a, e);
        graph.insertEdge(5, a, f);
        graph.insertEdge(6, a, g);
        graph.insertEdge(7, a, h);
        graph.insertEdge(8, a, i);

        ADV.snapshot(module, "Insert edges");

        graph.insertEdge(11, a, b);
        graph.insertEdge(22, a, c);
        graph.insertEdge(33, a, d);
        graph.insertEdge(44, a, e);
        graph.insertEdge(55, a, f);
        graph.insertEdge(66, a, g);
        graph.insertEdge(77, a, h);
        graph.insertEdge(88, a, i);

        ADV.snapshot(module, "Insert duplicated edges");

        ADV.disconnect();
    }
}
