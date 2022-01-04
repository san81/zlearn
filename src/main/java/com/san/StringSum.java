package com.san;

// you can also use imports, for example:
// import java.util.*;

// you can write to stderr for debugging purposes, e.g.
// System.err.println("this is a debug message");

class StringSum {

    public static String add(String a, String b) {
        int alen = a.length();
        int blen = b.length();

        int i=alen-1, j=blen-1;

        StringBuffer result = new StringBuffer();
        int carry = 0;


        while(i>=0 && j>=0) {
            if(a.charAt(i)==',') {
                i--;j--;
                result.append(",");
            }
            int digitSum = (a.charAt(i)-'0') + (b.charAt(j) - '0')+carry;
            if(digitSum>9) {
                carry = digitSum /10;
                digitSum = digitSum - 10;
            }
            else
                carry=0;
            result.append(digitSum);

            i--; j--;
        }

        //if alen is bigger
        if(i>=0) {
            while(i>=0) {
                if(a.charAt(i)==',') {
                    i--;
                    result.append(",");
                }
                int digitSum = (a.charAt(i)-'0') +carry;
                if(digitSum>9) {
                    carry = digitSum /10;
                    digitSum = digitSum - 10;
                }
                else
                    carry=0;
                result.append(digitSum);
                i--;
            }
        }


        // if blen is biger
        if(j>=0) {
            while(j>=0) {
                if(b.charAt(i)==',') {
                    j--;
                    result.append(",");
                }
                int digitSum = (b.charAt(j)-'0') +carry;

                if(digitSum>9) {
                    carry = digitSum /10;
                    digitSum = digitSum - 10;
                }
                else
                    carry=0;
                result.append(digitSum);
                j--;
            }
        }



        if(carry!=0){
            if((result.length()+1)%4==0)
                result.append(",");
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(add("701,408,733","433,494,437"));
        //System.out.println('0'-'0');

        //"8944394323791464", "14472334024676221", "23416728348467685"

        //"1,234", "1,234" = "2,468"
        //"701,408,733", "433,494,437" = "1,134,903,170"
    }
}

