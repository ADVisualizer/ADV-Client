package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.tree.logic.domain.ADVBinaryTreeNode;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.tree.logic.binarytree.BinaryTreeModule;
import ch.hsr.tree.model.avltree.AVLTree;

public class DisplayableAVLTree<K extends Comparable<K>> extends AVLTree<K> {

    private final BinaryTreeModule module;

    private final int DELAY = 200;

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
    }

    public static void main(String[] args) throws ADVException {
        ADV.launch(null);
        DisplayableAVLTree<String> avlTree = new DisplayableAVLTree<>();

        System.out.println("Inserting 5:");
        avlTree.put("Str_5");
        System.out.println("================================");
        System.out.println("Inserting 7:");
        avlTree.put("Str_7");
        System.out.println("================================");
        System.out.println("Inserting 9: Single-Rotation");
        avlTree.put("Str_9");
        System.out.println("================================");
        System.out.println("Inserting 3:");
        avlTree.put("Str_3");
        System.out.println("================================");
        System.out.println("Inserting 1: Single-Rotation");
        avlTree.put("Str_1");
        System.out.println("================================");
        System.out.println("Inserting 4: Double-Rotation");
        avlTree.put("Str_4");
        System.out.println("================================");
    }

    @Override
    protected Node newNode(K content) {
        return new DisplayableAVLNode(content);
    }

    @Override
    public K put(K content) {
        K result = super.put(content);
        module.setRoot((DisplayableAVLNode) root);
        try {
            ADV.snapshot(module);
        } catch (ADVException ignored) { }
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ignored) { }
        return result;
    }

    @Override
    protected AVLNode rotateWithRightChild(AVLNode k1) {
        module.setRoot((DisplayableAVLNode) root);
        ((DisplayableAVLNode) k1).setStyle(new ADVErrorStyle());
        try {
            ADV.snapshot(module);
        } catch (ADVException ignored) {
        }
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ignored) {
        }
        ((DisplayableAVLNode) k1).setStyle(null);
        return super.rotateWithRightChild(k1);
    }

    @Override
    protected AVLNode rotateWithLeftChild(AVLNode k2) {
        module.setRoot((DisplayableAVLNode) root);
        ((DisplayableAVLNode) k2).setStyle(new ADVSuccessStyle());
        try {
            ADV.snapshot(module);
        } catch (ADVException ignored) {
        }
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException ignored) {
        }
        ((DisplayableAVLNode) k2).setStyle(null);
        return super.rotateWithLeftChild(k2);
    }
}
