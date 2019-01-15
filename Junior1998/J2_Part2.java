package ca.billweb.Junior1998;

public class J2_Part2 {
    public static void main(String[] args) {
        for (int i = 100; i <= 999; i++) {
            if(cubeSum(i) == i){
                System.out.println(i);
            }
        }
    }

    static int cubeSum(int number){
        String[] sDigits = Integer.toString(number).split("");
        int sum = 0;

        for (String s: sDigits) {
            sum += Math.pow(Integer.parseInt(s), 3);
        }

        return sum;
    }
}
