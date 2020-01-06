package Junior2019;

import java.util.Scanner;

public class J5 {


    static String[][] rules = new String[3][2];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        rules[0] = input.nextLine().split(" ");
        rules[1] = input.nextLine().split(" ");
        rules[2] = input.nextLine().split(" ");




        String[] inputLine = input.nextLine().split(" ");

        int moves  = Integer.parseInt(inputLine[0]);
        String start = inputLine[1];
        String end = inputLine[2];

        System.out.println(calculate(start, end, moves));

    }

    public static String calculate(String start, String end, int remainingMoves){
        int iValue = 0;
        int jValue = 0;

        String resultant = "";
        String result = "";

        String step = "";
        if(start.equals(end) && remainingMoves == 0){
            return "";
        }
        else if(remainingMoves == 0 || (start.equals(end) && remainingMoves != 0)){
            return "false";
        }

        for (int i = 0; i < 3; i++) {
            iValue = i;

            int lastPossibleIndex = rules[i][0].length();

            String currentRule = rules[i][0];
            String replacementRule = rules[i][1];

            int lengthOfRule = rules[i][0].length();


            for (int j = 0; j <= start.length() - lastPossibleIndex; j++) {
                jValue = j;
                String currentSubstring = start.substring(j, j + lengthOfRule);
                if(currentSubstring.equals(currentRule)){
                    resultant = start.substring(0, j) + replacementRule + start.substring(j + lengthOfRule);


                    result = calculate(resultant, end, remainingMoves - 1);
                    if(!result.contains("false")){
                        return step + (i+1) + " " + (j+1) + " " + resultant + "\n" + result;
                    }
                }
            }
        }
        return "false";
    }


}
