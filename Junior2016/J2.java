package ca.billweb.Junior2016;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] split = scan.nextLine().split(" ");

        int[] row1 = new int[4];
        for (int i = 0; i < split.length; i++) {
            row1[i] = Integer.parseInt(split[i]);
        }

        split = scan.nextLine().split(" ");
        int[] row2 = new int[4];
        for (int i = 0; i < split.length; i++) {
            row2[i] = Integer.parseInt(split[i]);
        }

        split = scan.nextLine().split(" ");
        int[] row3 = new int[4];
        for (int i = 0; i < split.length; i++) {
            row3[i] = Integer.parseInt(split[i]);
        }

        split = scan.nextLine().split(" ");
        int[] row4 = new int[4];
        for (int i = 0; i < split.length; i++) {
            row4[i] = Integer.parseInt(split[i]);
        }

        int sum = row1[0] + row2[0] + row3[0] + row4[0];
        for (int i = 0; i < 4; i++) {
            if(row1[i] + row2[i] + row3[i] + row4[i] != sum){
                System.out.println("not magic");
                return;
            }
        }

        if(!((row1[0] + row1[1] + row1[2] + row1[3]) == (row2[0] + row2[1] + row2[2] + row2[3]) &&
                (row3[0] + row3[1] + row3[2] + row3[3]) == (row4[0] + row4[1] + row4[2] + row4[3]) &&
                (row1[0] + row1[1] + row1[2] + row1[3]) == (row4[0] + row4[1] + row4[2] + row4[3]) && (row4[0] + row4[1] + row4[2] + row4[3]) == sum)){
            System.out.println("not magic");
            return;
        }

        System.out.println("magic");
    }
}
