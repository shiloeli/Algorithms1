package folder.ParkingProblem;


public class LinkedLinkListCycle {

     class Node {
        private char data;
        private Node prev, next;

        public Node(char data, Node prev, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public String toString() { return "" + this.data; }
        public void setData(char c) { this.data = c; }
        public char getData() { return this.data; }
        public Node getNext() { return this.next; }
        public Node getPrev() { return this.prev; }

    }

    private Node head, tail;
    private int size;

    public LinkedLinkListCycle(){
        head = tail = null;
        size = 0;
    }

    public void add(char obj){
        if(head == null){
            head = new Node(obj, null,null);
            tail = head;
            head.next = head.prev = tail;
        }else{
            Node n  = new Node(obj,tail,head);
            tail.next = n;
            tail = n;
            head.prev = tail;
        }
        size++;
    }
    public Node getHead(){
        return head;
    }
    public Node getNext(Node n){
        return n.next;
    }
    public String toString() {
        String s = "[";
        if(head != null){
            s = s + head.toString() + ", ";
            for (Node n = head.next; n!=head; n=n.next){
                s = s +n.toString() + ", ";
            }
            s=s.substring(0, s.length()-2);
    }
        return s+"]";
    }
}




