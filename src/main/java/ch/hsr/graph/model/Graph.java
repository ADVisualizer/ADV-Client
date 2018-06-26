package ch.hsr.graph.model;

import ch.hsr.adv.commons.graph.logic.domain.ADVGraph;
import ch.hsr.adv.commons.graph.logic.domain.ADVVertex;

import java.util.*;
import java.util.stream.Collectors;

public class Graph implements ADVGraph<Vertex<String>, Edge<Integer>> {

    private Map<Long, Vertex<String>> vertices = new HashMap<>();
    private List<Edge<Integer>> edges = new LinkedList<>();

    @Override
    public void addVertex(Vertex vertex) {
        vertex.setGraph(this);
        vertices.put(vertex.getId(), vertex);
    }

    @Override
    public void addVertices(Vertex... vertices) {
        Arrays.stream(vertices).forEach(this::addVertex);
    }

    @Override
    public void addEdge(Edge edge) {
        Vertex source = vertices.get(edge.getSourceElementId());
        Vertex target = vertices.get(edge.getTargetElementId());
        if (source != null) {
            source.setOutDegree((source.getOutDegree() + 1));
            if (!edge.isDirected()) {
                source.setInDegree((source.getInDegree() + 1));
            }
        }
        if (target != null) {
            target.setInDegree((target.getInDegree() + 1));
            if (!edge.isDirected()) {
                target.setOutDegree((target.getOutDegree() + 1));
            }
        }

        edges.add(edge);
    }

    @Override
    public void addEdges(Edge... edges) {
        Arrays.stream(edges).forEach(this::addEdge);
    }

    @Override
    public void removeVertex(Vertex vertex) {
        vertices.remove(vertex);
        List<Edge> incidentEdges = edges.stream().filter(e -> {
            boolean b1 = e.getSourceElementId() == vertex.getId();
            boolean b2 = e.getTargetElementId() == vertex.getId();
            return b1 || b2;
        }).collect(Collectors.toList());
        incidentEdges.forEach(this::removeEdge);
    }

    @Override
    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    @Override
    public Collection<Vertex<String>> getVertices() {
        return vertices.values();
    }

    @Override
    public Collection<Edge<Integer>> getEdges() {
        return edges;
    }

    @Override
    public Vertex getVertex(long id) {
        return vertices.get(id);
    }

    @Override
    public void clear() {
        vertices.clear();
        edges.clear();
    }

    @Override
    public List<ADVVertex<Integer>> getNeighbors(ADVVertex source) {
        List<ADVVertex<Integer>> neighbors = new ArrayList<>();
        edges.forEach(e -> {
            if (e.isDirected()) {
                if (e.getSourceElementId() == source.getId()) {
                    ADVVertex vertex = vertices.get(e.getTargetElementId());
                    neighbors.add(vertex);
                }
            } else {
                if (e.getSourceElementId() == source.getId()
                        || e.getTargetElementId() == source.getId()) {
                    ADVVertex vertex = vertices.get(e.getTargetElementId());
                    neighbors.add(vertex);
                }
            }
        });

        return neighbors;
    }

}
