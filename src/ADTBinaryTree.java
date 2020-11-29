// Implemented the tree based on textbook

public class ADTBinaryTree<T> {

    private class TreeNode<T> {
        T item;
        TreeNode<T> leftChild;
        TreeNode<T> rightChild;

        public TreeNode(T newItem) {
            item = newItem;
            leftChild = null;
            rightChild = null;
        }

        public TreeNode(T newItem, TreeNode<T> left, TreeNode<T> right) {
            item = newItem;
            leftChild = left;
            rightChild = right;
        }
    }

    private TreeNode root = null;

    public ADTBinaryTree(T rootItem) {
        root = new TreeNode<T>(rootItem, null, null);
    }

    public ADTBinaryTree(T rootItem, ADTBinaryTree<T> leftTree, ADTBinaryTree<T> rightTree) {
        root = new TreeNode<T>(rootItem, null, null);
        attachLeftSubtree(leftTree);
        attachRightSubtree(rightTree);
    }


    public void setRootItem(T newItem) {
        if (root != null) {
            root.item = newItem;
        } else {
            root = new TreeNode<T>(newItem, null, null);
        }
    }

    public void attachLeft(T newItem) {
        if (!isEmpty() && root.leftChild == null) {
            root.leftChild = new TreeNode<T>(newItem, null, null);
        }
    }

    public void attachRight(T newItem) {
        if (!isEmpty() && root.rightChild == null) {
            root.rightChild = new TreeNode<T>(newItem, null, null);
        }
    }

    private void attachLeftSubtree(ADTBinaryTree<T> leftTree) {
        if (isEmpty()) throw new TreeException("Empty tree");
        if (root.leftChild != null) throw new TreeException("Cannot overwrite left subtree");

        root.leftChild = leftTree.root;
        leftTree.makeEmpty();
    }

    private void attachRightSubtree(ADTBinaryTree<T> rightTree) {
        if (isEmpty()) throw new TreeException("Empty tree");
        if (root.rightChild != null) throw new TreeException("Cannot overwrite right subtree");

        root.rightChild = rightTree.root;
        rightTree.makeEmpty();
    }

    protected ADTBinaryTree(TreeNode<T> rootNode) {
        root = rootNode;
    }

    public ADTBinaryTree<T> detachLeftSubtree() {
        if (isEmpty()) throw new TreeException("Empty tree");

        ADTBinaryTree<T> leftTree;
        leftTree = new ADTBinaryTree<>(root.leftChild);
        root.leftChild = null;
        return leftTree;
    }

    public ADTBinaryTree<T> detachRightSubtree() {
        if (isEmpty()) throw new TreeException("Empty tree");

        ADTBinaryTree<T> rightTree;
        rightTree = new ADTBinaryTree<>(root.rightChild);
        root.rightChild = null;
        return rightTree;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public ADTBinaryTree<T> getRootItem() {
        if (isEmpty()) throw new TreeException("Empty tree");
        return (ADTBinaryTree<T>) root.item;
    }
}

class TreeException extends RuntimeException{
    public TreeException(String s) {
        super(s);
    }
}