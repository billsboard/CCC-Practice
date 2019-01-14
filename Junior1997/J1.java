package ca.billweb.Junior1997;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < Integer.parseInt(scan.nextLine()); i++) {
            String[] subjects = new String[Integer.parseInt(scan.nextLine())];
            String[] verbs = new String[Integer.parseInt(scan.nextLine())];
            String[] objects = new String[Integer.parseInt(scan.nextLine())];

            /* Register all subjects */
            for (int j = 0; j < subjects.length; j++) {
                subjects[j] = scan.nextLine();
            }
            /* Register all verbs */
            for (int j = 0; j < verbs.length; j++) {
                verbs[j] = scan.nextLine();
            }
            /* Register all objects */
            for (int j = 0; j < objects.length; j++) {
                objects[j] = scan.nextLine();
            }

            findCombinations(subjects, verbs, objects);

        }
    }

    static void findCombinations(String[] subjects, String[] verbs, String[] objects) {
        for (int i = 0; i < subjects.length; i++) {
            for (int j = 0; j < verbs.length; j++) {
                for (int k = 0; k < objects.length; k++) {
                    System.out.println(subjects[i] + " " + verbs[j] + " " + objects[k] + ".");
                }
            }
        }
    }
}
