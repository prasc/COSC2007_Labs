public class AVLTree {

    private class Node {
        int balanceFactor;
        Integer item;
        int height;
        Node leftChild;
        Node rightChild;

        public Node(Integer item) {
            this.item = item;
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

        public int getHeight() {
            return height;
        }

        public Integer getItem() {
            return item;
        }

        public void setItem(Integer item) {
            this.item = item;
        }
    }

    Node root;
    private int size = 0;

    public AVLTree() {
        root = null;
    }

    public int height() {
        if (root == null) return 0;     // if tree is empty, return 0
        return root.height;             // otherwise, return height of the root
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean search(Integer item) {
        return searching(root, item);
    }

    private boolean searching(Node curr, Integer item) {

        // if curr == null, it means we're at the end of the tree or the tree is empty
        // so return false
        if (curr == null) return false;

        if (item < curr.item) {         // item is on left side of tree
            return searching(curr.getLeftChild(), item);    // search recursively
        }

        if (item > curr.item) {         // item is on right side of tree
            return searching(curr.getRightChild(), item);    // search recursively
        }

        // if it is not less than, or greater than
        // and curr is not null, than we are on the correct node
        return true;
    }

    public boolean insert(Integer item) {
        if (item == null) throw new AVLTreeException("Cannot insert null");

        if (searching(root, item) == false) {   // check if item already exists in tree
            root = inserting(root, item);   // if it doesn't, then insert it
            size++;                         // increment size;
            return true;
        }
        return false;
    }

    private Node inserting(Node curr, Integer item) {
        Node newNode = new Node(item);


        if (curr == null) return newNode;

        if (item < curr.item) {         // item is on left side of tree
            curr.setLeftChild(inserting(curr.getLeftChild(), item));    // keep traversing left side until curr == null, and insert the item there
        } else if (item > curr.item) {         // item is on right side of tree
            curr.setRightChild(inserting(curr.getRightChild(), item));    // keep traversing right side until curr == null, and insert the item there
        }

        return reBalance(curr);
    }

    public boolean remove(Integer item) {
        if (item == null) throw new AVLTreeException("Cannot delete null");

        if (searching(root, item) == false) {
            root = removing(root, item);
            size--;
            return true;
        }
        return false;
    }

    private Node removing(Node curr, Integer item) {
        if (curr == null) return null;

        if (item < curr.item) {         // item is on left side of tree
            curr.setLeftChild(removing(curr.getLeftChild(), item));    // keep traversing left side until curr == null, and insert the item there
        } else if (item > curr.item) {         // item is on right side of tree
            curr.setRightChild(removing(curr.getRightChild(), item));    // keep traversing right side until curr == null, and insert the item there
        } else {
            if (curr.getLeftChild() == null) {
                return curr.getRightChild();
            } else if (curr.getRightChild() == null) {
                return curr.getLeftChild();
            } else {
                if (curr.getLeftChild().getHeight() > curr.getRightChild().getHeight()) {
                    Integer newValue = findMax(curr.leftChild);
                    curr.setItem(newValue);
                    curr.setLeftChild(removing(curr.leftChild, newValue));
                } else {
                    Integer newValue = findMin(curr.rightChild);
                    curr.setItem(newValue);
                    curr.setRightChild(removing(curr.rightChild, newValue));
                }
            }
        }

        return reBalance(curr);
    }

    private Node reBalance(Node curr) {

        int leftChildHeight = (curr.getLeftChild() == null) ? -1 : curr.getLeftChild().getHeight();
        int rightChildHeight = (curr.getRightChild() == null) ? -1 : curr.getRightChild().getHeight();

        curr.height = 1 + Math.max(leftChildHeight, rightChildHeight);
        curr.balanceFactor = leftChildHeight - rightChildHeight;

        // if leftHeight - rightHeight == 2, it means we are heavily skewed on the left side
        // there are only two options, leftLeft rotation or leftRight rotation
        if (curr.balanceFactor == 2) {
            // if balanceFactor of leftChild of current is -1, it means:
            // there are leftChild is null and there is only a child on the right side
            // therefore, we need a leftRight rotation
            if (curr.getLeftChild().balanceFactor == -1) {
                return leftRightRotation(curr);

            // curr has a balance factor of 2
            // but curr.leftChild does not have a right child
            // therefore, it must have a left child so we do a leftLeft rotation
            } else {
                return leftLeftRotation(curr);
            }
        } else if (curr.balanceFactor == -2) {
            if (curr.getRightChild().balanceFactor == -1) {
                return rightRightRotation(curr);
            } else {
                return rightLeftRotation(curr);
            }
        }
    // return current here because the balance factor is valid (as in not -2 or +2)
        return curr;
    }

    private Node leftLeftRotation(Node curr) {
        Node newParent = curr.getLeftChild();
        curr.leftChild = newParent.getRightChild();
        newParent.rightChild = curr;

        reBalance(curr);
        reBalance(newParent);
        return newParent;
    }

    // two step rotation
    private Node leftRightRotation(Node curr) {
        curr.leftChild = rightRightRotation(curr.leftChild);
        curr = leftLeftRotation(curr);

        return curr;
    }

    private Node rightRightRotation(Node curr) {
        Node newParent = curr.getRightChild();
        curr.rightChild = newParent.getLeftChild();
        newParent.leftChild = curr;


        reBalance(curr);
        reBalance(newParent);
        return newParent;
    }

    // two step rotation
    private Node rightLeftRotation(Node curr) {
        curr.rightChild = leftRightRotation(curr);
        curr = rightRightRotation(curr);
        return curr;
    }


    public void displayInOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            inOrder(root);
            System.out.println();
        }
    }

    private void inOrder(Node curr) {
        if (curr != null) {
            inOrder(curr.getLeftChild());
            System.out.print(curr.getItem() + "(" + curr.getHeight() + ")" + " ");
            inOrder(curr.getRightChild());
        }
    }

    public void displayPreOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            preOrder(root);
            System.out.println();
        }
    }

    private void preOrder(Node curr) {
        if (curr != null) {
            System.out.print(curr.getItem() + "(" + curr.getHeight() + ")" + " ");
            preOrder(curr.getLeftChild());
            preOrder(curr.getRightChild());
        }
    }

    public void displayPostOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            postOrder(root);
            System.out.println();
        }
    }

    private void postOrder(Node curr) {
        if (curr != null) {
            postOrder(curr.getLeftChild());
            postOrder(curr.getRightChild());
            System.out.print(curr.getItem() + "(" + curr.getHeight() + ")" + " ");
        }
    }



    public Integer findMin() {
        Node curr = root;
        while (curr.getLeftChild() != null) {
            curr = curr.getLeftChild();
        }
        return curr.getItem();
    }

    public Integer findMin(Node curr) {
        while (curr.getLeftChild() != null) {
            curr = curr.getLeftChild();
        }

        return curr.getItem();
    }

    public Integer findMax() {
        Node curr = root;
        while (curr.getRightChild() != null) {
            curr = curr.getRightChild();
        }

        return curr.getItem();
    }

    public Integer findMax(Node curr) {
        while (curr.getRightChild() != null) {
            curr = curr.getRightChild();
        }

        return curr.getItem();
    }

}

// -1 = if less
// 0 = if same
// 1 = if greater













