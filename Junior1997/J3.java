package ca.billweb.Junior1997;

import java.util.Scanner;

public class J3 {
    static int undefeated, oneLoss, eliminated = 0;
    static int roundCount = 1;

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < times; i++) {
            int input = Integer.parseInt(scan.nextLine());
            undefeated = input;

            oneLoss = 0;
            eliminated = 0;
            roundCount = 1;

            System.out.println("Round 0: " + undefeated + " undefeated, 0 one-loss, 0 eliminated");

            while(undefeated + oneLoss > 1){
                calcRound();
            }
            System.out.println("There are " + roundCount + " rounds.\n");
        }
    }

    private static void calcRound(){
        if(undefeated + oneLoss == 2){
            if(undefeated == 1 && oneLoss == 1){
                oneLoss++;
                undefeated--;
            }
            else if(undefeated == 2){
                oneLoss++;
                undefeated--;
            }
            else{
                oneLoss--;
                eliminated++;
                System.out.println("Round " + roundCount + ": 0 undefeated, 1 one-loss, " + eliminated +  " eliminated");
                return;
            }
        }
        else{
            eliminated += oneLoss/2;
            oneLoss -= oneLoss/2;
            oneLoss += undefeated/2;
            undefeated -= undefeated/2;
        }

        System.out.println("Round " + roundCount + ": " + undefeated + " undefeated, " + oneLoss + " one-loss, " + eliminated +  " eliminated");

        roundCount++;
    }
}
