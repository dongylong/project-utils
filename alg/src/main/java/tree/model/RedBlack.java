package tree.model;

import lombok.Data;

/**
 * @author dongyl-work
 */
@Data
public class RedBlack<E>{
    private E element;
    private Boolean color;
    protected Node<RedBlack<E>> root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private void afterAddElement(Node<RedBlack<E>> node) {
        Node<RedBlack<E>> parent = node.getParent();
        if (parent == null) {
            printColorBlack(parent);
            return;
        }

        if(queryIsBlackColor(parent)){
            return;
        }

        //叔父结点
        Node<RedBlack<E>> siblingNode = parent.siblingNode();
        //祖父结点
        Node<RedBlack<E>> grandParentNode = parent.getParent();
        printColorRed(grandParentNode);
        if(queryIsRedColor(siblingNode)){
            printColorBlack(parent);
            printColorBlack(siblingNode);
            afterAddElement(grandParentNode);
            return;
        }
        if(parent.isLeftChild()){
            //L
            if(node.isLeftChild()){
               //LL
               printColorBlack(parent);
            }else{
                //LR
                printColorBlack(node);
                rotateLeft(parent);
            }
            rotateRight(grandParentNode);
        }else{
            //R
            if(node.isLeftChild()){
               //RL
                printColorBlack(node);
                rotateRight(parent);
            }else{
                //RR
                printColorBlack(parent);
            }
            rotateLeft(grandParentNode);

        }
    }

    private void rotateRight(Node<RedBlack<E>> grand) {
        Node<RedBlack<E>> parent = grand.left;
        Node<RedBlack<E>> child = parent.right;
        grand.left = child;
        parent.left = grand;
        afterRotate(grand,parent,child);
    }

    private void afterRotate(Node<RedBlack<E>> grand, Node<RedBlack<E>> parent, Node<RedBlack<E>> child) {
        parent.parent = grand.parent;
        if(grand.isLeftChild()){
            grand.parent.left = parent;
        }else if(grand.isRightChild()){
            grand.parent.right = parent;
        }else{
            root = parent;
        }

        if (child != null) {
            child.parent = grand;
        }

        grand.parent = parent;
    }

    protected void rotateLeft(Node<RedBlack<E>> node) {
        Node<RedBlack<E>> right = node.right;
        Node<RedBlack<E>> left = right.left;
        node.right = right;
        right.left = node;
        afterRotate(node,right,left);
    }

    private boolean queryNodeColor(Node<RedBlack<E>> node) {
        RedBlack element = node.getElement();
        if (node == null
                || element == null
                || element.getColor() == null) {
            return BLACK;
        }
        return element.getColor();
    }

    private boolean queryIsBlackColor(Node<RedBlack<E>> node) {
        return queryNodeColor(node) == BLACK;
    }

    private boolean queryIsRedColor(Node<RedBlack<E>> node) {
        return queryNodeColor(node) == RED;
    }

    private void printColor(Node<RedBlack<E>> node, boolean color) {
        RedBlack element = node.getElement();
        if (node == null
                || element == null) {
            return;
        }
        element.setColor(color);
    }

    private void printColorRed(Node<RedBlack<E>> node) {
        if (node == null) {
            return;
        }
        printColor(node, RED);
    }

    private void printColorBlack(Node<RedBlack<E>> node) {
        if (node == null) {
            return;
        }
        printColor(node, BLACK);
    }
}
