package folder;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Fibonaci_log_n {


    public static int fibonnaci(int n){
        int ans[][]={{1,1},
                     {1,0}};
        int temp [] [] = ans;

        int a[][] = {{1,1},
                     {1,0}};

        n=n-2;
        while (n!=0) {
            if (n % 2 == 1) {
                temp[0][0] = (ans[0][0] * a[0][0])+(ans[0][1] * a[1][0]);
                temp[0][1] = (ans[0][0] * a[0][1])+(ans[0][1] * a[1][1]);
                temp[1][0] = (ans[1][0] * a[0][0])+(ans[1][1] * a[1][0]);
                temp[1][1] = (ans[1][0] * a[0][1])+(ans[1][1] * a[1][1]);
                 ans=temp;
                System.out.println("ans:n="+n+" mat="+Arrays.deepToString(ans));
            }

            a[0][0] = (a[0][0] * a[0][0])+(a[0][1] * a[1][0]);
            a[0][1] = (a[0][0] * a[0][1])+(a[0][1] * a[1][1]);
            a[1][0] = (a[1][0] * a[0][0])+(a[1][1] * a[1][0]);
            a[1][1] = (a[1][0] * a[0][1])+(a[1][1] * a[1][1]);
            System.out.println("a:n="+n+" mat="+Arrays.deepToString(a));
            n = (n / 2);
        }
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepToString(ans));
        return ans[0][0];



    }


    public static void main(String[]args){
        System.out.println(fibonnaci(5));


    }
}
