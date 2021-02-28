package folder.PrisinorsProblem;

public class prisinorsProblem {

    public static int prisnors(int n){

        boolean enter[] = new boolean[n];

        for (int i=0; i<n; i++){
            enter[i]=false;
        }

        Boolean lamp = true;
        int count = 0;
        int steps = 0;

        while (count<n){
            steps++;
            int p = (int) (Math.random() * n);

            if(p==0){
                if(!enter[0]){
                    enter[0] = true;
                    count++;
                }
                if(!lamp) {
                    lamp = true;
                    count++;
                }


                }else{
                if(!enter[p]&&lamp){
                    enter[p]=true;
                    lamp=false;
                }
            }
        }
        System.out.println(count);
      return steps;
    }

    public static int prisnorsExtra(int n){

        int enter[] = new int[n];

        for (int i=0; i<n; i++){
            enter[i]=0;
        }

        Boolean lamp =((int)(Math.random()*2)==0);
        int count = 0;
        int steps = 0;

        while (count<2*n){
            steps++;
            int p = (int) (Math.random() * n);

            if(p==0){
                if(enter[0]==0){
                    enter[0] = 2;
                    count++;
                }
                if(!lamp){
                    lamp = true;
                    count++;
                }


            }else{
                if(enter[p]<2&&lamp){
                    enter[p]++;
                    lamp=false;
                }
            }
        }
        System.out.println(count);
        return steps;
    }

    public static void main(String[]args){
        int n=10;
        prisnorsExtra(2);

    }


}
