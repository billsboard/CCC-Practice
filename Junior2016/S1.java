package ca.billweb.Junior2016;

import java.util.Arrays;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] a = scan.nextLine().split("");
        String[] b = scan.nextLine().split("");


        int toShift = 0;
        for (int i = 0; i < b.length; i++) {
            if(b[i].equals("*")){
                toShift++;
            }
            else break;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        b = shiftArray(b, toShift);

        for (int i = 0; i < a.length; i++) {
            if(!(a[i].equals(b[i]) || b[i].equals("*"))){
                System.out.println("N");
                return;
            }
        }

        System.out.println("A");
    }

    static String[] shiftArray(String[] array, int toShift){
        if(toShift == 0) { return array; }

        String[] output = new String[array.length];
        for (int i = toShift; i < output.length; i++) {
            output[i - 1] = array[i];
        }

        for (int i = output.length - toShift; i < output.length; i++) {
            output[i] = "*";
        }

        return output;
    }
}
