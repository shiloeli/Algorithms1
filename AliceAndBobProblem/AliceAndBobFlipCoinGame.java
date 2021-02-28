package folder.AliceAndBobProblem;

public class AliceAndBobFlipCoinGame {

    public static int CoinFlips(){
        long result = 0;
        result = Math.round(Math.random());
        return (int)result;
    }

    public static int AliceGame(){
        return CoinFlips();
    }

    public static int BobGame(){
        return CoinFlips();
    }

    public static boolean strategy1(){
        boolean result = false;
       int ansAlice = AliceGame();
       int ansBob = BobGame();
       if(ansAlice == ansBob) result = true;
       return result;
    }

    public static boolean strategy2(){
        boolean result = false;
        int ansAlice = AliceGame();
        int ansBob = BobGame();
        if (ansBob == 1||ansAlice == 1)result = true;
        return result;
    }

    public static boolean strategy3(){
        boolean ans = false;
        int ansAlice = AliceGame();
        int ansBob = BobGame();
        if(ansAlice==ansBob)ans = true;
        return ans;
    }

    public static boolean strategy4(){
        boolean ans = false;
        int ansAlice = AliceGame();
        int ansBob  = BobGame();
        if(ansBob == ansAlice || ansAlice == 1-ansBob) ans = true;
        return ans;
    }


    public static void main(String[] args) {

        int count = 10000000;
        int strategy1 = 0;
        int strategy2 = 0;
//        int strategy2A = 0;
        int strategy3 = 0;
        int strategy4 = 0;
        boolean result1 = false;
        boolean result2 = false;
//        boolean result2A = false;
        boolean result3 = false;
        boolean result4 = false;

        for (int i = 0; i < count; i++){
            result1 = strategy1();
            if (result1 == true)
                strategy1++;
            result2 = strategy2();
            if (result2 == true)
            strategy2++;
//            result2A = GameStrategy2A();
//            if (result2A == true)
//                GameStrategy2A++;
            result3 = strategy3();
            if (result3 == true)
                strategy3++;
            result4 = strategy4();
            if (result4 == true)
                strategy4++;
        }
        System.out.println("Alice & Bob game : Strategy1 probability = " + (double)strategy1/(double)count);
                System.out.println("Alice & Bob game : Strategy2 probability = " + (double)strategy2/(double)count);
//                        System.out.println("Alice & Bob game : Strategy2A probability = " + (double)strategy2A/(double)count);
                                System.out.println("Alice & Bob game : Strategy3 probability = " + (double)strategy3/(double)count);
                                        System.out.println("Alice & Bob game : Strategy4 probability = " + (double)strategy4/(double)count);

    }
}
