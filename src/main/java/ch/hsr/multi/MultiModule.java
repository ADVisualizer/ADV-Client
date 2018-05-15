package ch.hsr.multi;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;
import ch.hsr.stack.model.Stack;

import java.util.Random;


public class MultiModule {

    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();
    private static final Graph graph = new Graph();
    private static final Graph graph2 = new Graph();
    private static final GraphModule graphModule = new GraphModule("MultiModule", graph);
    private static final Random rnd = new Random();

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        StackModule stackModule = new StackModule("Stack", stack1);
        StackModule stackModule2 = new StackModule("Stack2", stack2);
        GraphModule graphModule2 = new GraphModule("Graph", graph2);
        graphModule.addChildModule(stackModule);
        graphModule.addChildModule(stackModule2);
        graphModule.addChildModule(graphModule2);

        fillGraph(graph);
        fillGraph(graph2);

        fillStack(stackModule);
        fillStack(stackModule2);

        ADV.snapshot(graphModule, "Showing 4 Modules simultaniously");
        ADV.disconnect();
    }

    private static void fillStack(StackModule stackModule) {
        for (int i = 0; i < 4; i++) {
            stackModule.getStack().push(rnd.nextInt(10));
        }
    }

    private static void fillGraph(Graph graph) {
        Vertex<String> a = new Vertex<>(rnd.nextInt(10) + "");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        Vertex<String> b = new Vertex<>(rnd.nextInt(10) + "");
        b.setFixedPosX(140);
        b.setFixedPosY(50);
        Vertex<String> c = new Vertex<>(rnd.nextInt(10) + "");
        c.setFixedPosX(180);
        c.setFixedPosY(100);
        Vertex<String> d = new Vertex<>(rnd.nextInt(10) + "");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        Vertex<String> e = new Vertex<>(rnd.nextInt(10) + "");
        e.setFixedPosX(20);
        e.setFixedPosY(100);

        graph.addVertices(a, b, c, d, e);

        Edge ab = new Edge(a.getId(), b.getId());
        Edge bd = new Edge(b.getId(), d.getId());
        Edge de = new Edge(d.getId(), e.getId());
        Edge ae = new Edge(a.getId(), e.getId());
        Edge cd = new Edge(c.getId(), d.getId());
        Edge ec = new Edge(e.getId(), c.getId());

        graph.addEdges(ab, cd, de, ae, bd, ec);
    }
}


