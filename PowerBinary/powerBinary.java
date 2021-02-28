package folder.PowerBinary;

public class powerBinary {

//    public static int PowerB(int a, int p, int ans){
//         if(p==0)return ans;
//         if(p%2==1)
//             ans*=a;
//         p=p/2;
//         a=a*a;
//         PowerB(a, p, ans);
//    }

    public static int PowerB2(int x, int n){
        int result = 1;
        while (n!=0){
            if(n%2==1){
                result = result*x;
            }
            x=x*x;
            n=n/2;
        }
        return result;
    }

    public static int PoWerBest(int a, int p, int ans){
        if(p==0)return ans;
        if(p%2==1){
            ans*=a;
        }
        a=a*a;
        p=p/2;
        return PoWerBest(a,p,ans);
    }




}
