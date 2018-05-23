package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.graph.logic.domain.ADVVertex;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.graph.logic.domain.GraphModule;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;
import ch.hsr.stack.model.Stack;

import java.util.List;


public class DepthFirstSearch {

    private static final Stack<Vertex<String>> stack = new Stack<>();
    private static final Graph graph = new Graph();
    private static final GraphModule graphModule = new GraphModule("Depth First Search", graph);

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // initiate modules
        StackModule stackModule = new StackModule(stack);
        graphModule.addChildModule(stackModule);

        Vertex<String> a = new Vertex<>("A");
        a.setFixedPosX(20);
        a.setFixedPosY(20);
        Vertex<String> b = new Vertex<>("B");
        b.setFixedPosX(100);
        b.setFixedPosY(20);
        Vertex<String> c = new Vertex<>("C");
        c.setFixedPosX(180);
        c.setFixedPosY(20);
        Vertex<String> d = new Vertex<>("D");
        d.setFixedPosX(20);
        d.setFixedPosY(80);
        Vertex<String> e = new Vertex<>("E");
        e.setFixedPosX(100);
        e.setFixedPosY(80);
        Vertex<String> f = new Vertex<>("F");
        f.setFixedPosX(180);
        f.setFixedPosY(80);

        graph.addVertices(a, b, c, d, e, f);

        Edge<Integer> ab = new Edge<>(a, b, true);
        Edge<Integer> ad = new Edge<>(a, d, true);
        Edge<Integer> be = new Edge<>(b, e, true);
        Edge<Integer> db = new Edge<>(d, b, true);
        Edge<Integer> ed = new Edge<>(e, d, true);
        Edge<Integer> ec = new Edge<>(e, c, true);
        Edge<Integer> cf = new Edge<>(c, f, true);
        Edge<Integer> ff = new Edge<>(f, f, true);


        graph.addEdges(ab, ad, be, db, ed, ec, cf, ff);

        dfs(a);

        ADV.disconnect();
    }

    private static void dfs(Vertex startNode) throws ADVException {
        stack.push(startNode);
        ADV.snapshot(graphModule);

        int visitationOrder = 0;

        while (!stack.isEmpty()) {

            Vertex<String> current = stack.pop();
            current.setStyle(new ADVSuccessStyle());
            current.setVisited(true);
            ADV.snapshot(graphModule);

            List<ADVVertex> neighbours = graph.getNeighbors(current);
            for (ADVVertex n : neighbours) {
                Vertex neighbour = (Vertex) n;

                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    neighbour.setStyle(new ADVInfoStyle());
                    stack.push(neighbour);

                    ADV.snapshot(graphModule);
                }
            }

            // display path
            try {
                Vertex<String> next = stack.top();
                Edge edge = current.getEdgeTo(next);
                edge.setStyle(new ADVErrorStyle());
                edge.setLabel(visitationOrder++);
            } catch (Exception e) {
            }
        }
    }

}


