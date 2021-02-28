package folder.Dual3D;

public class dual3d {


    public static void dual3d(int num) {

        double pc = 0.8;
        double pd = 0.5;
        int countC = 0;
        int countD = 0;
        int countB = 0;
        double cChance = 0;
        double dChance = 0;
        int B = 1;
        int C = 2;
        int D = 3;
        boolean flag = true;

        for (int i = 0; i <= num; i++) {
            int[] q = getQ();
            int first = q[1];
            switch (first) {

                case 1:
                    dChance = Math.random();
                    if (dChance < pd) countD++;
                    else countB++;
                    break;

                case 2:
                    cChance = Math.random();
                    if (cChance < pc) {
                        flag = true;
                        while (flag) {
                            dChance = Math.random();
                            if (dChance < pd) {
                                countD++;
                                flag = false;
                            } else {
                                cChance = Math.random();
                                if (cChance < pc) {
                                    countC++;
                                    flag = false;
                                }
                            }
                        }
                    } else if (q[2] == B) {
                        dChance = Math.random();
                        if (dChance < pd) {
                            countD++;
                        } else
                            countB++;
                    } else if (q[2] == D) {
                        dChance = Math.random();
                        if (dChance < pd) {
                            countD++;
                        } else {
                            countB++;
                        }
                    }
                    break;

                case 3:
                    if (q[2] == B) {
                        dChance = Math.random();
                        if (dChance < pd) {
                            countD++;
                        } else
                            countB++;
                    } else {
                        if (q[2] == C) {
                            cChance = Math.random();
                            if (cChance < pc) {
                                flag = true;

                                while (flag) {
                                    dChance = Math.random();
                                    if (dChance < pd) {
                                        countD++;
                                        flag = false;
                                    } else {
                                        cChance = Math.random();
                                        if (cChance < pc) {
                                            countC++;
                                            flag = false;
                                        }
                                    }
                                }
                            } else {
                                dChance = Math.random();
                                if (dChance < pd) {
                                    countD++;
                                } else countB++;
                            }
                        }
                    }
                    break;
            }
        }
        double probB = (double) countB / num;
        double probC = (double) countC / num;
        double probD = (double) countD / num;

        System.out.println("B=" + probB);
        System.out.println("C=" + probC);
        System.out.println("D=" + probD);
        double sum = probD + probB + probC;
        System.out.println("SUM=" + sum);


    }

    public static int[] getQ() {
        int[] q = {0, 1, 2, 3};

        for (int i = 1; i < q.length; i++) {
            int j = ((int) (Math.random() * 3)) + 1;
            int t = q[i];
            q[j] = q[i];
            q[i] = t;
        }
        return q;
    }

    public static void main(String[]args){
            dual3d(10000);
        }
}



