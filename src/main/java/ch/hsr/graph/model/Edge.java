package ch.hsr.graph.model;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.graph.logic.domain.ADVEdge;

public class Edge<E> implements ADVEdge<E> {

    private long sourceVertexId;
    private long targetVertexId;
    private boolean directed;
    private E label;
    private ADVStyle style;

    public Edge(Vertex sourceVertex, Vertex targetVertex) {
        this(sourceVertex, targetVertex, false);
    }

    public Edge(Vertex sourceVertex, Vertex targetVertex, boolean directed) {
        this(sourceVertex.getId(), targetVertex.getId(), directed);
    }

    public Edge(long sourceVertexId, long targetVertexId) {
        this(sourceVertexId, targetVertexId, false);
    }

    public Edge(long sourceVertexId, long targetVertexId, boolean directed) {
        this.sourceVertexId = sourceVertexId;
        this.targetVertexId = targetVertexId;
        this.directed = directed;
    }

    @Override
    public boolean isSelfReference() {
        return sourceVertexId == targetVertexId;
    }

    @Override
    public long getSourceElementId() {
        return sourceVertexId;
    }

    @Override
    public void setSourceElementId(long sourceVertexId) {
        this.sourceVertexId = sourceVertexId;
    }

    @Override
    public long getTargetElementId() {
        return targetVertexId;
    }

    @Override
    public void setTargetElementId(long targetVertexId) {
        this.targetVertexId = targetVertexId;
    }

    @Override
    public E getLabel() {
        return label;
    }

    @Override
    public void setLabel(E label) {
        this.label = label;
    }

    @Override
    public ADVStyle getStyle() {
        return style;
    }

    @Override
    public void setStyle(ADVStyle style) {
        this.style = style;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
