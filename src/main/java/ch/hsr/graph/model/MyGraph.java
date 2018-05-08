package ch.hsr.graph.model;

import ch.hsr.adv.lib.graph.logic.domain.ADVEdge;
import ch.hsr.adv.lib.graph.logic.domain.ADVGraph;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyGraph implements ADVGraph<String, Integer> {

    private Collection<ADVVertex<String>> vertices = new ArrayList<>();
    private Collection<ADVEdge<Integer>> edges = new ArrayList<>();

    @Override
    public ADVVertex<String> insertVertex(String value) {
        MyVertex vertex = new MyVertex();
        vertex.setValue(value);
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public ADVEdge<Integer> insertEdge(Integer value, ADVVertex<String> start,
                                       ADVVertex<String> end) {
        MyEdge edge = new MyEdge();
        edge.setValue(value);
        edge.setStartVertex(start);
        edge.setEndVertex(end);
        edges.add(edge);
        return edge;
    }

    @Override
    public void removeVertex(ADVVertex<String> vertex) {
        vertices.remove(vertex);
    }

    @Override
    public void removeEdge(ADVEdge edge) {
        edges.remove(edge);
    }

    @Override
    public Collection<ADVVertex<String>> getVertices() {
        return vertices;
    }

    @Override
    public Collection<ADVEdge<Integer>> getEdges() {
        return edges;
    }

    public List<ADVEdge> outgoingEdges(ADVVertex vertex) {
        return edges.stream()
                .filter(e -> e.getStarVertex() == vertex)
                .collect(Collectors.toList());
    }

    public List<ADVVertex> neighbors(ADVVertex vertex) {
        return outgoingEdges(vertex).stream().map(e -> e.getEndVertex()).collect(Collectors.toList());
    }


}
