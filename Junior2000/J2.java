package ca.billweb.Junior2000;

import java.util.Scanner;

public class J2 {
    static String[] rotatableNumbers = {"0", "1", "8"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the lower bound of the interval:");
        int lowerBound = Integer.parseInt(scan.nextLine());
        System.out.println("\nEnter the upper bound of the interval:");
        int upperBound = Integer.parseInt(scan.nextLine());

        int rotatable = 0;

        for (int i = lowerBound; i <= upperBound ; i++) {
            String s = Integer.toString(i);
            rotatable++;

            if(s.length() == 1){
                if(arrayContains(s, rotatableNumbers)){ }
                else{
                    rotatable--;
                }
            }
            else{
                if(s.length() % 2 == 0){
                    String firstHalf = s.substring(0, s.length()/2);
                    String secondHalf = s.substring(s.length()/2);
                    secondHalf = new StringBuilder(secondHalf).reverse().toString();

                    for (int j = 0; j < firstHalf.length(); j++) {
                        if(firstHalf.charAt(j) == secondHalf.charAt(j) &&
                                arrayContains(Character.toString(firstHalf.charAt(j)), rotatableNumbers)){} // Fall through
                        else if (firstHalf.charAt(j) == '6' && secondHalf.charAt(j) == '9') {} //Fall through
                        else if (firstHalf.charAt(j) == '9' && secondHalf.charAt(j) == '6') {} //Fall through
                        else{
                            rotatable--;
                            break;
                        }
                    }
                }
                else {
                    String firstHalf = s.substring(0, s.length()/2);
                    String secondHalf = s.substring(s.length()/2 + 1);
                    secondHalf = new StringBuilder(secondHalf).reverse().toString();

                    if(arrayContains(Character.toString(s.charAt(s.length()/2)), rotatableNumbers)){
                        for (int j = 0; j < firstHalf.length(); j++) {
                            if(firstHalf.charAt(j) == secondHalf.charAt(j) && arrayContains(
                                    Character.toString(firstHalf.charAt(j)), rotatableNumbers)){} // Fall through
                            else if (firstHalf.charAt(j) == '6' && secondHalf.charAt(j) == '9') {} //Fall through
                            else if (firstHalf.charAt(j) == '9' && secondHalf.charAt(j) == '6') {} //Fall through
                            else{
                                rotatable--;
                                break;
                            }
                        }
                    }
                    else { rotatable--; }
                }
            }
        }

        System.out.println("\nThe number of rotatable numbers is:\n" + rotatable);

    }

    static boolean arrayContains(String value, String[] array){
        for (String s : array) {
            if(value.equals(s)){
                return true;
            }
        }

        return false;
    }
}
