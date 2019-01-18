package ca.billweb.Junior1999;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class J2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());

        Pattern slash = Pattern.compile("[^A-Za-z0-9][0-9][0-9]\\/[0-9][0-9]\\/[0-9][0-9][^A-Za-z0-9]");
        Pattern dot = Pattern.compile("[^A-Za-z0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9][^A-Za-z0-9]");
        Pattern word = Pattern.compile("[^A-Za-z0-9](January|Febuary|March|April|May|June|July|August|September|October|November|December) [0-9][0-9], [0-9][0-9][^A-Za-z0-9]");


        for (int i = 0; i < times; i++) {
            int iterator = 0;
            String line = scan.nextLine();
            Matcher regexMatcher = slash.matcher(line);
            while (regexMatcher.find()) {
                int beginIndex = regexMatcher.start(iterator) + 1;
                int endIndex = regexMatcher.end(iterator) - 1;

                String origDate = line.substring(beginIndex, endIndex);
                String fixedDate = alterDate(origDate, 1);

                line = line.replace(origDate, fixedDate);
                iterator++;
            }

            iterator = 0;
            regexMatcher = dot.matcher(line);
            while (regexMatcher.find()) {
                int beginIndex = regexMatcher.start(iterator) + 1;
                int endIndex = regexMatcher.end(iterator) - 1;

                String origDate = line.substring(beginIndex, endIndex);
                String fixedDate = alterDate(origDate, 2);

                line = line.replace(origDate, fixedDate);

            }

            iterator = 0;
            regexMatcher = word.matcher(line);
            while (regexMatcher.find()) {
                int beginIndex = regexMatcher.start(iterator) + 1;
                int endIndex = regexMatcher.end(iterator) - 1;

                String origDate = line.substring(beginIndex, endIndex);
                String fixedDate = alterDate(origDate, 3);


                line = line.replace(origDate, fixedDate);
            }

            System.out.println(line);
        }
    }

    static String alterDate(String text, int dateType){
        if(dateType == 1){
            String[] numbers = text.split("\\/");
            if(Integer.parseInt(numbers[2]) >= 25){
                return numbers[0] + "/" + numbers[1] + "/19" + numbers[2];
            }
            else{
                return numbers[0] + "/" + numbers[1] + "/20" + numbers[2];
            }
        }
        else if(dateType == 2){
            String[] numbers = text.split("\\.");
            if(Integer.parseInt(numbers[2]) >= 25){
                return numbers[0] + "." + numbers[1] + ".19" + numbers[2];
            }
            else{
                return numbers[0] + "." + numbers[1] + ".20" + numbers[2];
            }
        }
        else if(dateType == 3){
            String[] numbers = text.split(",");
            //numbers[1] = numbers[1].substring(1);

            String year = numbers[1];
            year = year.substring(1);

            if(Integer.parseInt(year) >= 25){
                return numbers[0] + ", 19" + year;
            }
            else{
                return numbers[0] + ", 20" + year;
            }
        }

        return "";
    }
}
