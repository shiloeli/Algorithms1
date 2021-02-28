package folder.tests;

import java.util.Arrays;

public class test_3_10_17 {
//1q
    public static int maxSqure(int[][]mat){
        int n = mat.length;
        int[][]ans = new int[n][n];
        int max = 0;
        int min=0;

        for (int i=0; i<n; i++){
            ans[0][i] = mat[0][i];
            ans[i][0] = mat[i][0];
            if(ans[0][i]==1||ans[i][0]==1)max = 1;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<n; j++){
                if(mat[i][j]==0)ans[i][j]=0;
                else {
                    min = Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]);
                    ans[i][j] = min + 1;
                }
                if(ans[i][j]>max)max=ans[i][j];
            }
        }
        return max;
    }


    public static int allSqure2(int[][]mat){
        int n = mat.length;
        int [][]ans = new int[n][n];
        int max = 0;
        int count=0;
        int min=0;

        for(int i=0; i<n; i++){
            ans[i][0]=mat[i][0];
            ans[0][i]=mat[0][i];
        }

        for(int i=1; i<n; i++) {
            for (int j = 1; j < n; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                } else {
                    min = Math.min(Math.min(ans[i][j - 1], ans[i - 1][j]), ans[i - 1][j - 1]);
                    ans[i][j] = min + 1;
                    if (ans[i][j] == 2) {
                        count++;
                        ans[i][j] = 1;
                    }
                }
            }
        }
        return count;
    }

    //2q

    public static int[] LISinCircle(int[]circle){
        int n = circle.length;
        int [][]mat = new int[n][n];
        mat[0][0]=circle[0];
        int last=0;
        int a=0;

            for (int i = 1; i < circle.length; i++) {
                int index = BinarySearchCircle(mat, circle[i], last);

                if (index > 0 && circle[i] <= mat[index][index - 1]) {
                    System.out.println("circle[i]=" + circle[i]);
                    System.out.println("mat[index][index-1]" + mat[index][index - 1]);
                    mat[index][index - 1] = mat[index - 1][index - 1];

                }
                System.out.println(Arrays.deepToString(mat));
                System.out.println("a=" + circle[i]);
                System.out.println("index=" + index);
                System.out.println("last=" + last);
                for (int j = 0; j < index; j++) {
                    mat[index][j] = mat[index - 1][j];
                }
                mat[index][index] = circle[i];
                if (last < index) last++;
        }
            for(int i=0; i<circle.length; i++) {
                if (circle[i] > mat[last][last]) {
                    for (int j = 0; j < mat[last].length; j++) {
                        mat[last + 1][j] = mat[last][j];
                    }
                    mat[last + 1][last + 1] = circle[i];
                    last++;
                }
            }
        int[]ans = new int[last+1];
        for(int i=0; i<ans.length; i++){
            ans[i]=mat[last][i];
        }
        return ans;
    }




    public static int BinarySearchCircle(int[][]mat, int a, int last){
        int start = 0;
        int end = last;
        if(a<mat[0][0])return 0;
        if(a>mat[end][end])return end+1;

        while (start<=end){
            if(start==end)return start;

        int middle = (start+end)/2;
            System.out.println("middle="+middle);
        if(a==mat[middle][middle])return middle;
        if(a>mat[middle][middle]) start=middle+1;
        if(a<mat[middle][middle]) end = middle;
        }
        return -1;
    }


    public static int fibonacci(int num) {
        int[][] ans = {{1, 1},
                      {1, 0}};

        int[][] b = {{1, 1},
                    {1, 0}};

        int n = num - 2;

        while (n != 0) {
            if (n % 2 == 1) {
                ans[0][0] = (ans[0][0] * b[0][0]) + (ans[0][1] * b[1][0]);
                ans[0][1] = (ans[0][0] * b[0][1]) + (ans[0][1] * b[1][1]);
                ans[1][0] = (ans[1][0] * b[0][0]) + (ans[1][1] * b[1][0]);
                ans[1][1] = (ans[1][0] * b[0][1]) + (ans[1][1] * b[1][1]);
            }
                b[0][0] = (b[0][0] * b[0][0]) + (b[0][1] * b[1][0]);
                b[0][1] = (b[0][0] * b[0][1]) + (b[0][1] * b[1][1]);
                b[1][0] = (b[1][0] * b[0][0]) + (b[1][1] * b[1][0]);
                b[1][1] = (b[1][0] * b[0][1]) + (b[1][1] * b[1][1]);

            n = (n / 2);
        }
        return ans[0][0];
    }


    //4


  public static String a(String a, String b){
        String ans = "";
        if(a.length()>b.length())ans = a;
        else if(b.contains(a)) {
            ans = null;
        }else {
            ans=a;
        }
        return ans;



    }public static void main(String[]args){
        int[][]squre = {{0,0,1,0,1},{0,1,1,1,1},{1,1,1,1,0},{0,1,1,1,1},{0,0,1,1,1}};
//        System.out.println(maxSqure(squre));
//        System.out.println(allSqure2(squre));
        int[]arr={9,10,8,0,1,4,3,7};
//        System.out.println(Arrays.toString(LISinCircle(arr)));
//        System.out.println(fibonacci(3));
        System.out.println(a("shiloeli","shilo"));
    }
}
