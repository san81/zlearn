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



class CustomSortResult {

    /*
     * Complete the 'moves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int moves(List<Integer> arr) {
        // Write your code here
        int evnCnt = 0;
        int evnsBeforeEvenCnt = 0;
        for(int i: arr) {
            if(i%2==0) evnCnt++;
        }
        for(int i=0;i<evnCnt;i++){
            if(arr.get(i)%2==0) evnsBeforeEvenCnt++;
        }
        return evnCnt-evnsBeforeEvenCnt;
    }

}

public class CustomSortedArray {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = Arrays.asList(new Integer[]{6, 3, 4, 5});
        arr = Arrays.asList(new Integer[]{5, 8, 5, 11, 4, 6});
        int result = CustomSortResult.moves(arr);
        System.out.println(result);

    }
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//                .map(String::trim)
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        int result = Result.moves(arr);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
}
