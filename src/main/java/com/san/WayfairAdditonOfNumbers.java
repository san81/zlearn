package com.san;


import java.util.ArrayList;
import java.util.List;

public class WayfairAdditonOfNumbers {

  static String addNumbers(String a, String b) {
    //Clear out the formatting so that the addition of numbers get simplified
    a = a.replaceAll(",", "");
    b = b.replaceAll(",", "");
    List<Integer> output = new ArrayList<Integer>();
    String lengtyOne=a;
    String shortOne = b;
    if(a.length()<b.length()){
      lengtyOne = b;
      shortOne = a;
    }


    //Starting with the short one start adding from the end
    int longIdx = lengtyOne.length()-1;
    int carry = 0;
    for(int i=shortOne.length()-1;i>=0;i--){
      int ans = (shortOne.charAt(i) - '0' )+ (lengtyOne.charAt(longIdx) - '0') + carry;
      carry = ans / 10;
      ans = ans % 10;
      output.add(ans);
      longIdx--;
    }

    // Add the remaining from the lengthy one
    while(longIdx>=0){
      int ans = (lengtyOne.charAt(longIdx) - '0') + carry;
      carry = ans / 10;
      ans = ans % 10;
      output.add(ans);
      longIdx--;
    }

    //Make sure not to leave the left over carry
    if(carry!=0){
      output.add(carry);
    }


    // Constructing the final answer
    // and also Adding the format index
    StringBuilder strAns = new StringBuilder();
    int formatIdx = output.size();
    for(int i=output.size()-1; i>=0;i--){
      strAns.append(output.get(i));
      formatIdx--;
      if(formatIdx%3==0 && i!=0){
        strAns.append(",");
      }
    }
    return strAns.toString();
  }

  static void assertAdd(String a, String b, String expectedSum) {
    String sum = addNumbers(a, b);
    if(!expectedSum.equals(sum)) {
      throw new RuntimeException(String.format("Failed this test case. Sum of %s and %s should be %s but we got %s", a, b, expectedSum, sum));
    }else {
      System.out.println("Passed the case %s + %s = %s ".formatted(a, b, sum));
    }
  }
  public static void main(String[] args) {

    // Basic Test
    //     assertAdd("1", "5", "6");
    //     assertAdd("301", "5", "306");

    //     // Carryover test
    //     assertAdd("7", "8", "15");
    //     assertAdd("144", "89", "233");
    //     assertAdd("1", "999", "1000");


    // // Large integer test
    // assertAdd("8944394323791464", "14472334024676221", "23416728348467685");

    // // Larger than long test
    // assertAdd("222232244629420445529739893461909967206666939096499764990979600","1","222232244629420445529739893461909967206666939096499764990979601");

    // Basic comma test
    assertAdd("1,234", "1,234", "2,468");

// Comma with final carry test
    assertAdd("701,408,733", "433,494,437", "1,134,903,170");
    assertAdd("9,234", "1,234", "10,468");

// No commas in the inputs, but with carry that forces a comma
    assertAdd("999", "1", "1,000");

// No leading comma test
    assertAdd("444", "555", "999");
    assertAdd("317,811", "514,229", "832,040");

// Large integer test
    assertAdd("8,944,394,323,791,464", "14,472,334,024,676,221", "23,416,728,348,467,685");
  }
}



/*
Write a function, add,  which adds two large numbers together and returns their sum:

// Returns sum of two numbers
String add(String a, String b)
Inputs to the add function are two numbers, represented as strings

Output of the add function is a single string representing the sum of the inputs

// Asserts 'add' operating correctly
void assertAdd(String a, String b, String expectedSum)

Always positive numbers
No leading zeros
1,234

*/



/*

// Basic Test
assertAdd("1", "5", "6");
assertAdd("301", "5", "306");

// Carryover test
assertAdd("7", "8", "15");
assertAdd("144", "89", "233");
assertAdd("1", "999", "1000");

// Large integer test
assertAdd("8944394323791464", "14472334024676221", "23416728348467685");

// Larger than long test
assertAdd("222232244629420445529739893461909967206666939096499764990979600","1","222232244629420445529739893461909967206666939096499764990979601");

*/

/*

// Basic comma test
assertAdd("1,234", "1,234", "2,468");

// Comma with final carry test
assertAdd("701,408,733", "433,494,437", "1,134,903,170");
assertAdd("9,234", "1,234", "10,468");

// No commas in the inputs, but with carry that forces a comma
assertAdd("999", "1", "1,000");

// No leading comma test
assertAdd("444", "555", "999");
assertAdd("317,811", "514,229", "832,040");

// Large integer test
assertAdd("8,944,394,323,791,464", "14,472,334,024,676,221", "23,416,728,348,467,685");
*/





