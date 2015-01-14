
package com.san.learn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/**
 * Levenshtein distance is a string metric for measuring the difference 
 * between two sequences. Informally, the Levenshtein distance 
 * between two words is the minimum number of 
 * single-character edits (i.e. insertions, deletions or substitutions) 
 * required to change one word into the other. 
 * 
 * It is named after Vladimir Levenshtein, who considered this distance in 1965.[1]


 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 12, 2015
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        
        String s1 = "kittn";
        List<String> words = readWords();
        for(String word:words){
            if(word.length()>s1.length()+2 || word.length()<s1.length()){
                continue;
            }else{
                int distance=getLevenshteinDistance(s1, word);
                if(distance<=3){
                    System.out.println("distnace::"+distance+" :: "+word);
                }
            }
        }
        //System.out.println(" Distance "+getLevenshteinDistance(s1, s2));
       
    }
    
    private static List<String> readWords() {
        List<String> words = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("words.txt")));
            String word = null;
            while ((word = br.readLine()) != null) {
                if(word.length()!=4) {
                    continue;
                }
                words.add(word.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    private static int getLevenshteinDistance(String s1, String s2){
        int data[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            data[i]=new int[s2.length()+1];
        }

        for(int i=1;i<s1.length()+1;i++){
            data[i][0]=i;
        }
        
        for(int j=1;j<s2.length()+1;j++){
            data[0][j]=j;
        }
        
        for(int j=1;j<s2.length()+1;j++){
            for(int i=1;i<s1.length()+1;i++){
                
               int qty=s1.charAt(i-1)==s2.charAt(j-1)?0:1;
               int curMin=minOf(data[i-1][j-1], data[i][j-1], data[i-1][j]);
               data[i][j]=qty+curMin;
            }
            //System.out.println("\n");
        }
        //printMatrix(data, " "+s1, " "+s2);
        return data[s1.length()][s2.length()];
    }
    
    public static void printMatrix(int[][] matrix, String s1, String s2){
        StringBuffer sb = new StringBuffer();
        sb.append("     ");
        for(int i=0;i<s2.length();i++){
            sb.append(String.format("%4s",s2.charAt(i)));
        }
        for(int i=0;i<s1.length();i++){
            sb.append("\n").append(String.format("%4s",s1.charAt(i)));
            for(int j=0;j<s2.length();j++){
                sb.append(String.format("%4s", matrix[i][j]));
            }
        }
        System.out.println(sb.toString());
    }
    
    private static int minOf(int a, int b, int c){
        if(a<b && a<c){
            return a;
        }else if(b<a && b<c) {
            return b;
        }else {
            return c;
        }
    }
}
