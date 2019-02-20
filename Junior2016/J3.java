package ca.billweb.Junior2016;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int maxLength = 0;

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                if(checkPalindrome(input.substring(i, j))){
                    if(Math.abs(j - i) > maxLength){
                        maxLength = Math.abs(j - i);
                    }
                }
            }
        }

        System.out.println(maxLength);
    }

    static boolean checkPalindrome(String s){
        StringBuilder sB = new StringBuilder(s);
        return (sB.toString().equals(sB.reverse().toString()));
    }
}
