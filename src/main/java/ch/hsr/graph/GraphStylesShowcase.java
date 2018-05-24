package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.domain.styles.presets.ADVDefaultElementStyle;
import ch.hsr.adv.commons.core.logic.domain.styles.presets.ADVDefaultRelationStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.graph.logic.domain.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.*;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;

public class GraphStylesShowcase {

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        Graph graph = new Graph();
        GraphModule module = new GraphModule("Graph Styles Showcase", graph);

        // ---- 1: insert vertices ---- //
        Vertex<String> a = new Vertex<>("Default");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        Vertex<String> b = new Vertex<>("Visited");
        b.setFixedPosX(200);
        b.setFixedPosY(50);
        Vertex<String> c = new Vertex<>("C");
        c.setFixedPosX(250);
        c.setFixedPosY(150);
        Vertex<String> d = new Vertex<>("D");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        Vertex<String> e = new Vertex<>("E");
        e.setFixedPosX(20);
        e.setFixedPosY(100);

        graph.addVertices(a, b, c, d, e);

        // ---- 2: insert edges ---- //
        Edge<String> ab = new Edge<>(a, b, true);
        ab.setLabel("Default");
        Edge<String> bd = new Edge<>(b, d, true);
        bd.setLabel("Forward");
        Edge<String> de = new Edge<>(d, e, true);
        de.setLabel("Discovery");
        Edge<String> ae = new Edge<>(a, e, true);
        ae.setLabel("Cross");
        Edge<String> cd = new Edge<>(c, d, true);
        cd.setLabel("Back");

        graph.addEdges(ab, bd, de, ae, cd);

        // ---- 4: set style ---- //
        a.setStyle(new ADVDefaultElementStyle());
        b.setStyle(new ADVVisitedNodeStyle());

        ab.setStyle(new ADVDefaultRelationStyle());
        bd.setStyle(new ADVForwardEdgeStyle());
        de.setStyle(new ADVDiscoveryEdgeStyle());
        ae.setStyle(new ADVCrossEdgeStyle());
        cd.setStyle(new ADVBackEdgeStyle());

        ADV.snapshot(module, "Insert back reference");

        ADV.disconnect();
    }

}
