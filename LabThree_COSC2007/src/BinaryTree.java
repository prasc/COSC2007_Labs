public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer item) {
        if (root == null) {
            Node newNode = new Node(item);
            root = newNode;
        }
        else {
            insert(root, item);
        }
    }

    public boolean search(Integer item) {
        Node temp = root;

        if (temp == null) return false;

        while (temp != null) {                          // while there are more nodes in the tree
            if (item > temp.getItem())  temp = temp.getRightChild();              // compare right side
            else if (item < temp.getItem()) temp = temp.getLeftChild();           // compare left side
            else return true;                            // if item is not greater than or less than root and not null, it must be equal
        }
        return false;                                   // if it never reached any of the prior conditions, it is not in this tree

    }

    private void insert(Node root, Integer item) {
        Node newNode = new Node(item);

        if (item < root.getItem()) {
            if (root.getLeftChild() == null)
                root.setLeftChild(newNode);
            else
                insert(root.getLeftChild(), item);          // recursive call

        } else {
            if (root.getRightChild() == null)
                root.setRightChild(newNode);
            else
                insert(root.getRightChild(), item);            // recursive call
        }
    }

    public void displayInOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {           // L N R
        if (root == null) {
            return;
        }

        inOrder(root.getLeftChild());
        System.out.print(root.getItem() + " ");
        inOrder(root.getRightChild());
    }


    public void displayPreOrder() {
        preOrder(root);
    }

    private void preOrder (Node root) {	// N L R
        if (root == null)
            return;

        System.out.print(root.getItem() + " ");
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public void displayPostOrder() {
        postOrder(root);
    }

    private void postOrder (Node root) {	// L R N
        if (root == null)
            return;

        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
        System.out.print(root.getItem() + " ");
    }

}