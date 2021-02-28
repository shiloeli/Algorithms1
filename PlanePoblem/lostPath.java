package folder.PlanePoblem;

public class lostPath {

    public static String onePath(Node[][]mat){
        int m = mat.length;
        int n = mat[0].length;

        int i = m-1;
        int j = n-1;

        String ans = "";

        while ( i>0 && j>0 ){
            int a = mat[i-1][j].price+ mat[i-1][j].y;
            int b = mat[i][j-1].price + mat[i][j-1].x;

            if(a<b){
                ans = "1"+ans;
                i--;
            }
            else{
                ans = "0"+ans;
                j--;
            }
        }
        while (j>0){
            ans = "0"+ans;
            j--;
        }
        while (i>0){
            ans = "1"+ans;
            i--;
        }
        return ans;
    }

    public static void main(String[]args){
         Node[][] matrix = Node.buildMatrix();
        System.out.println(onePath(matrix));
    }




}


