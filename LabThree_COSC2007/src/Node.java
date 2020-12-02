public class Node {
    private Integer item;
    private Node leftChild;
    private Node rightChild;

    public Node() {
        setItem(null);
        setRightChild(null);
        setLeftChild(null);

    }

    public Node (Integer item) {
        setItem(item);
        setRightChild(null);
        setLeftChild(null);
    }


    public void setItem(Integer item)
    {
        this.item = item;
    }

    public Integer getItem()
    {
        return this.item;
    }

    public void setLeftChild(Node n)
    {
        this.leftChild = n;
    }

    public Node getLeftChild()
    {
        return this.leftChild;
    }

    public void setRightChild(Node n)
    {
        this.rightChild = n;
    }

    public Node getRightChild()
    {
        return this.rightChild;
    }

}