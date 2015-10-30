/*
package com.san.learn.logical;

public class WordAnagramsV2 {

    public boolean isAnagramV2(String source, String target) {
        
        int charCounts = new int[26];
               int charCount=0;
        Char[] sourceChars = source.getChars();
        for(char c:sourceChars){
            if(!isEscapeChar(c)){
                charCounts[c-'A']++;
                charCount++;
    }
            
        }
        
    //Target string length should be at least  count of non zeros entries in charCount array
         if(target.length<charCount){
            return false;
         }

           Char[] targetChars = target.getChars();
        for(char c:targetChars) {
            if(charCounts[c-'A']==0){
                return false;
    }
            charCounts[c-'A']--;
        }

       for(int i=0;i<26;i++){
        if(charCounts[i]!=0){
            return false;
        }
       }
     return true;
        
    }


    public boolean isAnagram(String source, String target) {
     boolean hashMatch = getMyHash(source)==getMyHash(target);
     if(!hashMatch){
        return false;
     }

    String sourceUppper = source.toUpperCase();
    String targetUpper = target.toUpperCase();
    char[] charsOfSource=sourceUppper.toCharArray();
    for(char c:charsOfSource){
        if( targetUpper.indexOf(c)==-1 && !isEscapeChar(c)){
            return false;
    }
    }

    return true;

    }

    static char escapeChar[] = new char[]{',',' ','.','!','?','$'};
    public int getMyHash(String str){
      int hash=0;
        for(int i=0;i<str.length();i++){
            char currentChar = str.charAt(i);
            if(!isEscapeChar(currentChar)){
                hash+=currentChar;
            }
    }
    return hash;
    }

    public boolean isEscapeChar(char currentChar){
        return (currentChar>=96 && currentChar<=96+26) ||
    (currentChar>='A' && currentCar<='Z');
    }


}
*/