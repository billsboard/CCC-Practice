package ca.billweb.Junior1996;

import java.util.Scanner;

public class J5 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int[] aX, aY;

        int numOfValues = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < numOfValues; i++) {
            /* We shall create 2 arrays (aX and aY) to store the data */
            int length = Integer.parseInt(scan.nextLine());
            aX = new int[length];
            aY = new int[length];
            int maxValue = 0; //MaxValue is used as an upper limit for distance checking

            String[] inputStringData = scan.nextLine().split(" ");
            for (int j = 0; j < inputStringData.length; j++) {
                aX[j] = Integer.parseInt(inputStringData[j]);

                if(aX[j] > maxValue){ maxValue = aX[j]; }
            }

            inputStringData = scan.nextLine().split(" ");
            for (int j = 0; j < inputStringData.length; j++) {
                aY[j] = Integer.parseInt(inputStringData[j]);

                if(aX[j] > maxValue){ maxValue = aX[j]; }
            }

            System.out.println("The maximum distance is " + findMaxDist(aX, aY, maxValue) + ".");
        }
    }

    static int findMaxDist(int[] X, int[] Y, int maxVal){
        int maxDistance = 0;

        for (int i = 0; i <= maxVal; i++) { // The <= is needed to ensure that the maximum value is also calculated
            for (int j = 0; j < X.length; j++) {
                if(X[j] == i){
                    for (int k = 0; k < Y.length; k++) {
                        if(Y[k] == X[j] && (Math.abs(k - j) > maxDistance)){
                            maxDistance = Math.abs(k - j);
                        }
                    }
                }
            }
        }
        return maxDistance;
    }
}
