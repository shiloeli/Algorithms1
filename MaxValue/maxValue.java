package folder.MaxValue;

public class maxValue {

    public static int getMax(int[] a){
       int len = a.length;
       int max = a[0];
       for (int i=1; i<len; i++){
          if(a[i]>max)max = a[i];
       }
        return max;
    }

    public static void main (String[]args){
        int[]shilo = new int[10];
        for(int i=0; i<10; i++){
            shilo[i] = i;
        }
        shilo[5] = 241;
        int max = getMax(shilo);
        System.out.println(max);
    }
}
