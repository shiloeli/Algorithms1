package folder.tests;

public class test_31_10_17 {

    public static String LCS(String a, String b){
        int lenA = a.length();
        int lenB = b.length();

        int[][]mat = new int[lenA+1][lenB+1];


        for(int i=0; i<mat.length; i++){
            mat[i][0] = 0;
        }

        for(int j=0; j<mat[0].length; j++){
            mat[0][j] = 0;
        }

        for(int i=1; i<mat.length; i++){
            for(int j=1; j<mat[0].length; j++){
                System.out.println(i);
                System.out.println(j);
                if(a.charAt(i-1)==b.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1]+1;
                }else{
                    mat[i][j]=Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }

        String s ="";
        int len = mat[mat.length-1][mat[0].length-1];
        int i= mat.length-1;
        int j = mat[0].length-1;

        while (len>0){
            if(a.charAt(i-1)==b.charAt(j-1)){
                s=a.charAt(i-1)+s;
                i--;
                j--;
                len--;
            }
            else if(mat[i][j]==mat[i][j-1]){
                j--;
            }else {
                i--;
            }
            }
        return s;
    }


    public static void deleteAndAdd(String a, String b){
        int lenA = a.length();
        int lenB = b.length();

        int i=0;
        int j=0;

        int add = 0;
        int del = 0;

        String s = LCS(a,b);
        del=lenA-s.length();
        add = lenB-s.length();

        System.out.println("add="+add);
        System.out.println("del="+del);
        }











    public static class Node{
        int x_right;
        int y_up;
        int price;
        int path;
        int max_val;

        public Node(int x_right, int y_up){
            this.x_right = x_right;
            this.y_up = y_up;
            this.price = 0;
            this.path = 0;
            this.max_val = 0;
        }

        public static Node bestPath(Node[][]mat, int a1, int b1){
            int n = mat.length;
            int m = mat[0].length;

            for(int i=1; i<n; i++){
                mat[0][i].price = mat[0][i-1].price+mat[0][i-1].x_right;
                mat[0][i].max_val = mat[0][i-1].max_val+mat[0][i-1].x_right;
                mat[0][1].path=1;
            }

            for(int i=1; i<m; i++){
                mat[i][0].price = mat[i-1][0].price+mat[i-1][0].y_up;
                mat[i][0].max_val = mat[i-1][0].max_val+mat[i-1][0].y_up;
                mat[i][0].path = 1;
            }

            for(int i=1; i<n; i++){
                for(int j=1; j<m; j++){
                    int a = mat[i-1][j].price+mat[i-1][j].y_up;
                    int b = mat[i][j-1].price+mat[i][j-1].x_right;

                    int c = mat[i-1][j].max_val+mat[i-1][j].y_up;
                    int d = mat[i][j-1].max_val+mat[i-1][j].x_right;

                    System.out.println(mat[i][j-1].max_val);
                    System.out.println(mat[i-1][j].x_right);

                    System.out.println("a="+a);
                    System.out.println("b="+b);
                    System.out.println("c="+c);
                    System.out.println("d="+d);

                    if(a<b){
                        mat[i][j].price = mat[i-1][j].price+mat[i-1][j].y_up;
                    }
                    if(a>b){
                        mat[i][j].price = mat[i][j-1].price+mat[i][j-1].x_right;
                    }else{
                        mat[i][j].price =  mat[i-1][j].price+mat[i-1][j].y_up;
                    }
                    if(c>d){
                        mat[i][j].max_val =  mat[i-1][j].max_val+mat[i-1][j].y_up;
                    }else{
                        mat[i][j].max_val =  mat[i][j-1].max_val+mat[i-1][j].x_right;
                    }

                }
            }
            System.out.println(mat[1][1].max_val);
            System.out.println("max ="+mat[a1][b1].max_val);
            System.out.println("min ="+mat[a1][b1].price);
            System.out.println("diff="+((mat[a1][b1].max_val)-(mat[a1][b1].price)));
            return mat[a1][b1];
        }
    }


    public static void NumberStategy3(int a, int[]arr) {

        int numFloor = arr.length;
        int num = 1;

        while ((numFloor > (num * (num + 1)) / 2)) {
            num++;
        }

        int drop = num;
        int step = drop - 1;

        while (arr[drop] < a) {
            drop = drop + step;
            step = step - 1;
        }
        System.out.println("the first ball brake in floor : "+drop);
        int floor = (drop - step) + 1;

        while (arr[floor] < a) {
            floor++;
        }
        System.out.println("the secone ball brake in floor : "+floor);
    }





        public static void main(String[]args){
//            int[]arr  = new int[11];
//            for (int i=0; i<arr.length; i++){
//                arr[i]=i;
//            }
////            NumberStategy3(8,arr);
//
//            Node [][] mat = {{new Node(2,3),new Node(9,7),new Node(4,8),new Node(-1,8)},
//                         {new Node(7,1),new Node(5,3),new Node(8,2),new Node(-1,5)},
//                         {new Node(0,7),new Node(4,2),new Node(3,1),new Node(-1,8)},
//                        {new Node(5,-1),new Node(8,-1),new Node(1,-1),new Node(-1,-1)}};
//
//            Node.bestPath(mat, 1, 1);
            String a = "rshilo";
            String b = "shiloeli";
            System.out.println(LCS(a, b));
            deleteAndAdd( a, b);
    }

}
