package com.san.amazon;

public class Strstr {
    public int strStr(String haystack, String needle) {
        if("".equals(needle)){
            return 0;
        }

        if(needle.length()>haystack.length()){
            return -1;
        }

        char[] hchars = haystack.toCharArray();
        char[] nchars = needle.toCharArray();
        for(int i=0;i<hchars.length;i++){
            if(hchars[i]==nchars[0]){
                //continue to check for other chars from here
                int hIdx = i;
                boolean found = true;
                for(int j=0;j<nchars.length && hIdx<hchars.length;j++){
                    if(hchars[hIdx]!=nchars[j]){
                        found=false;
                        break;
                    }
                    hIdx++;
                }
                if(found && hIdx-i==nchars.length){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "", needle = "";
//        String haystack = "", needle = "a";
//        String haystack = "mississippi", needle = "mississippi";
        String haystack= "mississippi",  needle= "issipi";
        System.out.println(new Strstr().strStr(haystack, needle));
    }
}
