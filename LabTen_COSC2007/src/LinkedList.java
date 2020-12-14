//public class LinkedList<T> {
//
//    private class Node {
//        private T item;
//        private Node next;
//
//        public Node (T item) {
//            this.item = item;
//            this.next = null;
//        }
//
//        public Node (T item, Node next) {
//            this.item = item;
//            this.next = next;
//        }
//
//    }
//
//    private Node head;
//
//    public LinkedList() {
//        head = null;
//    }
//
//    public int size() {
//        int size = 0;
//        Node curr = head;
//        while (curr != null) {
//            curr = curr.next;
//            size++;
//        }
//        return size;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void add(T item) {
//        Node prev = null;
//        Node curr = head;
//
//        while (curr != null) {
//            prev = curr;
//            curr = curr.next;
//        }
//
//        prev.next = new Node(item);
//
//    }
//
//    public void add(T item, int pos) {
//        if (pos < 1) pos = 1;
//
//        int currPos = pos;
//
//        Node prev = null;
//        Node curr = head;
//
//        while (curr != null && currPos != 1) {
//            prev = curr;
//            curr = curr.next;
//            currPos--;
//        }
//
//        if (prev != null) {
//            prev.next = new Node(item, curr);
//        } else {
//            head = new Node(item, curr);
//        }
//    }
//
//    public T poll() {
//        T temp = head.next.item;
//
//        if (head == head.next) {
//            head = null;
//        } else {
//            head.next = head.next.next;
//        }
//        return temp;
//    }
//
//}
