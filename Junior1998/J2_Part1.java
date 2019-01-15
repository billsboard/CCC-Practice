package ca.billweb.Junior1998;

import java.util.Scanner;

public class J2_Part1 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 9999; i++) {
            if(factorSum(i) == i){
                System.out.println(i);
            }
        }
    }

    static int factorSum(int number){
        /* Calculates the sum of the proper factors of a number */
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) { // <= is necessary since number/2 is a factor
            if(number % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
