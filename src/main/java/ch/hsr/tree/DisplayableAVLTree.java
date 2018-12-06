package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVColor;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeStyle;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeThickness;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.tree.logic.domain.ADVBinaryTreeNode;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVEnumStyle;
import ch.hsr.adv.lib.tree.logic.binarytree.BinaryTreeModule;
import ch.hsr.tree.model.avltree.AVLTree;

public class DisplayableAVLTree<K extends Comparable<K>> extends AVLTree<K> {

    private static final ADVStyle nodeToRotateColor = new ADVEnumStyle(ADVColor.RED_LIGHT,
            ADVColor.RED_DARK,
            ADVStrokeStyle.DOTTED,
            ADVStrokeThickness.STANDARD);
    private static final ADVStyle nodeIncludedInRotationColor = new ADVEnumStyle(ADVColor.ORANGE_LIGHT,
            ADVColor.ORANGE_DARK,
            ADVStrokeStyle.DOTTED,
            ADVStrokeThickness.STANDARD);

    private final BinaryTreeModule module;

    protected class DisplayableAVLNode extends AVLTree<K>.AVLNode implements ADVBinaryTreeNode<K> {

        private ADVStyle style;

        protected DisplayableAVLNode(K content) {
            this(content, null);
        }

        protected DisplayableAVLNode(K content, ADVStyle style) {
            super(content);
            this.style = style;
        }

        @Override
        public DisplayableAVLNode getLeftChild() {
            return (DisplayableAVLNode) super.getLeftChild();
        }

        @Override
        public DisplayableAVLNode getRightChild() {
            return (DisplayableAVLNode) super.getRightChild();
        }

        @Override
        public ADVStyle getStyle() {
            return style;
        }

        public void setStyle(ADVStyle style) {
            this.style = style;
        }
    }


    DisplayableAVLTree() {
        module = new BinaryTreeModule("AVLTreeGVS");
        module.setShowArray(true);
        module.setFixedTreeHeight(3, 2);
    }

    public static void main(String[] args) throws ADVException {
        ADV.launch(null);
        DisplayableAVLTree<String> avlTree = new DisplayableAVLTree<>();

        avlTree.put("Str_5");
        avlTree.put("Str_7");
        avlTree.put("Str_9"); //Single-Rotation
        avlTree.put("Str_3");
        avlTree.put("Str_1"); //Single-Rotation
        avlTree.put("Str_4"); //Double-Rotation
    }

    @Override
    protected Node newNode(K content) {
        return new DisplayableAVLNode(content);
    }

    @Override
    public boolean put(K content) {
        boolean result = super.put(content);
        try {
            module.setRoot((DisplayableAVLNode) root);

            ADV.snapshot(module);
        } catch (ADVException ignored) {
        }
        return result;
    }

    @Override
    protected AVLNode rotateWithRightChild(AVLNode k1) {
        try {
            module.setRoot((DisplayableAVLNode) root);
            DisplayableAVLNode dk1 = (DisplayableAVLNode) k1;
            DisplayableAVLNode dk2 = (DisplayableAVLNode) k1.getRightChild();
            dk1.setStyle(nodeToRotateColor);
            dk2.setStyle(nodeIncludedInRotationColor);

            ADV.snapshot(module);

            AVLNode result = super.rotateWithRightChild(k1);

            module.setRoot((DisplayableAVLNode) root);
            ADV.snapshot(module);

            dk1.setStyle(null);
            dk2.setStyle(null);
            return result;
        } catch (ADVException ignored) {
        }
        return null;
    }

    @Override
    protected AVLNode rotateWithLeftChild(AVLNode k2) {
        try {
            module.setRoot((DisplayableAVLNode) root);
            DisplayableAVLNode dk2 = (DisplayableAVLNode) k2;
            DisplayableAVLNode dk1 = (DisplayableAVLNode) k2.getLeftChild();
            dk2.setStyle(nodeToRotateColor);
            dk1.setStyle(nodeIncludedInRotationColor);

            ADV.snapshot(module);

            AVLNode result = super.rotateWithLeftChild(k2);

            module.setRoot((DisplayableAVLNode) root);
            ADV.snapshot(module);

            dk2.setStyle(null);
            dk1.setStyle(null);
            return result;
        } catch (ADVException ignored) {
        }
        return null;
    }
}
