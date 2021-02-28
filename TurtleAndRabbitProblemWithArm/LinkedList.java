package folder.TurtleAndRabbitProblemWithArm;

public class LinkedList {


        Node head;
        Node tail;
        int counter;

        LinkedList() {
            counter = 0;
            head = tail = null;
        }

        public void Add(int v)
        {
            if (head == null)
            {
                head = new Node(v);
                tail = head;
            }
            else
            {
                tail.next = new Node(v);
                tail = tail.next;
            }
            counter ++;
        }
        public void finish()
        {
            int i = (int)(Math.random()*(counter-4))+1;
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.next;
            }
            tail.next = temp;
        }


    }

