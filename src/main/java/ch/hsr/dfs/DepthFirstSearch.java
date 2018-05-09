package ch.hsr.dfs;

import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.util.ADVException;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;
import ch.hsr.adv.lib.stack.logic.StackModule;
import ch.hsr.graph.model.MyGraph;
import ch.hsr.graph.model.MyVertex;
import ch.hsr.stack.model.Stack;

import java.util.List;


public class DepthFirstSearch {

    private static final Stack<MyVertex> stack = new Stack<>();
    private static final MyGraph graph = new MyGraph();
    private static final GraphModule<String, Integer> graphModule = new GraphModule<>("Depth First Search", graph);

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // instantiate data structure container
        StackModule<Integer> stackModule = new StackModule("", stack);
        graphModule.addChildModule(stackModule);

        MyVertex a = (MyVertex) graph.insertVertex("A");
        a.setFixedPosX(60);
        a.setFixedPosY(50);
        MyVertex b = (MyVertex) graph.insertVertex("B");
        b.setFixedPosX(140);
        b.setFixedPosY(50);
        MyVertex c = (MyVertex) graph.insertVertex("C");
        c.setFixedPosX(180);
        c.setFixedPosY(100);
        MyVertex d = (MyVertex) graph.insertVertex("D");
        d.setFixedPosX(100);
        d.setFixedPosY(150);
        MyVertex e = (MyVertex) graph.insertVertex("E");
        e.setFixedPosX(20);
        e.setFixedPosY(100);

        graph.insertEdge(0, a, b);
        graph.insertEdge(0, b, d);
        graph.insertEdge(0, d, e);
        graph.insertEdge(0, a, e);
        graph.insertEdge(0, c, d);
        graph.insertEdge(0, e, c);

        dfs(a);

        ADV.disconnect();
    }

    public static void dfs(MyVertex startNode) throws ADVException {
        stack.push(startNode);
        startNode.setVisisted(true);
        ADV.snapshot(graphModule);

        while (!stack.isEmpty()) {
            MyVertex element = stack.pop();
            ADV.snapshot(graphModule);

            List<ADVVertex> neighbours = graph.neighbors(element);
            for (int i = 0; i < neighbours.size(); i++) {
                MyVertex n = (MyVertex) neighbours.get(i);
                if (n != null && !n.isVisisted()) {
                    stack.push(n);
                    n.setVisisted(true);
                    ADV.snapshot(graphModule, "Snapshot " + i);
                }
            }
        }
    }


}


