package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.commons.tree.logic.domain.ADVGeneralTreeNode;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.tree.logic.generaltree.GeneralTreeModule;
import ch.hsr.tree.model.SimpleGeneralTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class GeneralTraversal {
    public static void main(String[] args) throws ADVException {
        ADV.launch(null);

        SimpleGeneralTreeNode root = buildTree();

        GeneralTreeModule module = new GeneralTreeModule(root, "Traversal");
        ADV.snapshot(module);
        traversePreorder(module, root);
//        traversePostorder(module, root);
//        traverseBreadthFirst(module, root);
    }

    private static void traverseBreadthFirst(GeneralTreeModule module, SimpleGeneralTreeNode root) throws ADVException {
        Queue<SimpleGeneralTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            SimpleGeneralTreeNode node = queue.remove();
            visitNode(module, node);

            for (ADVGeneralTreeNode<Integer> childNode :
                    node.getChildren()) {
                queue.add((SimpleGeneralTreeNode) childNode);
            }
        }
    }

    private static void traversePostorder(GeneralTreeModule module, SimpleGeneralTreeNode node) throws ADVException {
        for (ADVGeneralTreeNode<Integer> childNode :
                node.getChildren()) {
            traversePostorder(module, (SimpleGeneralTreeNode) childNode);
        }

        visitNode(module, node);
    }

    private static void traversePreorder(GeneralTreeModule module, SimpleGeneralTreeNode node) throws ADVException {
        visitNode(module, node);

        for (ADVGeneralTreeNode<Integer> childNode :
                node.getChildren()) {
            traversePreorder(module, (SimpleGeneralTreeNode) childNode);
        }
    }

    private static void visitNode(GeneralTreeModule module, SimpleGeneralTreeNode node) throws ADVException {
        node.setStyle(new ADVSuccessStyle());
        ADV.snapshot(module);
    }

    private static SimpleGeneralTreeNode buildTree() {
        SimpleGeneralTreeNode root = new SimpleGeneralTreeNode(1);
        SimpleGeneralTreeNode rootChild1 = new SimpleGeneralTreeNode(11);
        SimpleGeneralTreeNode rootChild2 = new SimpleGeneralTreeNode(12);
        SimpleGeneralTreeNode rootChild3 = new SimpleGeneralTreeNode(13);
        SimpleGeneralTreeNode rootChild4 = new SimpleGeneralTreeNode(14);
        SimpleGeneralTreeNode child1Child1 = new SimpleGeneralTreeNode(111);
        SimpleGeneralTreeNode child1Child2 = new SimpleGeneralTreeNode(112);
        SimpleGeneralTreeNode child1Child3 = new SimpleGeneralTreeNode(113);
        SimpleGeneralTreeNode child3Child1 = new SimpleGeneralTreeNode(131);

        root.addChild(rootChild1);
        root.addChild(rootChild2);
        root.addChild(rootChild3);
        root.addChild(rootChild4);
        rootChild1.addChild(child1Child1);
        rootChild1.addChild(child1Child2);
        rootChild1.addChild(child1Child3);
        rootChild3.addChild(child3Child1);
        return root;
    }
}
