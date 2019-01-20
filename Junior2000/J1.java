package ca.billweb.Junior2000;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter day:");
        int day = Integer.parseInt(scan.nextLine());
        System.out.println("\nEnter number of days in month:");
        int daysInMonth = Integer.parseInt(scan.nextLine());

        int printedDays = 0;

        System.out.println("\nSun Mon Tue Wed Thr Fri Sat");

        for (int i = 0; i < day - 1; i++) {
            System.out.print("    ");
            printedDays++;
        }

        for (int i = 1; i <= daysInMonth; i++) {
            if(printedDays >= 6){
                System.out.println(padNumber(Integer.toString(i)));
                printedDays = 0;
            }
            else{
                System.out.print(padNumber(Integer.toString(i)) + " ");
                printedDays++;
            }
        }


    }

    static String padNumber(String input){
        int paddingRequired = 3 - input.length();
        String padding = "";
        for (int i = 0; i < paddingRequired; i++) {
            padding += " ";
        }

        return padding + input;
    }
}
