package folder.MaxValue;

import java.util.ArrayList;
import java.util.List;

public class maxMinValue {

    public static String getMaxMinOfBook(int[] arr){
        int comparisons = 1;
        int min = arr[0];
        int max = arr[1];
        if(arr[0]>arr[1]){
            max = arr[0];
            min  = arr[1];
        }
        for(int i=2; i<arr.length-1; i = i+2){
            comparisons++;
            if(arr[i]<=arr[i+1]){
                comparisons += 2;
                if(arr[i+1]>max)max = arr[i+1];
                if(arr[i]<min)min = arr[i];
            }else{
                comparisons += 2;
                if(arr[i]>max)max = arr[i];
                if(arr[i+1]<min)min = arr[i+1];
            }
        }
        System.out.println(comparisons);
        return ("maximum="+max+"minimum="+min);
    }




    //my version
    public static List getMaxMin(int[] arr) {
        int min, max;
        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }
        for (int i = 2; i < arr.length - 1; i=i+2) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > max) max = arr[i];
                if (arr[i + 1] < min) min = arr[i + 1];
            } else {
                if (arr[i + 1] > max) max = arr[i + 1];
                if (arr[i] < min) min = arr[i];
            }
        }
        List<Integer> minMax = new ArrayList<>();
        minMax.add(max);
        minMax.add(min);
        return minMax;
    }


    public static void main(String[] args) {
        int[]number = new int[10];
        int len = number.length;
        for(int i=0; i<len; i++){
            number[i] = i;
        }

        number[3] = 241;
        number[7]  = 0;
//        System.out.println(getMaxMin(number));
        System.out.println(getMaxMinOfBook(number));
    }
}