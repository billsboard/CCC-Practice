package ca.billweb.Junior1999;

import java.util.HashMap;
import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        /* This HashSet contains the high cards we check against */
        HashMap<String, Integer> highCards = new HashMap<>();
        highCards.put("jack", 1);
        highCards.put("queen", 2);
        highCards.put("king", 3);
        highCards.put("ace", 4);

        /* This array contains the cards */
        String cards[] = new String[52];

        for (int i = 0; i < 52; i++) {
            cards[i] = scan.nextLine();
        }


        int playerA = 0;
        int playerB = 0;

        boolean playerATurn = true;
        boolean countFailed = false;

        for (int j = 0; j < 52; j++) {
            String card = cards[j];

            if(highCards.containsKey(card) && j + highCards.get(card) < 52 ){
                for (int i = 0; i < highCards.get(card); i++) {
                    if(highCards.containsKey(cards[j + i + 1])){
                        countFailed = true;
                        break;
                    }
                }

                if(countFailed){} //Fall through
                else if(playerATurn){
                    playerA += highCards.get(card);
                    System.out.println("Player A scores " + highCards.get(card) + " points()");
                }
                else {
                    playerB += highCards.get(card);
                    System.out.println("Player B scores " + highCards.get(card) + " points()");
                }

                countFailed = false;
            }


            playerATurn = !playerATurn;
        }


        System.out.println("Player A has " + playerA + " points");
        System.out.println("Player B has " + playerB + " points");
    }
}
