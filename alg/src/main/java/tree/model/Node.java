package tree.model;

import lombok.Data;

/**
 * @author dongyl-work
 */
@Data
public class Node<E> {
    protected E element;
    protected Node<E> parent;
    protected Node<E> left;
    protected Node<E> right;


    public Node<E> siblingNode() {
        if(isLeftChild()){
            return parent.right;
        }
        if(isRightChild()){
            return parent.left;
        }
        return null;
    }
    protected boolean isLeftChild() {
        if (parent != null
                && this == parent.left) {
            return true;
        }
        return false;
    }

    protected boolean isRightChild() {
        if (parent != null
                && this == parent.right) {
            return true;
        }
        return false;
    }

    public boolean validHasLeftChild() {
        return this.getLeft() != null;
    }

    public boolean validHasRightChild() {
        return this.getRight() != null;
    }

    public boolean validIsLeaf() {
        return this.getRight() == null && this.getLeft() == null;
    }
    public boolean validHasTwoChildren() {
        return this.getRight() != null && this.getLeft() != null;
    }
    public boolean validIsSibling() {
        return this.getRight() != null && this.getLeft() != null;
    }

    protected void rotateLeft(Node<E> node) {
        Node<E> right = node.right;
        Node<E> left = parent.left;
        node.right = parent;
        right.left = node;
        afterRotate(node,right,left);
    }

    private void afterRotate(Node<E> node, Node<E> right, Node<E> left) {

    }
}
