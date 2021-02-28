package folder.medianProblem;

import java.util.Arrays;

public class medianProblem {

    public static int overMedian(int[]arr){
        int Max=arr[0];
        for(int i=1; i<arr.length-1 && i<64-1; i=i+2){
            if(arr[i]>arr[i+1]){
                if(Max<arr[i])Max=arr[i];
            }else
                if(Max<arr[i+1])Max=arr[i+1];
        }
        return Max;
    }



//    public static int[] overMedia2(int[]a, int[]b) {
//        int len_a = a.length;
//        int len_b = b.length;
//        int[] arr = new int[len_a];
//
//        if (a[0] > b[len_b - 1]) {
//            for (int i = 0; i < len_a; i++) {
//                arr[i] = a[i];
//                System.out.println(a[i]);
//            }
//            return arr;
//        }
//        if (b[0] > a[len_a - 1]) {
//            for (int i = 0; i < len_a; i++) {
//                arr[i] = b[i];
//                System.out.println(b[i]);
//            }
//            return arr;
//        }
//        int k = 0;
//        int i = 0;
//        int j = len_b - 1;
//        while (i < len_a && j >= 0) {
//            if (b[j] > a[i] && j > i) {
//                arr[k++] = a[i++];
//                System.out.println(a[i]);
//            } else {
//                arr[k++] = b[j--];
//                System.out.println(b[j]);
//            }
//        }
//        return arr;
//    }


    public static int[] overMedian2(int[]a, int[]b){
        int n = a.length;
        int[]c = new int[n];
        int i=0;
        int j=n-1;
        int k=0;

        c[0]=Math.max(b[j],a[i]);

        while (k<n){
            if(a[i]>=b[j]){
                c[k++] = a[i++];
            }else {
                c[k++]=b[j--];
            }
        }

return c;
    }

    public static int[] halfArray(int[]a, int[]b){
        int loc = 0;
        int i =0;
        int j = b.length-1;
        int[] ans = new int[a.length];
        while(i<a.length){
            if(a[i]>b[j]){
                if(i<j){
                    while(i<a.length){
                        ans[i]=a[i];
                        i++;
                    }
                    break;
                }
                ans[loc] = a[i];
                loc++;
                i++;
                j--;
            }
            else if(a[i]<b[j]){
                if(j<i){
                    while(j>=0){
                        ans[i]=b[j];
                        i++;
                        j--;
                    }
                    break;
                }
                ans[loc]=b[j];
                loc++;
                i++;
                j--;
            }
            else{
                while(i<a.length){
                    ans[i]=a[i];
                    i++;
                }
            }
        }
        return ans;
    }


    public static void main(String[]args){
        int[]arr = {1,2,3,5,6};
        int[]arr2 = {1,2,7,8,9};
        int[]arr3 = overMedian2(arr,arr2);
        System.out.println(Arrays.toString(arr3));
    }
}
