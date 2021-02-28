package folder.TurtleAndRabbitProblemWithArm;


public class TurtleAndRabbitProblemWithArm {

    public static boolean hasLoop(Node head) {
        if (head == null) return false;
        Node fast = head.next;
        Node slow = head;
        boolean ans = true;
        while (ans) {
            if (fast == null || slow == null || fast.next == null) return false;
            if (fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return ans;
    }

    public static int findLoopStart(Node head){
        if(head == null){
            throw new RuntimeException(("empty list"));
        }
        Node fast = head.next;
        Node slow = head;
        boolean ans = false;
        while (!ans){
            if(fast == null || fast.next == null || slow == null )break;
            if (fast == slow) ans = true;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(ans){
            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            if(fast == slow) return fast.data;
        }
        return -1;
    }

    public static int armLength(){
        int ans = -1;
        boolean ToRun = true;
        boolean flag = true;

        LinkedList list= new LinkedList();
        for (int i = 1; i <= 8; i++) {
            list.Add(i);
        }
        list.tail.next = list.head.next.next.next;

        Node turtle = list.head;
        Node rabbit = list.head;

        while (flag) {
            if (turtle.next == null || rabbit.next == null || rabbit.next.next == null) {
                System.out.println("no Cycle");
                flag = false;
                ToRun = false;
            } else {
                turtle = turtle.next;
                rabbit = rabbit.next.next;

                if (turtle.data == rabbit.data) {
                    flag = false;
                    ToRun = true;
                }
            }
        }
        rabbit = list.head;
            while (ToRun){
                ans++;
                if (rabbit.data == turtle.data) {
                    ToRun = false;
                }else {
                    rabbit = rabbit.next;
                    turtle = turtle.next;
                }
                }

        return ans;
            }


    public static int findLoopLength(Node head){
        if(head == null){
            throw new RuntimeException(("empty list"));
        }
        Node fast = head.next;
        Node slow = head;
        int count = 0;
        boolean ans = false;

        while (!ans){
            if(fast == null || fast.next == null || slow == null )break;
            if (fast == slow) ans = true;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = fast.next;
        count++;
                while (fast != slow) {
                fast = fast.next;
                count++;
            }
                count++;
        return count;
        }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            list.Add(i);
        }
//        list.tail.next = list.head;
//        System.out.println(hasLoop(list.head));
            list.tail.next = list.head;
//            System.out.println(hasLoop(list.head));
//            System.out.println("loop start: "+findLoopStart(list.head));
            System.out.println("arm length: "+armLength());
//        System.out.println("loop length: "+findLoopLength(list.head));


    }
}