package ch.hsr.multi;


import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.graph.logic.domain.GraphModule;
import ch.hsr.adv.lib.queue.logic.QueueModule;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;
import ch.hsr.queue.model.FIFOQueue;
import ch.hsr.stack.model.Stack;

import java.util.Random;


public class MultiModule {
    // Datastructures
    private static final Stack<Integer> stack = new Stack<>();
    private static final FIFOQueue<Integer> queue = new FIFOQueue<>();
    private static final Graph graph = new Graph();
    private static final Integer[] array = new Integer[5];

    // ADVModules
    private static final String SESSION_NAME = "Multiple Modules";
    private static final QueueModule queueModule = new QueueModule(SESSION_NAME, queue);
    private static final GraphModule graphModule = new GraphModule(SESSION_NAME, graph);
    private static final StackModule stackModule = new StackModule(SESSION_NAME, stack);
    private static final ArrayModule arrayModule = new ArrayModule(SESSION_NAME, array);


    private static final Random RND = new Random();
    private static final int X = 0, Y = 0, R = 100;
    private static final double FIFTEENTH_CIRCLE = Math.PI / 7.5;
    private static final int ELEMENT_AMOUNT = 5;
    private static int index = 0;
    private static double angle = FIFTEENTH_CIRCLE;

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        queueModule.addChildModule(arrayModule);
        queueModule.addChildModule(stackModule);
        queueModule.addChildModule(graphModule);

        fillHelpers();
        ADV.snapshot(queueModule, "Showing stack, queue, array and graph module");

        fillGraph();
        ADV.snapshot(queueModule, "Filling graph from helpers");

        fillGraph();
        ADV.snapshot(queueModule, "Filling graph from helpers");

        fillGraph();
        ADV.snapshot(queueModule, "Filling graph from helpers");

        fillGraph();
        ADV.snapshot(queueModule, "Filling graph from helpers");

        fillGraph();
        ADV.snapshot(queueModule, "Filling graph from helpers");
    }

    private static void fillHelpers() {
        for (int i = 0; i < ELEMENT_AMOUNT; i++) {
            array[i] = RND.nextInt(9) + 1;
            queue.insert(RND.nextInt(10));
            stack.push(RND.nextInt(10));
        }
    }

    private static void fillGraph() {
        double currentAngle = angle;
        Vertex<Integer> a = new Vertex<>(queue.removeMin());
        a.setFixedPosX((int) (X + R * Math.cos(currentAngle)));
        a.setFixedPosY((int) (Y + R * Math.sin(currentAngle)));
        currentAngle += ELEMENT_AMOUNT * FIFTEENTH_CIRCLE;

        int i = index++;
        Vertex<Integer> b = new Vertex<>(array[i]);
        array[i] = 0;
        b.setFixedPosX((int) (X + R * Math.cos(currentAngle)));
        b.setFixedPosY((int) (Y + R * Math.sin(currentAngle)));
        currentAngle += ELEMENT_AMOUNT * FIFTEENTH_CIRCLE;


        Vertex<Integer> c = new Vertex<>(stack.pop());
        c.setFixedPosX((int) (X + R * Math.cos(currentAngle)));
        c.setFixedPosY((int) (Y + R * Math.sin(currentAngle)));
        angle += FIFTEENTH_CIRCLE;

        graph.addVertices(a, b, c);

        Edge ab = new Edge(a.getId(), b.getId());
        Edge bc = new Edge(b.getId(), c.getId());
        graph.addEdges(ab, bc);

        graph.getVertices().stream().findFirst().ifPresent(last -> {
            Edge lasta = new Edge(last.getId(), a.getId(), true);
            graph.addEdges(lasta);
        });


    }
}


