package folder.LIS;

import java.util.Arrays;

public class LIS {

    public static int LISLength(int a[]) {
        int n = a.length;
        int[] t = new int[n];
        t[0] = a[0];
        int lis = 0;
        int index = 0;
        for (int i = 1; i < n; i++) {
            index = BinarySearch(t, a[i], lis);
            t[index] = a[i];
            System.out.println("t["+index+"]="+a[i]);
            if (index > lis) lis++;
        }
        return lis+1;
    }

    public static int BinarySearch(int[]t, int a, int lis){
        if(a<t[0])return 0;
        if(a>t[lis])return lis+1;
        int start = 0;
        while (start<=lis){
            int middle = (start+lis)/2;
            if(start==lis)return start;
            else{
                if(t[middle]==a)return middle;
                if(a<t[middle])lis = middle;
                else{
                    start = middle+1;
                }
            }
        }
        return -1;
    }


    public static int[] LongestIncrSubseq(int[]a){
        int n = a.length;
        int[][]mat = new int[n][n];
        mat[0][0] = a[0];
        int lis=0;
        for(int i=1; i<n; i++){
            int index = BinarySearchLong (mat,a[i],lis);
            for(int j=0; j<index; j++){
                mat[index][j] = mat[index-1][j];
            }
            mat[index][index] = a[i];
            if(index>lis)lis++;
        }

        for(int k=0; k<n; k++){
            System.out.println(Arrays.toString(mat[k]));
        }


        int []ans = new int[lis+1];
        for (int j=0; j<lis+1; j++){
            ans[j] = mat[lis][j];
        }
        return ans;
    }

    public static int BinarySearchLong(int[][]mat, int a, int lis){
        int start = 0;
        int end = lis;

        if(a<mat[0][0])return 0;
        if(a>mat[end][end])return end+1;

        while (start<=end){
            if(start == end){
                return start;
            }
            int middle = (start+end/2);
            if(mat[middle][middle]==a)return middle;
            if(mat[middle][middle]<a)start = middle+1;
            if(mat[middle][middle]>a)end = middle;
        }
        return -1;
    }

    public static int[] LDS(int[]a){
        int n = a.length;
        int[][]mat = new int[n][n];
        mat[0][0] = a[0];
        int lis=0;
        for(int i=1; i<n; i++){
            int index = BinarySearchRevers (mat,a[i],lis);
            for(int j=0; j<index; j++){
                mat[index][j] = mat[index-1][j];
            }
            mat[index][index] = a[i];
            if(index>lis)lis++;
        }

        for(int k=0; k<n; k++){
            System.out.println(Arrays.toString(mat[k]));
        }


        int []ans = new int[lis+1];
        for (int j=0; j<lis+1; j++){
            ans[j] = mat[lis][j];
        }
        return ans;
    }

    public static int BinarySearchRevers(int[][]mat, int a, int lis){
        int start = 0;
        int end = lis;

        if(a>mat[end][end])return 0;
        if(a<mat[0][0])return end+1;

        while (start<=end){
            if(start == end){
                return start;
            }
            int middle = (start+end/2);
            if(mat[middle][middle]==a)return middle;
            if(mat[middle][middle]<a)end = middle;
            if(mat[middle][middle]>a)start = middle+1;
        }
        return -1;
    }







//    public static void LISlength(int[]list){
//        int len = list.length;
//      int[][]mat = buildMat(list);
//      int i=0;
//      int j=0;
//      mat[0][0] = list[i];
//      i++;
//
//      while (len>0) {
//          if (list[i] > list[i - 1]) {
//              mat[i][j++] = mat[i - 1][j];
//              mat[i][j] = list[i];
//              len--;
//          }
//          if(list[i] < list[i - 1]){
//             mat[i-1][j] = list[i];
//             len--;
//              }
//          }
//        int listLen = 0;
//      for(int y=0; y<mat.length; y++){
//          if((mat[mat.length-1][y]) != 0)listLen++;
//      }
//      }


    public static int[][] buildMat(int[]list){

        int len = list.length;
        int[][]lis = new int[len][len];

        return lis;
    }
    public static void main(String[]args){
       int[]arr = {8,4,12,2,3,10,14};
//        System.out.println(LISLength(arr));
//        int[]arr2 = LongestIncrSubseq(arr);
//        int n = arr2.length;
//        for(int i=0; i<n; i++){
//            System.out.println("arr2["+i+"]="+arr2[i]);
//        }
        int[]arr3 = LDS(arr);
            int n3 = arr3.length;
        for(int i=0; i<n3; i++){
            System.out.println("arr3["+i+"]="+arr3[i]);
        }
    }

}
