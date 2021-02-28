package folder.PlanePoblem;

public class allBestPath {

    public static int allbestPath(Node[][]mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 1; i < n; i++) {
            mat[0][i].price = mat[0][i - 1].price + mat[0][i - 1].x;
            mat[0][i].nPaths = 1;
        }

        for (int j = 1; j < m; j++) {
            mat[j][0].price = mat[j - 1][0].price + mat[j - 1][0].y;
            mat[j][0].nPaths = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;

                if (a < b) {
                    mat[i][j].count = mat[i - 1][j].count;
                    mat[i][j].price = a;
                    mat[i][j].nPaths = mat[i-1][j].nPaths;

                } else if (a > b) {
                    mat[i][j].count = mat[i][j - 1].count;
                    mat[i][j].price = b;
                    mat[i][j].nPaths = mat[i][j - 1].nPaths;
                } else {
                    mat[i][j].count =  mat[i - 1][j].count + mat[i][j - 1].count ;
                    mat[i][j].price = a;
                    mat[i][j].nPaths = mat[i][j - 1].nPaths + mat[i - 1][j].nPaths;
                }
            }
        }
        return mat[m-1][n-1].count;
    }

public static void main(String[]args){
        Node[][] matrix = Node.buildMatrix();
    System.out.println(allbestPath(matrix));


}


}
