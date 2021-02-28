package folder.OneSqureProblem;

import java.util.Arrays;

public class oneSqureProblem {


    public static void subMatrix(int[][]mat){
        int n = mat.length;
        int[][]mat2 = new int[n][n];
        int temp=0;

        for(int i=0; i<n; i++){
            if(mat[i][0]==1)
                mat2[i][0]=1;
            else
                mat2[i][0]=0;
            if(mat2[i][0]>temp)temp=mat2[i][0];
        }

        for(int j=0; j<n; j++){
            if(mat[0][j]==1)
                mat2[0][j]=1;
            else
                mat2[0][j]=0;
            if(mat2[0][j]>temp)temp=mat2[0][j];
        }

        for(int i=1; i<n; i++){
            for (int j=1; j<n; j++){
                if(mat[i][j]==0)mat2[i][j]=0;
                else
                    mat2[i][j]=Math.min(Math.min(mat2[i-1][j-1],mat2[i-1][j]),mat2[i][j-1])+1;
                if(mat2[i][j]>temp)temp=mat2[i][j];
            }
        }
        System.out.println("max squre="+temp);
        System.out.println(Arrays.deepToString(mat2));
    }



    public static void main (String[]args){

        int[][]mat = {{0,0,1},{0,1,1},{0,1,1}};
        subMatrix(mat);

            }
        }


