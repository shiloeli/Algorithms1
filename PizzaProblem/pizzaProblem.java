package folder.PizzaProblem;

public class pizzaProblem {

    public static int pizza(double x, int n){
        int k = (int)x+1;
        int p =n/k;
        int r = n%k;
        int ans = -1;
        if(r!=1){
            double t = (x*p+r-1)/((x+1)*p+r);
            if(t<x/(x+1)){
                ans = 1;
            }else {
                ans = 0;
            }
        }
        return ans;
    }


    public static void main(String[]args){
        System.out.println(pizza(3,3));
    }
}
