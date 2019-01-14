package ca.billweb.Junior1996;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] inputs = new int[Integer.parseInt(input.nextLine())];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = Integer.parseInt(input.nextLine());
        } //The inputs are all first stored in an array, as we must wait for all of the inputs to be entered first

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(formatOutput(inputs[i], calculateSum(inputs[i])));
        } //The previously stored inputs are now calculated and formatted as per the guidelines
    }

    static String formatOutput(int number, int factorSum){
        if(factorSum < number){
            return number + " is a deficient number.";
        }
        else if(factorSum > number){
            return number + " is an abundant number.";
        }

        return number + " is a perfect number.";
    }

    static int calculateSum(int number) {
        int sum = 1; //1 is always a factor
        for (int i = 2; i < number/2 + 1; i++) {
            if(number % i == 0){
                sum += i;
            }
        }
        return sum;
    }
}
