package ca.billweb.Junior2000;

import java.util.Scanner;

public class S1J3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many quarters does Martha have in the jar?");
        int quarters = Integer.parseInt(scan.nextLine());
        System.out.println("\nHow many times has the first machine been played since paying out?");
        int firstTimes = Integer.parseInt(scan.nextLine());
        System.out.println("\nHow many times has the second machine been played since paying out?");
        int secondTimes = Integer.parseInt(scan.nextLine());
        System.out.println("\nHow many times has the third machine been played since paying out?");
        int thirdTimes = Integer.parseInt(scan.nextLine());

        int roundsPlayed = 0;

        while(quarters > 0){

            if(firstTimes == 35){
                quarters += 30;
                firstTimes = 0;
            }
            quarters--;
            roundsPlayed++;

            if(quarters <= 0){ break; }
            else if(secondTimes == 100 && quarters > 0){
                quarters += 60;
                secondTimes = 0;
            }
            quarters--;
            roundsPlayed++;

            if(quarters <= 0){ break; }
            else if(thirdTimes == 10 && quarters > 0){
                quarters += 9;
                thirdTimes = 0;
            }
            quarters--;
            roundsPlayed++;


        }

        System.out.println("\nMartha plays " + roundsPlayed + " times before going broke.");
    }
}
