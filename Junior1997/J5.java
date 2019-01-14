package ca.billweb.Junior1997;

import java.math.BigInteger;
import java.util.Scanner;

public class J5 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int times = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < times; i++) {
            BigInteger divisor, dividend;
            int divideCounter = 0;
            String sDivisor, sDividend, paddedDivisor, quotient = "";

            sDividend = scan.nextLine();
            sDivisor = scan.nextLine();


            divisor = new BigInteger(sDivisor);
            dividend = new BigInteger(sDividend);

            if(dividend.compareTo(divisor) == -1) {
                System.out.println("0");
                System.out.println(sDividend);
            }
            else {
                paddedDivisor = new String(sDivisor);
                while(paddedDivisor.length() < sDividend.length()){
                    paddedDivisor += "0";
                }

                while (!sDivisor.equals(paddedDivisor)) {
                    divisor = new BigInteger(paddedDivisor);
                    while (divisor.compareTo(dividend) < 1) {
                        dividend = dividend.subtract(divisor);
                        divideCounter++;
                    }

                    if(divideCounter > 0 || !quotient.isEmpty()){
                        quotient += Integer.toString(divideCounter);
                    }
                    divideCounter = 0;
                    paddedDivisor = paddedDivisor.substring(0, paddedDivisor.length() - 1);
                }


                divisor = new BigInteger(paddedDivisor);
                while(divisor.compareTo(dividend) < 1){
                    dividend = dividend.subtract(divisor);
                    divideCounter++;
                }

                if(divideCounter > 0 || !quotient.isEmpty()){
                    quotient += Integer.toString(divideCounter);
                }


                System.out.println(quotient);
                System.out.println(dividend + "\n");

            }

        }
    }
}
