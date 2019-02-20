package ca.billweb.Junior2016;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int time = Integer.parseInt(scan.nextLine().replace(":", ""));
        int distance = 0;

        while (distance < 120){
            if((time > 700 && time < 1000) || (time > 1500 && time < 1900)){
                distance += 1;
            }
            else{
                distance += 2;
            }

            time += 2;

            if(time % 100 >= 60){
                time += 40;
            }

            if(time >= 2400){
                time -= 2400;
            }
        }

        String result = Integer.toString(time);
        if(result.length() == 3) result = "0" + result;

        System.out.println(result.substring(0, 2) + ":" + result.substring(2, 4));
    }
}
