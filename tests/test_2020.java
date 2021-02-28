package folder.tests;

public class test_2020 {
//1
    public static String LCS(String a, String b){
        int lenA = a.length()+1;
        int lenB = b.length()+1;

        int[][]mat = new int[lenA][lenB];

        for(int i=0; i<lenA; i++){
            mat[i][0]=0;
        }

        for(int j=0; j<lenB; j++){
            mat[0][j]=0;
        }

        for(int i=1; i<lenA; i++){
            for(int j=1; j<lenB; j++){
                if (a.charAt(i-1)==b.charAt(j-1)){
                    mat[i][j]=mat[i-1][j-1]+1;
                }else{
                    mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }

        int length = mat[mat.length-1][mat[0].length-1];
        int i=mat.length-2;
        int j=mat[0].length-2;
        int count = length;
        String s = "";



        while (count>0) {
            if(a.charAt(i)==b.charAt(j)){
                s=a.charAt(i)+s;
                i--;
                j--;
                count--;
            }else if(a.charAt(i)==b.charAt(j-1)){
                j--;
            }else {
                i--;
            }
        }
        return s;
    }


public static String LCSbest(String a, String b){
        int i = 0;
        int j = 0;
        String s = "";
        int sumA =a.length();
        int sumB =b.length();
        while (i<a.length()&&j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                s=s+a.charAt(i);
                i++;
                j++;
                sumA--;
                sumB--;
            }else{
                if(sumA>sumB){
                    s=s+a.charAt(i);
                    i++;
                    sumA--;
                }else {
                    s=s+b.charAt(j);
                    j++;
                    sumB--;
                }
            }
        }
        return s;
}


//2

//    public static int palneProblem(Node[][]mat){
//
//        int m = mat.length;
//        int n = mat[0].length;
//
//        for (int i = 1; i < n; i++) {
//            mat[0][i].price = mat[0][i - 1].price + mat[0][i - 1].x;
//            mat[0][i].nPaths = 1;
//        }
//
//        for (int j = 1; j < m; j++) {
//            mat[j][0].price = mat[j - 1][0].price + mat[j - 1][0].y;
//            mat[j][0].nPaths = 1;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                int a = mat[i - 1][j].price + mat[i - 1][j].y;
//                int b = mat[i][j - 1].price + mat[i][j - 1].x;
//
//                if (a < b) {
//                    mat[i][j].price = a;
//                    mat[i][j].nPaths = mat[i-1][j].nPaths;
//                } else if (a > b) {
//                    mat[i][j].price = b;
//                    mat[i][j].nPaths = mat[i][j - 1].nPaths;
//                } else {
//                    mat[i][j].price = a;
//                    mat[i][j].nPaths = mat[i][j - 1].nPaths + mat[i - 1][j].nPaths;
//                }
//            }
//        }
//        return mat[m-1][n-1];
//    }





    public static void main (String[]args){
        String a= "abcbdab";
        String b= "bdcaba";

        System.out.println(LCS(a,b));
        System.out.println(LCSbest(a,b));
    }
}
