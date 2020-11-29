public class TestTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(10);
        tree.add(15);
        tree.add(5);
        tree.add(12);
        tree.add(100);


        System.out.println("Preorder: ");
        tree.displayPreOrder();
        System.out.println();


        System.out.println("Inorder: ");
        tree.displayInOrder();
        System.out.println();

        System.out.println("Postorder: ");
        tree.displayPostOrder();
        System.out.println();


        System.out.println("Item 0 " + (tree.search(0) ? "does exist." : "does not exist"));
        System.out.println("Item 5 " + (tree.search(5) ? "does exist." : "does not exist"));
        System.out.println("Item 500 " + (tree.search(500) ? "does exist." : "does not exist"));

    }

}
