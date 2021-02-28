package folder.BallGlassProblem;

public class ballGlassProblem {

    public static void useFloorPotential(int a, int[] arr) {
        int num = 1;
        int numFloors = arr.length;

        while (numFloors >(num * (num + 1)) / 2) {
            num++;
        }
        System.out.println(num);
        int jump = num;
        int step = num - 1;

        while (arr[jump] < a) {
            jump = jump + step;
            step = step - 1;
        }
        System.out.println("the first ball brake in floor : "+jump);
        int floor = (jump - step) + 1;

        while (arr[floor] < a) {
            floor++;
        }
        System.out.println("the secone ball brake in floor : "+floor);
    }

    public static void main(String[]args){
        int[]arr  = new int[11];
        for (int i=0; i<arr.length; i++){
            arr[i]=i;
        }
        useFloorPotential(8,arr);

    }
}