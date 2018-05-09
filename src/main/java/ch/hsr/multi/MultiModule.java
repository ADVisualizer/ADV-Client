package ch.hsr.multi;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.ADVGraph;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.graph.model.MyGraph;
import ch.hsr.graph.model.MyVertex;
import ch.hsr.stack.model.Stack;

import java.util.Random;


public class MultiModule {

    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();
    private static final MyGraph graph = new MyGraph();
    private static final MyGraph graph2 = new MyGraph();
    private static final GraphModule<String, Integer> graphModule = new GraphModule<>("MultiModule", graph);
    private static final Random rnd = new Random();

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        StackModule<Integer> stackModule = new StackModule<>("Stack", stack1);
        StackModule<Integer> stackModule2 = new StackModule<>("Stack2", stack2);
        GraphModule<String, Integer> graphModule2 = new GraphModule<>("Graph", graph2);
        graphModule.addChildModule(stackModule);
        graphModule.addChildModule(stackModule2);
        graphModule.addChildModule(graphModule2);

        fillGraph(graphModule);
        fillGraph(graphModule2);

        fillStack(stackModule);
        fillStack(stackModule2);

        ADV.snapshot(graphModule);
        ADV.disconnect();
    }

    private static void fillStack(StackModule<Integer> stackModule) {
        for (int i = 0; i < 4; i++) {
            stackModule.getStack().push(rnd.nextInt(10));
        }
    }

    private static void fillGraph(GraphModule<String, Integer> graphModule) {
        ADVGraph<String, Integer> currentGraph = graphModule.getGraph();
        MyVertex a = (MyVertex) currentGraph.insertVertex(rnd.nextInt(10) + "");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        MyVertex b = (MyVertex) currentGraph.insertVertex(rnd.nextInt(10) + "");
        b.setFixedPosX(140);
        b.setFixedPosY(50);
        MyVertex c = (MyVertex) currentGraph.insertVertex(rnd.nextInt(10) + "");
        c.setFixedPosX(180);
        c.setFixedPosY(100);
        MyVertex d = (MyVertex) currentGraph.insertVertex(rnd.nextInt(10) + "");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        MyVertex e = (MyVertex) currentGraph.insertVertex(rnd.nextInt(10) + "");
        e.setFixedPosX(20);
        e.setFixedPosY(100);

        currentGraph.insertEdge(0, a, b);
        currentGraph.insertEdge(0, b, d);
        currentGraph.insertEdge(0, d, e);
        currentGraph.insertEdge(0, a, e);
        currentGraph.insertEdge(0, c, d);
        currentGraph.insertEdge(0, e, c);
    }


}


