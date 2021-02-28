package folder.ParkingProblem;

public class CalcCarsLinkedList {
    LinkedLinkListCycle cars;
    final int nLetters = 23, size = 13;
    final char v = 'v', w = 'w';

        public CalcCarsLinkedList(){
            cars= new LinkedLinkListCycle();
            for(int i=0; i<size; i++){
                char c = (char)('a'+(int)(Math.random()*nLetters));
                System.out.println(c);
                cars.add(c);
            }
        }
        public int calcars(){
            cars.getHead().setData(v);
            System.out.println( "first:"+cars.getHead().getData());
            LinkedLinkListCycle.Node t = cars.getHead().getNext();
            boolean flag = true;
            int count = 1;

            while (flag){
                System.out.println(t.getData());
                if(t.getData()==v){
                    t.setData(w);
                    int i = count;

                    while (i>0){
                        t = t.getPrev();
                        i--;
                    }
                    if(t.getData() == w) flag = false;
                    else {
                        count =1;
                        t = cars.getHead().getNext();
                    }
                }
                else {
                    t = t.getNext();
                    count++;
                }
            }
            return count;
        }
}
