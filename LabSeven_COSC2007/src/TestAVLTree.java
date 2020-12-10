public class TestAVLTree {
    public static void main(String[] args) {
        AVLTree newTree = new AVLTree();

        newTree.insert(20);
        newTree.insert(10);
        newTree.insert(30);
        newTree.insert(5);
        newTree.insert(1);

        newTree.remove(20);

        newTree.displayInOrder();
        newTree.displayPreOrder();
        newTree.displayPostOrder();
    }
}
