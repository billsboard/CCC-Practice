package ca.billweb.Junior2016;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = 0;

        for (int i = 0; i < 6; i++) {
            String s = scan.nextLine();
            if(s.equals("W")) count++;
        }

        if(count >= 5){ System.out.println(3); }
        else if(count >= 3) { System.out.println(2); }
        else if(count >= 1) { System.out.println(1); }
        else { System.out.println(-1); }
    }
}
