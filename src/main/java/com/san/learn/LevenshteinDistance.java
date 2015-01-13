
package com.san.learn;

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
        
        String s1 = "kitten";
        String s2 = "sitting";
        
        int data[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            data[i]=new int[s2.length()+1];
        }

        
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                
               int qty=s1.charAt(i-1)==s2.charAt(j-1)?0:1;
               int curMin=minOf(data[i-1][j-1], data[i][j-1], data[i-1][j]);
               data[i][j]=qty+curMin;
            }
            System.out.println("\n");
        }
        
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                
                System.out.print(data[i][j]+", ");
            }
            System.out.println("\n");
        }
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
