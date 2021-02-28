package folder.PlanePoblem;

public class lostPathFronXtoY {

    public static int bestPathfromXtoY(Node[][] mat, int p1, int q1, int p2, int q2) {

        for (int j = q1 + 1; j <= q2; j++) {
            mat[p1][j].price = mat[p1][j - 1].price + mat[p1][j - 1].x;
            System.out.println(mat[p1][j].price+" i="+p1+" j="+j);
            mat[p1][j].nPaths = 1;
        }

        for (int i = p1 + 1; i <= p2; i++) {
            mat[i][q1].price = mat[i - 1][q1].price + mat[i - 1][q1].y;
            mat[i][q1].nPaths = 1;
        }


        for (int i = p1 + 1; i <= p2; i++) {
            for (int j = q1 + 1; j <= q2; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;

                if (a < b) {
                    mat[i][j].price = a;
                    mat[i][j].nPaths = mat[i - 1][j].nPaths;
                } else {
                    mat[i][j].price = b;
                    mat[i][j].nPaths = mat[i][j - 1].nPaths;
                }
            }
        }
        System.out.println("price is: " + mat[p2][q2].price);
        return mat[p2][q2].price;
    }



    public static boolean check(Node[][] mat, int  p1, int q1, int p2,int q2){
        int total  = bestPathfromXtoY(mat,0,0,2,2);
        System.out.println(bestPathfromXtoY(mat,0,0,2,2));
        int first1 = bestPathfromXtoY(mat, 0,0,p1,q1);
        System.out.println(bestPathfromXtoY(mat, 0,0,p1,q1));
        int middle  = bestPathfromXtoY(mat,p1,q1,p2,q2);
        System.out.println(bestPathfromXtoY(mat,p1,q1,p2,q2));
        int first2 = bestPathfromXtoY(mat, 0,0,p2,q2);
        System.out.println( bestPathfromXtoY(mat, 0,0,p2,q2));
        int last = bestPathfromXtoY(mat, p2,q2,2,2);
        System.out.println(bestPathfromXtoY(mat, p2,q2,2,2));

        boolean ans = true;

        if(p2<p1||q1>q2){
            ans = false;
        }

        if((first1+(middle-first1)+(last-first2)) != total){
             ans = false;

        }
        return ans;
    }

    public static void main(String[]args){
        Node[][]mat = Node.buildMatrix();
        bestPathfromXtoY(mat, 0,0,2,2);
//        System.out.println(check(mat, 1,1,2,2));
    }

}