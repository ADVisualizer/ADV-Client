package ch.hsr.graph;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;

public class MultipleEdgesGraph {

    public static void main(String[] args) throws ADVException {
        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);


        Graph graph = new Graph();
        GraphModule module = new GraphModule("Multiple Edges", graph);

        Vertex<String> a = new Vertex<>("A");
        a.setFixedPosX(200);
        a.setFixedPosY(50);
        Vertex<String> b = new Vertex<>("B");
        b.setFixedPosX(500);
        b.setFixedPosY(50);
        Vertex<String> c = new Vertex<>("C");
        c.setFixedPosX(650);
        c.setFixedPosY(200);
        Vertex<String> d = new Vertex<>("D");
        d.setFixedPosX(500);
        d.setFixedPosY(350);
        Vertex<String> e = new Vertex<>("E");
        e.setFixedPosX(200);
        e.setFixedPosY(350);
        Vertex<String> f = new Vertex<>("F");
        f.setFixedPosX(50);
        f.setFixedPosY(200);

        graph.addVertices(a, b, c, d, e, f);

        Edge<Integer> ab = new Edge<>(a, b);
        ab.setLabel(1);
        Edge<Integer> ac = new Edge<>(a, c);
        ac.setLabel(2);

        Edge<Integer> ad = new Edge<>(a, d);
        ad.setLabel(3);

        Edge<Integer> ae = new Edge<>(a, e);
        ae.setLabel(4);
        Edge<Integer> af = new Edge<>(a, f);
        af.setLabel(5);

        graph.addEdges(ab, ac, ad, ae, af);
        ADV.snapshot(module, "Insert edges");


        Edge<Integer> ab2 = new Edge<>(a, b);
        ab2.setLabel(11);
        Edge<Integer> ac2 = new Edge<>(a, c);
        ac2.setLabel(22);
        Edge<Integer> ad2 = new Edge<>(a, d);
        ad2.setLabel(33);
        Edge<Integer> ae2 = new Edge<>(a, e);
        ae2.setLabel(44);
        Edge<Integer> af2 = new Edge<>(a, f);
        af2.setLabel(55);

        graph.addEdges(ab2, ac2, ad2, ae2, af2);
        ADV.snapshot(module, "Insert duplicated edges");

        ADV.disconnect();
    }
}
