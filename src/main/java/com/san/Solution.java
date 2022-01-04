package com.san;

import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> orderedJunctionBoxes(int numberOfBoxes,
            List<String> boxList)
    {

        // WRITE YOUR CODE HERE
        //Findout how many old version boxes are there
        int newBoxCount=0;
        for(String boxId:boxList) {
            if(!isOldVersion(boxId)) {
                newBoxCount++;
            }
        }

        //Old Box index in the array
        int newBoxIndex=newBoxCount-1;
        int oldBoxIndex=0;


        for(int i=0;i<=boxList.size()-1 && oldBoxIndex<boxList.size()-1;i++){
            while(oldBoxIndex<boxList.size() && isOldVersion(boxList.get(oldBoxIndex))){
                oldBoxIndex++;
            }
            while(newBoxIndex+1<boxList.size() && !isOldVersion(boxList.get(newBoxIndex))){
                newBoxIndex++;
            }

            //swap new with old
            String tmp=boxList.get(oldBoxIndex);
            boxList.set(oldBoxIndex,boxList.get(newBoxIndex));
            boxList.set(newBoxIndex,tmp);

        }
        return boxList;
    }

    public static boolean isOldVersion(String boxId) {
        String[] boxIdParts=boxId.split(" ");
        if(boxIdParts.length>1){
            try {
                int i = Integer.parseInt(boxIdParts[1]);
            }catch (NumberFormatException nfe) {
                return true;
            }
            return false;
        }
        return false;
    }
}