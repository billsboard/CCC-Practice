package ca.billweb.Junior1996;

import java.util.Scanner;

public class J3 {
    static int totalNumOfOnes;
    static int totalLength;

    static int[] bitPattern = new int[30];

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int[][] inputs = new int[Integer.parseInt(scan.nextLine())][2]; //A 2-dimensional array is required for the 2 pieces of information given

        for (int i = 0; i < inputs.length; i++) {
            String[] values = scan.nextLine().split(" "); //As the inputs come in the form of 'n k' (separated by a space) we must first split the values
            inputs[i][0] = Integer.parseInt(values[0]);
            inputs[i][1] = Integer.parseInt(values[1]);
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("The bit patterns are");
            totalNumOfOnes = inputs[i][1];
            totalLength = inputs[i][0];
            calculateRecursive(inputs[i][0], inputs[i][1]);
        }


    }

    static void calculateRecursive(int length, int numOfOnes){
        if(numOfOnes == 0 && length == 0){ //Pattern is done, all 1's are inserted, print
            for (int i = 0; i < totalLength; i++) {
                System.out.print(bitPattern[i]);
            }
            System.out.println();
        }
        else {
            if(numOfOnes > 0) {
                bitPattern[totalLength - length] = 1;
                calculateRecursive(length - 1, numOfOnes - 1);
            }
            if(length > numOfOnes){
                bitPattern[totalLength - length] = 0;
                calculateRecursive(length - 1, numOfOnes);
            }
        }



    }



}
