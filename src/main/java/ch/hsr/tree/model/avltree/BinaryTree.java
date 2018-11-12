package ch.hsr.tree.model.avltree;

import java.util.Collection;
import java.util.LinkedList;

public class BinaryTree<K extends Comparable<K>> {

    protected Node root;

    protected class Node {

        private K content;
        private Node leftChild;
        private Node rightChild;

        public Node(K content) {
            this.content = content;
        }

        protected Node(K content, Node leftChild, Node rightChild) {
            this.content = content;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public K getContent() {
            return content;
        }

        public K setContent(K content) {
            K oldContent = this.content;
            this.content = content;
            return oldContent;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

    }

    public K insert(K content) {
        root = insert(root, content);
        return content;
    }

    protected Node insert(Node node, K content) {
        if (node == null)
            return newNode(content);
        else if (content.compareTo(node.getContent()) <= 0) {
            node.leftChild = insert(node.leftChild, content);
        } else {
            node.rightChild = insert(node.rightChild, content);
        }
        return node;
    }

    protected Node newNode(K content) {
        return new Node(content);
    }

    public K find(K content) {
        Node result = find(root, content);
        if (result == null) {
            return null;
        } else {
            return result.getContent();
        }
    }

    protected Node find(Node node, K content) {
        if (node == null) {
            return null;
        }
        if (content.compareTo(node.getContent()) < 0) {
            return find(node.leftChild, content);
        }
        if (content.compareTo(node.getContent()) > 0) {
            return find(node.rightChild, content);
        }
        return node;
    }

    protected Node getParentNext(Node p) {
        if (p.rightChild.leftChild != null) {
            p = p.rightChild;
            while (p.leftChild.leftChild != null)
                p = p.leftChild;
        }
        return p;
    }
}

