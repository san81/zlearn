package com.san.capitalone;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'countCounterfeit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY serialNumber as parameter.
     */

    public static int countCounterfeit(List<String> serialNumber) {
        // Write your code here
        //
        int sum = 0;
        Pattern pattern = Pattern.compile("^([A-Z]{3})([0-9]{4})((10|20|50|100|200|500|1000){1})([A-Z]{1})$");
        System.out.println("Starting the loop"+serialNumber.size());
        for(String snum:serialNumber){
            Matcher matcher = pattern.matcher(snum);
            if(matcher.find() && matcher.groupCount()==5){
                int year = Integer.parseInt(matcher.group(2));
                String first3 = matcher.group(1);
                System.out.println(snum+" "+first3);
                if(Pattern.matches("^((?:([A-Z])(?!.*\\2)){3})$", first3)) {
                    if(1900 <= year && year <=2019) {
                        System.out.println("Adding sum "+matcher.group(4));
                        sum+=Integer.parseInt(matcher.group(4));
                    }
                }
            }
        }
        return sum;
    }

}

public class CounterfeitCurrency {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int serialNumberCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> serialNumber = IntStream.range(0, serialNumberCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .collect(toList());
        //Pattern pattern = Pattern.compile("^((?:([A-Z])(?!.*\\2)){3})([0-9]{4})((10|20|50|100|200|500|1000){1})([A-Z]{1})$");
//        Pattern pattern = Pattern.compile("^([A-Z]{3})([0-9]{4})((10|20|50|100|200|500|1000){1})([A-Z]{1})$");
//        Matcher matcher = pattern.matcher("REE192050E");
//        while (matcher.find()) {
//            System.out.println("I found the text "+matcher.group()+" starting at index "+
//                    matcher.start()+" and ending at index "+matcher.end());
//            System.out.println(matcher.group(4));
//            System.out.println(matcher.groupCount());
//        }
//        System.out.println(Pattern.matches("^(?:([A-Z])(?!.*\\1)){3}[0-9]{4}(10|20|50|100|200|500|1000){1}[A-Z]{1}$", "RED190210A"));//true
        List<String> serialNumber = new ArrayList<>();
        serialNumber.add("6");
        serialNumber.add("QDB2012R20B");
        serialNumber.add("RED190250E");
        serialNumber.add("RFV201111T");
        serialNumber.add("TYU20121000E");
        serialNumber.add("AAA198710B");
        serialNumber.add("AbC200010E");
        int result = Result.countCounterfeit(serialNumber);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
////        bufferedReader.close();
//        bufferedWriter.close();
    }
}
