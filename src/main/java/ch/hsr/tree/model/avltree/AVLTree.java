package ch.hsr.tree.model.avltree;

public class AVLTree<K extends Comparable<K>> extends BinaryTree<K> {
    protected AVLNode actionNode;


    protected class AVLNode extends BinaryTree<K>.Node {

        private int height;
        private Node parent;

        public AVLNode(K content) {
            super(content);
        }

        protected AVLNode setParent(AVLNode parent) {
            AVLNode old = avlNode(this.parent);
            this.parent = parent;
            return old;
        }

        protected AVLNode getParent() {
            return avlNode(parent);
        }

        protected int setHeight(int height) {
            int old = this.height;
            this.height = height;
            return old;
        }

        protected int getHeight() {
            return height;
        }

        @Override
        public void setLeftChild(BinaryTree<K>.Node leftChild) {
            super.setLeftChild(leftChild);
            if (leftChild != null) {
                ((AVLNode)leftChild).setParent(this);
            }
        }

        @Override
        public AVLNode getLeftChild() {
            return avlNode(super.getLeftChild());
        }

        @Override
        public void setRightChild(BinaryTree<K>.Node rightChild) {
            super.setRightChild(rightChild);
            if (rightChild != null) {
                ((AVLNode)rightChild).setParent(this);
            }
        }

        @Override
        public AVLNode getRightChild() {
            return avlNode(super.getRightChild());
        }
    }

    public K put(K content) {
        K entry = find(content);
        if (entry == null) {
            super.insert(content);
            rebalance(actionNode);
            actionNode = null;
            return null;
        }

        return entry;
    }

    @Override
    protected Node insert(Node node, K content) {
        if (node != null) {
            actionNode = avlNode(node);
        }

        AVLNode result = avlNode(super.insert(node, content));
        if (node == null) {
            result.setParent(actionNode);
        }
        return result;
    }

    protected int height(AVLNode node) {
        return (node != null) ? node.getHeight() : -1;
    }

    protected AVLNode restructure(AVLNode xPos) {
        AVLNode yPos = xPos.getParent();
        AVLNode zPos = yPos.getParent();
        AVLNode newSubTreeRoot;
        if (yPos == zPos.getLeftChild()) {
            if (xPos == yPos.getLeftChild()) {
                newSubTreeRoot = rotateWithLeftChild(zPos);
            } else {
                newSubTreeRoot = doubleRotateWithLeftChild(zPos);
            }
        } else {
            if (xPos == yPos.getRightChild()) {
                newSubTreeRoot = rotateWithRightChild(zPos);
            } else {
                newSubTreeRoot = doubleRotateWithRightChild(zPos);
            }
        }
        return newSubTreeRoot;
    }

    protected AVLNode tallerChild(AVLNode node) {
        if (height(node.getLeftChild()) >= height(node.getRightChild())) {
            return node.getLeftChild();
        } else {
            return node.getRightChild();
        }
    }

    protected AVLNode rotateWithLeftChild(AVLNode k2) {
        AVLNode parentSubtree = k2.getParent();
        AVLNode k1 = k2.getLeftChild();
        k2.setLeftChild(k1.getRightChild());
        k1.setRightChild(k2);
        adjustSubtreeParent(k2,  k1, parentSubtree);
        return k1;
    }

    protected AVLNode doubleRotateWithLeftChild(AVLNode k3) {
        k3.setLeftChild(rotateWithRightChild(k3.getLeftChild()));
        return rotateWithLeftChild(k3);
    }

    protected AVLNode rotateWithRightChild(AVLNode k1) {
        AVLNode parentSubtree = k1.getParent();
        AVLNode k2 = k1.getRightChild();
        k1.setRightChild(k2.getLeftChild());
        k2.setLeftChild(k1);
        adjustSubtreeParent(k1, k2, parentSubtree);
        return k2;
    }

    protected AVLNode doubleRotateWithRightChild(AVLNode k3) {
        k3.setRightChild(rotateWithLeftChild(k3.getRightChild()));
        return rotateWithRightChild(k3);
    }

    protected void adjustSubtreeParent(final AVLNode oldSubtreeRoot,
                                       final AVLNode newSubtreeRoot, final AVLNode parentSubtree) {
        if (parentSubtree != null) {
            if (parentSubtree.getLeftChild() == oldSubtreeRoot) {
                parentSubtree.setLeftChild(newSubtreeRoot);
            } else {
                parentSubtree.setRightChild(newSubtreeRoot);
            }
        } else {
            root = newSubtreeRoot;
            newSubtreeRoot.setParent(null);
        }
    }

    protected boolean isBalanced(AVLNode node) {
        int bf = height(node.getLeftChild()) - height(node.getRightChild());
        return (-1 <= bf) && (bf <= 1);
    }

    protected void rebalance(AVLNode node) {
        while (node != null) {
            setHeight(node);
            if (!isBalanced(node)) {
                AVLNode xPos = tallerChild(tallerChild(node));
                node = restructure(xPos);
                setHeight(node.getLeftChild());
                setHeight(node.getRightChild());
                setHeight(node);
            }
            node = node.getParent();
        }
    }

    protected void setHeight(AVLNode node) {
        if (node == null) {
            return;
        }
        int heightLeftChild = height(node.getLeftChild());
        int heightRightChild = height(node.getRightChild());
        node.setHeight(1 + Math.max(heightLeftChild, heightRightChild));
    }

    @Override
    protected Node newNode(K content) {
        return new AVLNode(content);
    }

    @Override
    protected Node getParentNext(Node p) {
        actionNode = avlNode(super.getParentNext(p));
        return actionNode;
    }

    protected AVLNode avlNode(Node node) {
        return (AVLNode)node;
    }
}
