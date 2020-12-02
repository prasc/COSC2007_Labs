public class BST {
    private Node root;

    public BST() {
        this.root = null;
    }

    public void insert(Integer item) {
        if (root == null) {
            root = new Node(item);
        } else {
            insertRecursive(root, item);
        }
    }

    private void insertRecursive(Node curr, Integer item) {
        Node newNode = new Node(item);

      if (item < curr.getItem()) {
          if (curr.getLeftChild() == null) {
              curr.setLeftChild(newNode);
          } else {
              insertRecursive(curr.getLeftChild(), item);
          }
      } else {
          if (curr.getRightChild() == null) {
              curr.setRightChild(newNode);
          } else {
              insertRecursive(curr.getRightChild(), item);
          }
      }
    }


    public void displayInOrder() {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        else {
            inOrder(root);
        }
    }

    private void inOrder(Node curr) {
        if (curr != null) {
            inOrder(curr.getLeftChild());
            System.out.println(curr.getItem() + " ");
            inOrder(curr.getRightChild());
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

    public void delete(Integer item) {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            deleteRecursively(root, item);
        }
    }

    private Node deleteRecursively(Node curr, Integer item) {
        if (curr == null) {
            return null;
        }

        if (item < curr.getItem()) {
            curr.setLeftChild(deleteRecursively(curr.getLeftChild(), item));
        } else if (item > curr.getItem()) {
            curr.setRightChild(deleteRecursively(curr.getRightChild(), item));
        }
        else {
            if (curr.getLeftChild() == null) {
                return curr.getRightChild();
            } else if (curr.getRightChild() == null) {
                return curr.getLeftChild();
            }

            curr.setItem(findMin(curr.getRightChild()));

            curr.setRightChild(deleteRecursively(curr.getRightChild(), item));
        }
        return curr;
    }
}
