package folder.MaxValue;

import java.util.Stack;

public class TwoMaxValue {

    public static class Node{
        int num;
        Stack<Integer>st;

        public Node(int num){
            this.num = num;
            this.st = new Stack<Integer>();
        }

    }
    public static int MaxMax2(Node[]arr ,int low, int hight){

        if(low<hight){
            int index = 0;
            int middle = (hight+low)/2;
            int i= MaxMax2(arr,low, middle);
            int j= MaxMax2(arr,middle+1, hight);

            if(arr[i].num>arr[j].num){
                arr[i].st.push(arr[j].num);
                index=i;
            }else{
                arr[j].st.push(arr[i].num);
                index=j;
            }
            return index;
        }else {
            return low;
        }
    }

    public static void MaxMax2(int[] a){
        int n = a.length;
        Node[]arr = new Node[n];

        for(int i=0; i<n; i++){
            arr[i]=new Node(a[i]);
        }

        int index = MaxMax2(arr,0, n-1);
        int max2 = arr[index].st.pop();

        while(!arr[index].st.empty()){
            int temp=arr[index].st.pop();
            if (temp>max2)max2 = temp;
        }
        System.out.println(arr[index].num);
        System.out.println(max2);

    }



    public static void main(String[]args){
        int a[] = {2,100,5,4,8,6,32,7,9,22,14,1};
        MaxMax2(a);
    }
}
