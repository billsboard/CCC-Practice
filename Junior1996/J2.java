package ca.billweb.Junior1996;

import java.math.BigInteger;
import java.util.Scanner;

public class J2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] inputs = new String[Integer.parseInt(scan.nextLine())]; //String array is necessary since the numbers would overflow even a variable of type long

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = scan.nextLine();
        }

        for (int i = 0; i < inputs.length; i++) {
            if(checkDivisibility(inputs[i])){
                System.out.println(inputs[i] + " is divisible by 11.");
            }
            else{
                System.out.println(inputs[i] + " is not divisible by 11.");
            }
        }

    }

    public static boolean checkDivisibility(String strNumber){
        strNumber = new BigInteger(strNumber).toString(); //With this conversion and reconversion, any leading zeros are stripped from the input

        String lastDigit;
        BigInteger intNumber = null; //To perform math operations on these large numbers, we resort to BigInteger

        System.out.println(strNumber); //The while loop does not print the original iteration of the input

        while (strNumber.length() > 2){
            lastDigit = strNumber.substring(strNumber.length() - 1);
            strNumber = strNumber.substring(0, strNumber.length() - 1);

            /* lastDigit contains the last digit of strNumber, and this final digit is removed from strNumber */

            intNumber = new BigInteger(strNumber);
            intNumber = intNumber.subtract(new BigInteger(lastDigit));


            System.out.println(intNumber.toString());

            strNumber = intNumber.toString(); //intNumber's value is converted back into a String to be processed again
        }

        return intNumber.longValue() % 11 == 0;

    }
}
