package ca.billweb.Junior2016;

import java.util.Arrays;
import java.util.Scanner;

public class J5 {
    /* This is the same problem as S2 */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int qType = Integer.parseInt(scan.nextLine());

        int[] dSpeed, pSpeed;

        if(qType == 1){
            dSpeed = new int[Integer.parseInt(scan.nextLine())];
            pSpeed = new int[dSpeed.length];

            String[] sA = scan.nextLine().split(" ");
            for (int i = 0; i < dSpeed.length; i++) {
                dSpeed[i] = Integer.parseInt(sA[i]);
            }

            sA = scan.nextLine().split(" ");
            for (int i = 0; i < pSpeed.length; i++) {
                pSpeed[i] = Integer.parseInt(sA[i]);
            }

            Arrays.sort(dSpeed);
            Arrays.sort(pSpeed);

            int sum = 0;

            for (int i = 0; i < dSpeed.length; i++) {
                sum += Math.max(dSpeed[i], pSpeed[i]);
            }

            System.out.println(sum);
        }
        else if(qType == 2){
            dSpeed = new int[Integer.parseInt(scan.nextLine())];
            pSpeed = new int[dSpeed.length];

            String[] sA = scan.nextLine().split(" ");
            for (int i = 0; i < dSpeed.length; i++) {
                dSpeed[i] = Integer.parseInt(sA[i]);
            }

            sA = scan.nextLine().split(" ");
            for (int i = 0; i < pSpeed.length; i++) {
                pSpeed[i] = Integer.parseInt(sA[i]);
            }

            Arrays.sort(dSpeed);
            Arrays.sort(pSpeed);

            int sum = 0;

            for (int i = 0; i < dSpeed.length; i++) {
                sum += Math.max(dSpeed[i], pSpeed[dSpeed.length - 1 - i]);
            }

            System.out.println(sum);
        }
    }
}
