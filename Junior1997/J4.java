package ca.billweb.Junior1997;

import java.util.ArrayList;
import java.util.Scanner;

public class J4 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < times; i++) {
            String line = scan.nextLine();
            ArrayList<String> encoded = new ArrayList<>();

            while (!line.isEmpty()){
                String[] words = line.split(" ");
                for (int j = 0; j < words.length; j++) {
                    String s = words[j];
                    if(!encoded.contains(s)){
                        encoded.add(s);

                        /* This prevents an extra space from being added at the end of the line */
                        if(words.length - 1 == j){
                            System.out.println(s);
                        }
                        else{
                            System.out.print(s + " ");
                        }
                    }
                    else {
                        if(words.length - 1 == j){
                            System.out.println((encoded.indexOf(s) + 1));
                        }
                        else{
                            System.out.print((encoded.indexOf(s) + 1) + " ");
                        }
                    }
                }


                line = scan.nextLine();
            }

            System.out.println();
        }
    }
}
