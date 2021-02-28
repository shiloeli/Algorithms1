package folder.MaxValue;

public class InductionAndRecursion {

    public static int factorial(int n){
        int f = 1;
        for (int i=1; i<=n; i++){
            f = f*i;
        }
        return f;
    }
    public static int fibonacci(int n){
        int a = 1;
        int b = 1;
        int f = 0;
        for (int i=0; i<n-2; i++){
            f=a+b;
            a=b;
            b=f;
        }
        return f;
    }




    public static void main(String[]args){
        System.out.println(factorial(4));
        System.out.println(fibonacci(7));

    }
}
