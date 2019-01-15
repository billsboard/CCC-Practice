package ca.billweb.Junior1998;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < lines; i++) {
            String[] words = scan.nextLine().split(" ");
            String output = "";

            for (String s: words) {
                if(s.length() == 4){
                    output += "**** ";
                }
                else{
                    output += s + " ";
                }
            }

            System.out.println(output.trim());
        }
    }
}
