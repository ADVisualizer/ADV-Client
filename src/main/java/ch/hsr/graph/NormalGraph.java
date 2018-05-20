package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;

public class NormalGraph {

    public static void main(String[] args) throws ADVException {
        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);

        Graph graph = new Graph();
        GraphModule module = new GraphModule("Normal Graph Session", graph);

        Vertex<String> a = new Vertex<>("A");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        Vertex<String> b = new Vertex<>("B");
        b.setFixedPosX(140);
        b.setFixedPosY(50);
        Vertex<String> c = new Vertex<>("C");
        c.setFixedPosX(180);
        c.setFixedPosY(100);
        Vertex<String> d = new Vertex<>("D");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        Vertex<String> e = new Vertex<>("E");
        e.setFixedPosX(20);
        e.setFixedPosY(100);

        graph.addVertices(a, b, c, d, e);

        ADV.snapshot(module, "Insert vertices");

        Edge<Integer> ab = new Edge<>(a.getId(), b.getId(), true);
        Edge<Integer> bd = new Edge<>(b.getId(), d.getId(), true);
        Edge<Integer> de = new Edge<>(d.getId(), e.getId(), true);
        Edge<Integer> ae = new Edge<>(a.getId(), e.getId(), true);
        Edge<Integer> cd = new Edge<>(c.getId(), d.getId(), true);
        Edge<Integer> ec = new Edge<>(e.getId(), c.getId(), true);

        graph.addEdges(ab, bd, de, ae, cd, ec);

        ADV.snapshot(module, "Insert edges");

        ADV.disconnect();
    }
}
