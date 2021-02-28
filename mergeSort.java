package folder;

public class mergeSort {


    public static int MergeSort(int[] arr, int start, int end){
        int[]ans =new int[arr.length];
        int k=0;
        if (start<end) {
            int middle = (end - start) / 2;
            int i = MergeSort(arr, start, middle);
            int j = MergeSort(arr, middle + 1, end);
            if (i < j) {
                arr[k++] = i;
            } else {
                arr[k++] = j;
            }
        }
        return arr[k];
        }


       public static void main(String[]args){
        int[]arr= {1,4,3,8,5};
        MergeSort(arr,0,arr.length-1);
       }


}
