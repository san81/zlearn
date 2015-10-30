package com.san.rh;

import java.util.Vector;

public class StringConcatOptimzationWithCollection {

    /**
     * Given there are 50000 items in the input String array, the function must
     * add all array items to outputString and then return the outputString. if
     * forceUpperCase is true, the return string must be upper case.
     */
    public String addStringItems(String[] items, boolean forceUpperCase) {
        
        Vector<String> itsVector = new Vector<String>();
        for(int i=0;i<items.length;i++){
            itsVector.add(items[i]);
        }
        
        StringBuffer returnValue = new StringBuffer();
        for (String str:itsVector) {
            returnValue.append(str);
        }
        String returnStr=returnValue.toString();
        return forceUpperCase ? returnStr.toUpperCase() : returnStr;
    }
}
