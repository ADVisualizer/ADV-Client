package ch.hsr.dfs;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;
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

        // instantiate data structure container
        StackModule stackModule = new StackModule("", stack);
        graphModule.addChildModule(stackModule);

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

        Edge<Integer> ab = new Edge<>(a.getId(), b.getId(), true);
        Edge<Integer> bd = new Edge<>(b.getId(), d.getId(), true);
        Edge<Integer> de = new Edge<>(d.getId(), e.getId(), true);
        Edge<Integer> ae = new Edge<>(a.getId(), e.getId(), true);
        Edge<Integer> cd = new Edge<>(c.getId(), d.getId(), true);
        Edge<Integer> ec = new Edge<>(e.getId(), c.getId(), true);

        graph.addEdges(ab, bd, de, ae, cd, ec);

        dfs(a);

        ADV.disconnect();
    }

    public static void dfs(Vertex startNode) throws ADVException {
        stack.push(startNode);
        startNode.setStyle(new ADVSuccessStyle());
        startNode.setVisited(true);
        ADV.snapshot(graphModule);

        while (!stack.isEmpty()) {

            Vertex<String> element = stack.pop();
            element.setStyle(new ADVSuccessStyle());
            ADV.snapshot(graphModule);

            List<ADVVertex> neighbours = graph.getNeighbors(element);
            for (int i = 0; i < neighbours.size(); i++) {
                Vertex n = (Vertex) neighbours.get(i);
                if (n != null && !n.isVisited()) {
                    n.setStyle(new ADVErrorStyle());
                    stack.push(n);
                    n.setVisited(true);
                    ADV.snapshot(graphModule, "Snapshot " + i);
                }
            }
        }
    }


}


