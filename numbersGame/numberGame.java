package folder.numbersGame;

public class numberGame {

    public static int[][] buildMatrix(int game[]){
        int n=game.length;
        int[][]mat = new int[n][n];

        for(int i =0; i<n; i++){
            mat[i][i] = game[i];
        }

        for(int i=n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                mat[i][j] = Math.max(game[i]-mat[i+1][j], game[j]-mat[i][j-1]);
            }
        }
        return mat;
    }


    public static void gameStrategy(int[]game) {
        int i = 0;
        int n = game.length;
        int j = n - 1;
        int[][] mat = buildMatrix(game);
        int sum1 = 0;
        int sum2 = 0;

        for (int k = 0; k < n / 2; k++) {
            if (game[j] - mat[i][j - 1] > game[i] - mat[i + 1][j]) {
                sum1+=game[j];
                System.out.println("playr1=" + game[j]+" sum="+sum1);
                j--;
            } else {
                sum1+=game[i];
                System.out.println("playr1=" + game[i]+" sum="+sum1);
                i++;
            }
            if (game[j] - mat[i][j - 1] > game[i] - mat[i + 1][j]) {
                sum2+=game[j];
                System.out.println("playr2=" + game[j]+" sum="+sum2);
                j--;
            } else {
                sum2+=game[i];
                System.out.println("playr2=" + game[i]+" sum="+sum2);

                i++;
            }
        }
        System.out.println("diff="+(sum1-sum2));
    }





//            if((game[i]-mat[i][j-1])>(game[j]-mat[i+1][j])) {
//                firstSum = firstSum + game[i];
//                first=i++;
//            } else{
//                    firstSum=firstSum+game[j];
//                    first=j--;
//            }
//            if(i!=j){
//                if(game[i]-mat[i+1][j]>game[j]-mat[i][j-1]){
//                    secondSum = secondSum +game[i];
//                    second=i++;
//                }else{
//                    secondSum = secondSum +game[i];
//                    second= j--;
//                }
//
//            }else{
//                second = j;
//                secondSum = secondSum+game[i];            }
//        }
        ;







    public static void main(String[]args){
        int[]game = {4,8,3,1,5,9};
//        buildMatrix(game);
        gameStrategy(game);
    }
}
