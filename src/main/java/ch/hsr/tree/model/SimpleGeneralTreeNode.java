package ch.hsr.tree.model;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.tree.logic.domain.ADVGeneralTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleGeneralTreeNode implements ADVGeneralTreeNode<Integer> {

    private List<SimpleGeneralTreeNode> children;
    private ADVStyle style;
    private Integer content;

    public SimpleGeneralTreeNode(Integer content) {
        this(content, null);
    }

    private SimpleGeneralTreeNode(Integer content, ADVStyle style) {
        children = new ArrayList<>();
        this.content = content;
        this.style = style;
    }

    public void addChild(SimpleGeneralTreeNode child) {
        children.add(child);
    }

    public void removeChild(SimpleGeneralTreeNode child) {
        children.remove(child);
    }

    public void setStyle(ADVStyle style) {
        this.style = style;
    }

    @Override
    public List<SimpleGeneralTreeNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public ADVStyle getStyle() {
        return style;
    }

    @Override
    public Integer getContent() {
        return content;
    }
}
