package folder.MaxValue.indictive;

import java.util.Stack;

public class Node {

    int num;
    Stack<Integer>st;
    Node next, prev;

    public Node(int num, Node n, Node m){
        this.num = num;
        this.next = n;
        this.prev = m;
        this.st = new Stack<Integer>();
    }

    public static void MaxMaxValueIndoctiv(int[]arr){
        Node head = new Node(arr[0], null, null);
        Node n = head;

        for(int i=1; i<arr.length; i++){
            n.next = new Node(arr[i],null, n);
            n=n.next;
        }
        head.prev = n;
        n.next = head;
        int compere=0, size = arr.length;
        Node n1 =head;
        Node n2 = head.next;

        while(size>1){
            n2 = n1.next;
            compere++;
            if(n1.num< n2.num){
                n2.st.push(n1.num);
                n1.prev.next = n2;
                n2.prev = n1.prev;
            }
            else{
                n1.st.push(n2.num);
                n1.next = n2.next;
                n2.next.prev = n1;
            }
            size--;
            n1= n2.next;
        }
        int Max1 = n1.num;
        int Max2 =n1.st.pop();
        while (!n1.st.isEmpty()){
            System.out.println("here");
            int number = n1.st.pop();
            compere++;
            if(Max2<number) Max2 = number;
        }
        System.out.println("max1="+Max1+", max2="+Max2);
    }


    public static void main(String[]args){
        int[]arr = {1, 3, 9, 55, 32, 6, 9};
        MaxMaxValueIndoctiv(arr);
    }
}
