package ca.billweb.Junior1997;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J2 {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int times = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < times; i++) {
            int input = Integer.parseInt(scan.nextLine());
            System.out.println(input + (checkForNasty(factor(input)) ? " is nasty" : " is not nasty"));
        }
    }

    static int[] factor(int number){
        int numOfFactors = 0;
        int[] factorArray = new int[number/2 + 1];
        int j = 0;

        for (int i = 1; i < number/2 + 1; i++) {
            if(number % i == 0){
                factorArray[j] = i;
                j++;
                numOfFactors++;
            }
        }

        factorArray[j] = number;
        numOfFactors++;

        return Arrays.copyOfRange(factorArray, 0, numOfFactors);
    }

    static boolean checkForNasty(int[] factors){
        /* Find difference and sum of factor pairs */
        ArrayList<Integer> sums = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();

        for (int i = 0; i < factors.length / 2; i++) {
            sums.add(factors[i] + factors[factors.length - 1 - i]);
            diff.add(factors[factors.length - 1 - i] - factors[i]);
        }

        for (Integer i : sums) {
            if(diff.contains(i.intValue())){
                return true;
            }
        }
        return false;
    }
}
