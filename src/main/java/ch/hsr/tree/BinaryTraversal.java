package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.tree.logic.binarytree.BinaryTreeModule;
import ch.hsr.tree.model.SimpleBinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTraversal {

    public static void main(String[] args) throws ADVException {
        ADV.launch(null);
        SimpleBinaryTreeNode root = buildTree();

        BinaryTreeModule module = new BinaryTreeModule(root, "Traversal");
        module.setShowArray(true);

        ADV.snapshot(module);
        traversePreorder(module, root);
//        traversePostorder(module, root);
//        traverseInorder(module, root);
//        traverseBreadthFirst(module, root);
    }

    private static void traversePreorder(BinaryTreeModule module, SimpleBinaryTreeNode node) throws ADVException {
        if (node != null) {
            visitNode(module, node);

            traversePreorder(module, (SimpleBinaryTreeNode) node.getLeftChild());
            traversePreorder(module, (SimpleBinaryTreeNode) node.getRightChild());
        }
    }

    private static void traversePostorder(BinaryTreeModule module, SimpleBinaryTreeNode node) throws ADVException {
        if (node != null) {
            traversePostorder(module, (SimpleBinaryTreeNode) node.getLeftChild());
            traversePostorder(module, (SimpleBinaryTreeNode) node.getRightChild());

            visitNode(module, node);
        }
    }

    private static void traverseInorder(BinaryTreeModule module, SimpleBinaryTreeNode node) throws ADVException {
        if (node != null) {
            traverseInorder(module, (SimpleBinaryTreeNode) node.getLeftChild());

            visitNode(module, node);

            traverseInorder(module, (SimpleBinaryTreeNode) node.getRightChild());
        }
    }

    private static void traverseBreadthFirst(BinaryTreeModule module, SimpleBinaryTreeNode root) throws ADVException {
        Queue<SimpleBinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            SimpleBinaryTreeNode node = queue.remove();
            visitNode(module, node);

            SimpleBinaryTreeNode leftChild = (SimpleBinaryTreeNode) node.getLeftChild();
            SimpleBinaryTreeNode rightChild = (SimpleBinaryTreeNode) node.getRightChild();
            if (leftChild != null) {
                queue.add(leftChild);
            }
            if (rightChild != null) {
                queue.add(rightChild);
            }
        }
    }

    private static void visitNode(BinaryTreeModule module, SimpleBinaryTreeNode node) throws ADVException {
        node.setStyle(new ADVSuccessStyle());
        ADV.snapshot(module);
    }

    private static SimpleBinaryTreeNode buildTree() {
        SimpleBinaryTreeNode root = new SimpleBinaryTreeNode("root");
        SimpleBinaryTreeNode leftroot = new SimpleBinaryTreeNode("leftroot");
        SimpleBinaryTreeNode rightroot = new SimpleBinaryTreeNode("rightroot");
        SimpleBinaryTreeNode rightright = new SimpleBinaryTreeNode("rightright");
        SimpleBinaryTreeNode leftleft = new SimpleBinaryTreeNode("leftleft");
        SimpleBinaryTreeNode righleft = new SimpleBinaryTreeNode("rightleft");
        SimpleBinaryTreeNode rlright = new SimpleBinaryTreeNode("rlright");

        root.setLeftChild(leftroot);
        root.setRightChild(rightroot);
        leftroot.setLeftChild(leftleft);
        rightroot.setLeftChild(righleft);
        rightroot.setRightChild(rightright);
        righleft.setRightChild(rlright);
        return root;
    }

}
