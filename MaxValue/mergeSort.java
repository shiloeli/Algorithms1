//package MaxValue;
//
//import java.util.Arrays;
//
//public class mergeSort {
//
//        public static int[] Merge(int[] A, int[] B) {
//
//            int a,b,iAll;
//            a=b=iAll=0;
//            int[] all = new int[A.length+B.length];
//
//            while(a < A.length && b < B.length) {
//                if(A[a] < B[b]) all[iAll++] = A[a++];
//                else all[iAll++] = B[b++];
//            }
//
//            while(a < A.length) {
//                all[iAll++] = A[a++];
//            }
//            while(b < B.length) {
//                all[iAll++] = B[b++];
//            }
//
//            return all;
//        }
//
//        public static void MergeSort(int[] arr) {
//            MergeSort(arr,0,arr.length);
//        }
//
//        private static void MergeSort(int[] arr, int low, int high) {
//
//            int n = high-low;
//            if(n <= 1) return; //if the array exist 1 number of empty
//            int mid = (low+high)/2;
//            MergeSort(arr, low,mid);
//            MergeSort(arr, mid,high);
//
//            //Merge the sorted sub-arrays: arr[low,mid) , arr[mid,high)
//            int [] temp = new int[n];
//            int i = low, j = mid , k=0;
//
//            while(i < mid && j < high) {
//                if(arr[j] < arr[i]) temp[k++] = arr[j++];
//                else temp[k++] = arr[i++];
//            }
//
//            while(i < mid) temp[k++] = arr[i++];
//            while(j < high) temp[k++] = arr[j++];
//
//            for(int p = 0 ; p < n ; p++) {
//                arr[p+low] = temp[p];
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] a = {1,3,5,7,9};
//            int[] b = {2,4,6,8,10};
//
////		System.out.println(Arrays.toString(Merge(a,b)));
//
//            int[] c = {10,9,8,7,6,5,4};
//            MergeSort(c);
//            System.out.println(Arrays.toString(c));
//        }
//    }
//}
