package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.graph.logic.domain.ADVVertex;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVInfoStyle;
import ch.hsr.adv.lib.graph.logic.domain.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.ADVVisitedNodeStyle;
import ch.hsr.adv.lib.queue.logic.QueueModule;
import ch.hsr.adv.lib.queue.logic.domain.ADVQueue;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;
import ch.hsr.queue.model.FIFOQueue;

import java.util.List;

public class BreadthFirstSearch {
    private static final ADVQueue<Vertex<String>> queue = new FIFOQueue<>();
    private static final Graph graph = new Graph();
    private static final GraphModule graphModule = new GraphModule("Breadth First Search", graph);

    public static void main(String[] args) throws ADVException {

        ADV.launch(args);

        // initiate modules
        QueueModule queueModule = new QueueModule(queue);
        graphModule.addChildModule(queueModule);

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

        bfs(a);
    }

    private static void bfs(Vertex startNode) throws ADVException {
        // initialize bfs
        queue.insert(startNode);
        startNode.setStyle(new ADVInfoStyle());
        startNode.setVisited(true);
        ADV.snapshot(graphModule, "Initial state");

        Vertex<String> current = startNode;

        ADVQueue<Edge> path = new FIFOQueue<>();
        int visitationOrder = 0;

        // start bfs
        while (!queue.isEmpty()) {
            // show path
            current = queue.removeMin();
            current.setStyle(new ADVVisitedNodeStyle());
            if (!path.isEmpty()) {
                Edge currentEdge = path.removeMin();
                currentEdge.setStyle(new ADVVisitedNodeStyle());
                currentEdge.setLabel(visitationOrder++);
            }
            ADV.snapshot(graphModule, "Go to: " + current.toString());

            // add neighbours to queue
            List<ADVVertex> neighbours = graph.getNeighbors(current);
            for (ADVVertex n : neighbours) {
                Vertex neighbour = (Vertex) n;

                if (!neighbour.isVisited()) {
                    neighbour.setVisited(true);
                    neighbour.setStyle(new ADVInfoStyle());

                    // add to path
                    Edge edge = current.getEdgeTo(neighbour);
                    path.insert(edge);

                    queue.insert(neighbour);
                    ADV.snapshot(graphModule, "visit " + neighbour.toString());
                }
            }
        }
    }
}