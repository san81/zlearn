package com.san.rh;

public class StringConcatOptimzation {

    /**
     * Given there are 50000 items in the input String array, the function must
     * add all array items to outputString and then return the outputString. if
     * forceUpperCase is true, the return string must be upper case.
     */
    public String addStringItems(String[] items, boolean forceUpperCase) {
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            returnValue.append(items[i]);
        }
        String returnStr=returnValue.toString();
        return forceUpperCase ? returnStr.toUpperCase() : returnStr;
    }
}
