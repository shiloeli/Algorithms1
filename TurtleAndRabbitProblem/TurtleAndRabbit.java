package folder.TurtleAndRabbitProblem;

public class TurtleAndRabbit {
    LinkedLinkListCycle cycle;
    final int nLetters = 23, size = 17;

    public TurtleAndRabbit() {
        cycle = new LinkedLinkListCycle();
        for (int i = 0; i < size; i++) {
            char c = ((char) ('a' + i));
//            System.out.println(c);
            cycle.add(c);
        }
    }

    public boolean ifCycle(){
        boolean flag = true; //סימן תנאי של הלולאה
        boolean ans = false; //פתרון השאלה
        int count = 0;

        LinkedLinkListCycle.Node turtle = cycle.getHead();
        LinkedLinkListCycle.Node rabbit = cycle.getHead();

        while (flag){
            count++;
            if(turtle.getNext() == null || rabbit.getNext() == null || rabbit.getNext().getNext() ==null ){
                System.out.println("no Cycle");
                ans = false;
                flag = false;
            }
            else {

                turtle = turtle.getNext();
                rabbit = rabbit.getNext().getNext();

                System.out.println(turtle.getData());
                System.out.println(rabbit.getData());

                if (turtle.getData() == rabbit.getData()) {
                    System.out.println("is Cycle");
                    System.out.println("in place:"+turtle.getData()+","+rabbit.getData());
                    ans = true;
                    flag = false;
                }

            }
        }
       return ans;
    }
}
