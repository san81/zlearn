package com.san.weekly232;

public class CharDiffByOne {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()==1) return false;
        int firstDiffIdx = -1;
        int diffCount = 0;
        for(int i=0;i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)) {
                diffCount++;
                if(firstDiffIdx==-1){
                    firstDiffIdx = i;
                }else{
                    if(s2.charAt(i)!=s1.charAt(firstDiffIdx)){
                        return false;
                    }
                }
                if(diffCount>2){
                    return false;
                }
            }
        }
        if(diffCount==1) return false;
        return true;
    }

    public static void main(String[] args) {
        String s1 = "faaaaxa";
        String s2 = "xaaaafb";
        s1="kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkyoooooooooooooooooooooooooooooooooooooooooooooooo";
        s2="kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkfoooooooooooooooooooooooooooooooooooooooooooooooo";
        System.out.println(new CharDiffByOne().areAlmostEqual(s1, s2));
    }
}
