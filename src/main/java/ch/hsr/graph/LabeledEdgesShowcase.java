package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.graph.logic.domain.GraphModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;

public class LabeledEdgesShowcase {

    public static void main(String[] args) throws ADVException {
        // opens ADV UI in a standalone process
        // creates a socket connection to the ADV UI
        // throws an exception if something didn't work as expected
        ADV.launch(args);


        Graph graph = new Graph();
        GraphModule module = new GraphModule("Multiple Edges", graph);

        Vertex<String> a = new Vertex<>("A");
        a.setFixedPosX(200);
        a.setFixedPosY(200);
        Vertex<String> b = new Vertex<>("B");
        b.setFixedPosX(200);
        b.setFixedPosY(100);
        Vertex<String> c = new Vertex<>("C");
        c.setFixedPosX(280);
        c.setFixedPosY(120);
        Vertex<String> d = new Vertex<>("D");
        d.setFixedPosX(300);
        d.setFixedPosY(200);
        Vertex<String> e = new Vertex<>("E");
        e.setFixedPosX(280);
        e.setFixedPosY(280);
        Vertex<String> f = new Vertex<>("F");
        f.setFixedPosX(200);
        f.setFixedPosY(300);
        Vertex<String> g = new Vertex<>("G");
        g.setFixedPosX(120);
        g.setFixedPosY(280);
        Vertex<String> h = new Vertex<>("H");
        h.setFixedPosX(100);
        h.setFixedPosY(200);
        Vertex<String> i = new Vertex<>("I");
        i.setFixedPosX(120);
        i.setFixedPosY(120);


        graph.addVertices(a, b, c, d, e, f, g, h, i);

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
        Edge<Integer> ag = new Edge<>(a, g);
        ag.setLabel(6);
        Edge<Integer> ah = new Edge<>(a, h);
        ah.setLabel(7);
        Edge<Integer> ai = new Edge<>(a, i);
        ai.setLabel(8);

        graph.addEdges(ab, ac, ad, ae, af, ag, ah, ai);
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
        Edge<Integer> ag2 = new Edge<>(a, g);
        ag2.setLabel(66);
        Edge<Integer> ah2= new Edge<>(a, h);
        ah2.setLabel(77);
        Edge<Integer> ai2 = new Edge<>(a, i);
        ai2.setLabel(88);

        graph.addEdges(ab2, ac2, ad2, ae2, af2, ag2, ah2, ai2);
        ADV.snapshot(module, "Insert duplicated edges");


        Edge<Integer> cc = new Edge<>(c,c);
        cc.setLabel(0);
        Edge<Integer> gg = new Edge<>(g,g);
        gg.setLabel(0);

        graph.addEdges(cc, gg);
        ADV.snapshot(module, "Insert self reference edges");
    }
}
