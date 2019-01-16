package ca.billweb.Junior1998;

import java.util.ArrayList;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputs = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < inputs; i++) {
            ArrayList<String> inputList = new ArrayList<>();
            String[] aInput = scan.nextLine().replaceAll("-", "_").split(" "); // We replace - with _ as it was causing problems with indexOf()
            int operatorCount = 0;

            for (String s : aInput) {
                inputList.add(s);
                if(s.equals("+") || s.equals("_") || s.equals("X")){
                    operatorCount++;
                }
            }

            for (int j = 0; j < operatorCount; j++) {
                if(inputList.contains("X")){
                    int index = inputList.indexOf("X");
                    inputList.set(index, "(" + inputList.get(index - 1) + " X " + inputList.get(index + 1) + ")");
                    inputList.remove(index + 1);
                    inputList.remove(index - 1);
                }
                else{
                    int minusIndex = inputList.indexOf("_");
                    int plusIndex = inputList.indexOf("+");

                    if(plusIndex == -1 && minusIndex == -1){ break; }
                    else if(minusIndex == -1){ minusIndex = 10000000;}

                    if(plusIndex == -1) { plusIndex = 10000000; }

                    if(plusIndex < minusIndex){
                        inputList.set(plusIndex, "(" + inputList.get(plusIndex - 1) + " + " + inputList.get(plusIndex + 1) + ")");
                        inputList.remove(plusIndex + 1);
                        inputList.remove(plusIndex - 1);
                    }
                    else{
                        inputList.set(minusIndex, "(" + inputList.get(minusIndex - 1) + " - " + inputList.get(minusIndex + 1) + ")");
                        inputList.remove(minusIndex + 1);
                        inputList.remove(minusIndex - 1);
                    }
                }
            }

            /* The following if statement is needed to remove possible extra brackets at the beginning */
            if(inputList.get(0).startsWith("(") && inputList.get(0).substring(inputList.get(0).length() - 1).equals(")")){
                inputList.set(0, inputList.get(0).substring(1, inputList.get(0).length() - 1));
            }


            System.out.println(inputList.get(0));

        }
    }
}
