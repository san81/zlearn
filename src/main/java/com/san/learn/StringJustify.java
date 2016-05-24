package com.san.learn;

/**
 * Created by santhoshgandhe on 5/24/16.
 */
// ["This", "is", "an", "example", "of", "text", "justification."]   L = 16
//
// [
//   "This    is    an",
//   "example  of text",
//   "justification.  "
// ]

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class StringJustify {

    public static void main(String ar[]){
        String[] inputAr = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int length=16;

        List<String> outputList=justify(inputAr,length);

        System.out.print(outputList);
    }


    public static List<String> justify(String[] inputAr, int length) {
        int curCharCount=0;
        String curStr="";
        int mainArIndex=0;
        List<String> finalResponse = new ArrayList<String>();

        while(mainArIndex<inputAr.length)   {
            int lengthSoFar=0;
            List<Integer> strIndxToInclude = new ArrayList<Integer>();
            while( mainArIndex<inputAr.length && lengthSoFar+ inputAr[mainArIndex].length() <=length){
                lengthSoFar+=inputAr[mainArIndex].length()+1;
                strIndxToInclude.add(mainArIndex++);
            }
            finalResponse.add(adjustSpaces(inputAr, strIndxToInclude, length, lengthSoFar));

        }
        return finalResponse;
    }

    public static String adjustSpaces(String[] inputAr, List<Integer> strIndxToInclude, int length, int lengthSoFar) {
        System.out.println(length +" "+lengthSoFar+ " "+strIndxToInclude.size() );
        int spaceLeft=(length-lengthSoFar);
        int spacesToAdd = spaceLeft>strIndxToInclude.size()? (spaceLeft/strIndxToInclude.size()): spaceLeft;
        String strToReturn="";

        Map<Integer,String> spaceList = new HashMap<Integer,String>();
        while(lengthSoFar<length){
            for(Integer indx:strIndxToInclude) {
                String s=spaceList.get(indx);
                if(s==null){
                    s="";
                }
                s+=getSpaceStringGivenLength(spacesToAdd);
                lengthSoFar+=spacesToAdd;
                spaceList.put(indx,s);
            }
        }

        int counter=0;
        for(Integer indx:strIndxToInclude) {
            String s =spaceList.get(indx);
            if(null==s){
                s=" ";
            }
            if((counter+1)==strIndxToInclude.size()){
                strToReturn+=s+inputAr[indx];
            }else{
                strToReturn+=inputAr[indx]+s;
            }

            counter++;
        }


        spacesToAdd=length-strToReturn.length();
        strToReturn+=getSpaceStringGivenLength(spacesToAdd);
        return strToReturn;
    }

    public static String getSpaceStringGivenLength(int spacesToAdd){
        System.out.println(spacesToAdd);
        String s="";
        for(int i=0;i<spacesToAdd;i++){
            s+=" ";
        }
        return s;
    }

}
