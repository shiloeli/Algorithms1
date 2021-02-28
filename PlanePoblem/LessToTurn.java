package folder.PlanePoblem;

import java.util.Arrays;

public class LessToTurn {

    public static void allbestPathListTurn(Node[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        mat[0][0].arr[0] = "";
        for (int i = 1; i < n; i++) {
            mat[0][i].price = mat[0][i - 1].price + mat[0][i - 1].x;
            mat[0][i].arr[0] = mat[0][i - 1].arr[0] + "r";
            mat[0][i].nPaths = 1;
        }

        for (int j = 1; j < m; j++) {
            mat[j][0].price = mat[j - 1][0].price + mat[j - 1][0].y;
            mat[j][0].arr[0] = mat[j - 1][0].arr[0] + "d";
            mat[j][0].nPaths = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].y;
                int b = mat[i][j - 1].price + mat[i][j - 1].x;

                if (a < b) {
                    mat[i][j].count = mat[i - 1][j].count;
                    mat[i][j].price = a;
                    mat[i][j].nPaths = mat[i - 1][j].nPaths;
                    for (int k = 0; k < 10; k++) {
                        if (mat[i - 1][j].arr[k] != null) {
                            mat[i][j].arr[k] = mat[i - 1][j].arr[k] + "d";
                        }
                    }
                } else if (a > b) {
                    mat[i][j].count = mat[i][j - 1].count;
                    mat[i][j].price = b;
                    mat[i][j].nPaths = mat[i][j - 1].nPaths;
                    for (int k = 0; k < 10; k++) {
                        if (mat[i][j - 1].arr[k] != null) {
                            mat[i][j].arr[k] = mat[i][j - 1].arr[k] + "r";
                        }
                    }
                } else {
                    mat[i][j].count = mat[i - 1][j].count + mat[i][j - 1].count;
                    mat[i][j].price = a;
                    mat[i][j].nPaths = mat[i][j - 1].nPaths + mat[i - 1][j].nPaths;
                    int u=0;
                    for (int z = 0; z < 10; z++) {
                        if (mat[i - 1][j].arr[z] != null) {
                            mat[i][j].arr[z] = mat[i - 1][j].arr[z] + "d";
                        } else {

                            if (mat[i][j - 1].arr[u] != null) {
                                mat[i][j].arr[z] = mat[i][j - 1].arr[u] + "r";
                                u++;
                            }
                        }

                    }
                }
            }
        }
        String best = "";
        int bestTurn = mat.length+mat[0].length;
        int Turn=0;
        for(int i=0; i<mat[m-1][n-1].arr.length; i++) {
            if (mat[m - 1][n - 1].arr[i] != null) {
                String s = mat[m - 1][n - 1].arr[i];
                char first = s.charAt(0);
                for (int j = 1; j < s.length(); j++) {
                    if (s.charAt(j) != first) {
                        Turn++;
                        first = s.charAt(j);
                    }
                }
                if (Turn < bestTurn) {
                    bestTurn = Turn;
                    best = mat[m - 1][n - 1].arr[i];
                }
                Turn = 0;
            }
        }
        System.out.println("best="+best);
        System.out.println(Arrays.deepToString(mat[m-1][n-1].arr));
        System.out.println(mat[m-1][n-1].nPaths);
    }


    public static void main(String[]args){
        Node[][]matrix = Node.buildMatrix();
        allbestPathListTurn(matrix);
    }

}
