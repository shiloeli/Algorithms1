package folder;

import java.util.ArrayList;

public class LISplus {


    public static void max_abs(int[] abs, int k) {
        int n = abs.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(abs[0]);
        int j = 0;
        for (int y = 0; y < n; y++) {
            for (int i = 1 + y; i < n; i++) {
                int tempo = abs[i];
                if (Math.abs(temp.get(j) - tempo) == k) {
                    System.out.println(tempo);
                    temp.add(tempo);
                }
            }
            if (temp.size() > ans.size()) {
                ans = temp;
                j = 0;
            }
        }
        System.out.println(ans);
    }


    public static void main(String[]args){
        int[]arr = {1,2,3,4,5,6,7,8,9};
        max_abs(arr, 2);
    }
}