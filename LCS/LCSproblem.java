package folder.LCS;

public class LCSproblem {

    public static int[][] buildMatrix(String X, String Y) {
        int lenA = X.length() + 1;
        int lenB = Y.length() + 1;
        int[][] mat = new int[lenA][lenB];
        for (int i = 0; i < lenA; i++) {
            mat[i][0] = 0;
        }
        for (int j = 0; j < lenB; j++) {
            mat[0][j] = 0;
        }

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }

            }
        }
        int length = mat[lenA-1][lenB-1];// length of long string
        return mat;
    }


    public static int getLength(String X, String Y) {
        int lenA = X.length() + 1;
        int lenB = Y.length() + 1;
        int[][] mat = new int[lenA][lenB];
        for (int i = 0; i < lenA; i++) {
            mat[i][0] = 0;
        }
        for (int j = 0; j < lenB; j++) {
            mat[0][j] = 0;
        }

        for (int i = 1; i < lenA; i++) {
            for (int j = 1; j < lenB; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        int length = mat[lenA-1][lenB-1];// length of long string
        return length;
    }




    public static String maxSequnce(String X, String Y){
        int[][]matrix = buildMatrix(X, Y);
        String s = "";
        int row = matrix.length;
        int col = matrix[0].length;
        int seqLength = matrix[row-1][col-1];
        int count = seqLength-1;
        int i=row-1;
        int j=col-1;
    while ( count>=0) {
            if (X.charAt(i-1) == Y.charAt(j-1)) {
                s =X.charAt(i-1)+s;
                i--;
                j--;
                count--;
            } else if(matrix[i][j]==matrix[i][j-1]) {
                j--;
            }else i--;
            }
        return s;
        }


public static void main(String[]args) {
    String s = "hhshilo";
    String e = "shi";
    System.out.println(maxSequnce(s,e));
}
}

