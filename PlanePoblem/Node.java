package folder.PlanePoblem;

public class Node {
    int x, y, price, nPaths,count,Turn;
    String[]arr;


    public Node(int x, int y){
        this.count = 1;
        this.x = x;
        this.y = y;
        this.price = 0;
        this.arr = new String[10];
        this.nPaths = 0;
        this.Turn = 0;


    }

    public static Node[][] buildMatrix (){

//        Node [][] mat = new Node[4][4];

//        Node [][] mat = {{new Node(1,1),new Node(1,1)},
//                         {new Node(1,1),new Node(1,1)}};


        Node[][]mat =new Node [3][3];
        mat[0][0]= new Node(3,2);
        mat[0][1]= new Node(1,1);
        mat[0][2]= new Node(0,2);

        mat[1][0] = new Node(1,1);
        mat[1][1] = new Node(1,1);
        mat[1][2] = new Node(0,1);

        mat[2][0] = new Node(1,0);
        mat[2][1] = new Node(1,0);
        mat[2][2] = new Node(0,0);

//      n

            mat[0][0].price = 0;

            for (int j = 1; j<mat[0].length; j++) {
                mat[0][j].price = mat[0][j-1].price + mat[0][j-1].x;
            }

            for (int i = 1; i<mat.length; i++) {
                mat[i][0].price = mat[i-1][0].price + mat[i-1][0].y;
            }

            for (int i = 1; i<mat.length; i++) {
                for (int j = 1; j<mat[0].length; j++) {
                    mat[i][j].price = Math.min(mat[i][j-1].price + mat[i][j-1].x,
                            mat[i-1][j].price + mat[i-1][j].y);
                }
            }
        return mat;
    }
}
