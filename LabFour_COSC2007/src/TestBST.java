public class TestBST {
    public static void main(String[] args) {
        BST myTree = new BST();

        myTree.insert(20);
        myTree.insert(10);
        myTree.insert(30);
        myTree.insert(1000);
        myTree.insert(-12);
        myTree.insert(21);
        myTree.insert(981);
        myTree.insert(99);
        myTree.insert(50);
        myTree.insert(40);

        myTree.displayInOrder();


        System.out.println("The min item in the tree is: " + myTree.findMin());
        System.out.println("The max item in the tree is: " + myTree.findMax());

        System.out.print("After deleting 1000, ");
        myTree.delete(1000);
        System.out.println("the max item in the tree is: " + myTree.findMax());
    }
}
