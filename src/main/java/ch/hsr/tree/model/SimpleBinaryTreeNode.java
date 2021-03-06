package ch.hsr.tree.model;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.tree.logic.domain.ADVBinaryTreeNode;

public class SimpleBinaryTreeNode implements ADVBinaryTreeNode<String> {

    private SimpleBinaryTreeNode leftChild;
    private SimpleBinaryTreeNode rightChild;
    private String content;
    private ADVStyle style;

    public SimpleBinaryTreeNode(String content) {
        this(content, null);
    }

    private SimpleBinaryTreeNode(String content, ADVStyle style) {
        this.content = content;
        this.style = style;
    }

    public void setLeftChild(SimpleBinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(SimpleBinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setStyle(ADVStyle style) {
        this.style = style;
    }

    @Override
    public SimpleBinaryTreeNode getLeftChild() {
        return leftChild;
    }

    @Override
    public SimpleBinaryTreeNode getRightChild() {
        return rightChild;
    }

    @Override
    public ADVStyle getStyle() {
        return style;
    }

    @Override
    public String getContent() {
        return content;
    }
}
