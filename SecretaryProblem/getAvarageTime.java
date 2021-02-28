package folder.SecretaryProblem;

import java.util.Arrays;

public class getAvarageTime {

    public static double getAvarage(int[] times){
        Arrays.sort(times);
        double avg = 0;
        for(int x: times) avg = avg + x;
        return avg/times.length;
    }

    public static void main(String[]args){
        int[]arr = new int[5];
        arr[0] = 10;
        arr[1] = 10;
        arr[2] = 10;
        arr[3] = 10;
        arr[4] = 10;
        System.out.println(getAvarage(arr));
    }
}
