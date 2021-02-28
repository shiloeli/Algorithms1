package folder.tests;

import java.util.ArrayList;

public class test_22_1_18 {

    //3

    public static void numberGame(int[]game) {

        int len = game.length;
        int[][] mat = new int[len][len];

        for (int i = 0; i < len; i++) {
            mat[i][i] = game[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                mat[i][j] = Math.max(game[i] - mat[i + 1][j], game[j] - mat[i][j - 1]);
            }
        }


        int i = 0;
        int n = game.length;
        int j = n - 1;
        int sum1 = 0;
        int sum2 = 0;

        for (int k = 0; k < n / 2; k++) {
            if (game[j] - mat[i][j - 1] > game[i] - mat[i + 1][j]) {
                sum1 += game[j];
                System.out.println("playr1=" + game[j] + " sum=" + sum1);
                j--;
            } else {
                sum1 += game[i];
                System.out.println("playr1=" + game[i] + " sum=" + sum1);
                i++;
            }
            if (j > 0) {
                if (game[j] - mat[i][j - 1] > game[i] - mat[i + 1][j]) {
                    sum2 += game[j];
                    System.out.println("playr2=" + game[j] + " sum=" + sum2);
                    j--;
                } else {
                    sum2 += game[i];
                    System.out.println("playr2=" + game[i] + " sum=" + sum2);
                    i++;
                }
            } else {
                sum2 += game[j];
                System.out.println("playr2=" + game[j] + " sum=" + sum2);
                j--;
            }
        }
                if (game.length % 2 != 0) {
                    sum1 = sum1 + game[j];
                    System.out.println("playr1=" + game[j] + " sum=" + sum1);
                    j--;
                }

            System.out.println("diff=" + (sum1 - sum2));

        }

            public static void numberGameCircle(int[]arr){}
//4
    public static void getLongString(String s) {
        int[] letter = new int[26];
        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char A = s.charAt(i);
            letter[A - 'a']++;
        }
        int j = 0;

        String last = "";
        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i) - 'a'] != 0) {
                last = last + s.charAt(i);
                letter[s.charAt(i) - 'a']--;
            } else {
                word.add(last);
            }
        }
    }



    public static void Q4(String str){
        ArrayList<String> longest = new ArrayList<>();
        String s = ""+str.charAt(0);
        for(int i=1 ; i < str.length() ; i++){
            if(str.charAt(i) != str.charAt(i-1)){
                if(!s.contains(""+str.charAt(i))){
                    s += str.charAt(i);
                }else{
                    longest.add(s);
                    s = ""+str.charAt(i);
                }
            }else{
                longest.add(s);
                s = ""+str.charAt(i);
            }
        }
        longest.add(s);
        System.out.println(longest);
        String max = longest.get(0);
        for(int i=1 ; i < longest.size() ; i++){
            if(longest.get(i).length() > max.length()){
                max = longest.get(i);
            }
        }

        System.out.println("The longest string is "+max);
    }

    public static void main(String[]args){

        String s = "bbbbb";
        Q4(s);



        int[]game = {1,2,8};
        numberGame(game);

    }


}
