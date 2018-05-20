package ch.hsr.graph.model;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.lib.graph.logic.domain.ADVGraph;
import ch.hsr.adv.lib.graph.logic.domain.ADVVertex;

import java.util.concurrent.atomic.AtomicInteger;

public class Vertex<T> implements ADVVertex<T> {

    private static final transient AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private long id;
    private ADVGraph<Vertex, Edge> graph;
    private T content;
    private ADVStyle style;
    private int fixedPosX;
    private int fixedPosY;
    private int inDegree;
    private int outDegree;
    private boolean visited;

    public Vertex(T label) {
        this.content = label;
        this.id = ID_COUNTER.incrementAndGet();
    }

    @Override
    public ADVGraph getGraph() {
        return graph;
    }

    public void setGraph(ADVGraph graph) {
        this.graph = graph;
    }

    @Override
    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int degree) {
        this.outDegree = degree;
    }

    @Override
    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int degree) {
        this.inDegree = degree;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public ADVStyle getStyle() {
        return style;
    }

    public void setStyle(ADVStyle style) {
        this.style = style;
    }

    @Override
    public int getFixedPosX() {
        return fixedPosX;
    }

    public void setFixedPosX(int x) {
        this.fixedPosX = x;
    }

    @Override
    public int getFixedPosY() {
        return fixedPosY;
    }

    public void setFixedPosY(int y) {
        this.fixedPosY = y;
    }

    @Override
    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    public Edge getEdgeTo(Vertex<T> target) {
        return graph.getEdges().stream().filter(
                e -> e.getTargetElementId() == target.getId() &&
                        e.getSourceElementId() == this.getId()
        ).findFirst().orElse(null);
    }
}
