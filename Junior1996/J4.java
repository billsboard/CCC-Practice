package ca.billweb.Junior1996;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] inputs = new String[Integer.parseInt(scan.nextLine())];

        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = scan.nextLine();
        }

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(inputs[i]);

            int n1, n2, sum;
            String[] splitInput = inputs[i].replace("=", "").split("\\+");

            n1 = parseFromNumeral(splitInput[0]);
            n2 = parseFromNumeral(splitInput[1]);

            sum = n1 + n2;

            if(sum > 1000){
                System.out.println("CONCORDIA CUM VERITATE");
            }
            else{
                System.out.println(convertToNumeral(sum));
            }

        }
    }

    static String convertToNumeral(int number){
        String numeral = "";

        /* We put the corresponding numerals in from largest to smallest */
        while (number >= 1000){
            numeral += "M";
            number -= 1000;
        }
        while (number >= 500){
            numeral += "D";
            number -= 500;
        }
        while (number >= 100){
            numeral += "C";
            number -= 100;
        }
        while (number >= 50){
            numeral += "L";
            number -= 50;
        }
        while (number >= 10){
            numeral += "X";
            number -= 10;
        }
        while (number >= 5){
            numeral += "V";
            number -= 5;
        }
        while (number >= 1){
            numeral += "I";
            number -= 1;
        }

        /* We now replace sequences of more than 3 in a row and replace them with "one before digit"
         * Note the MMMM and DDDD sequences are not needed as the sum must be less than 1000
         */
        if(numeral.contains("CCCC")){
            numeral = numeral.replaceFirst("CCCC", "CD");
        }
        if(numeral.contains("LXXXX")){
            numeral = numeral.replaceFirst("LXXXX", "XC");
        }
        if(numeral.contains("XXXX")){
            numeral = numeral.replaceFirst("XXXX", "XL");
        }
        if(numeral.contains("VIIII")){
            numeral = numeral.replaceFirst("VIIII", "IX");
        }
        if(numeral.contains("IIII")){
            numeral = numeral.replaceFirst("IIII", "IV");
        }

        return numeral;
    }

    static int parseFromNumeral(String rNumeral){
        int totalSum = 0;

        /*Remove all the "special" sequences first*/

        if(rNumeral.contains("CM")){
            totalSum += 900;
            rNumeral = rNumeral.replace("CM", "");
        }
        if(rNumeral.contains("CD")){
            totalSum += 400;
            rNumeral = rNumeral.replace("CD", "");
        }
        if(rNumeral.contains("XC")){
            totalSum += 90;
            rNumeral = rNumeral.replace("XC", "");
        }
        if(rNumeral.contains("XL")){
            totalSum += 40;
            rNumeral = rNumeral.replace("XL", "");
        }
        if(rNumeral.contains("IX")){
            totalSum += 9;
            rNumeral = rNumeral.replace("IX", "");
        }
        if(rNumeral.contains("IV")){
            totalSum += 4;
            rNumeral = rNumeral.replace("IV", "");
        }

        /* Now, all the special sequences have been removed
         * We can begin to iterate through the remaining values
         */

        for (int i = 0; i < rNumeral.length(); i++) {
            char cValue = rNumeral.charAt(i);
            if(cValue == 'M'){
                totalSum += 1000;
            }
            else if(cValue == 'D'){
                totalSum += 500;
            }
            else if(cValue == 'C'){
                totalSum += 100;
            }
            else if(cValue == 'L'){
                totalSum += 50;
            }
            else if(cValue == 'X'){
                totalSum += 10;
            }
            else if(cValue == 'V'){
                totalSum += 5;
            }
            else if(cValue == 'I'){
                totalSum += 1;
            }
        }

        return totalSum;
    }
}
