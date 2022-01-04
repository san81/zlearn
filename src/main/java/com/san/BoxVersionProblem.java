package com.san;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by santhoshgandhe on 3/24/19.
 *
 *
 *
 */

import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
class BoxVersionPersion
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int getMinimumCostToConstruct(int numTotalAvailableCities,
            int numTotalAvailableRoads,
            List<List<Integer>> roadsAvailable,
            int numNewRoadsConstruct,
            List<List<Integer>> costNewRoadsConstruct)
    {
        // WRITE YOUR CODE HERE
        return 0;
    }
    // METHOD SIGNATURE ENDS
}

public class BoxVersionProblem {

    public static void main(String[] args) {
        System.out.println(isOldVersion("avx 1dsfasd 23 ad"));

        List l = new ArrayList(3);



       Comparator<String> boxComparatior =  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                boolean isFirstOld = isOldVersion(o1);
                boolean isSecondOld = isOldVersion(o2);
                if(isFirstOld && !isSecondOld){
                    return 1;
                }else if(!isFirstOld && isSecondOld){
                    return -1;
                } else {
                    String[] firstWordStrings = o1.split(" ");
                    String[] secondWrodStrings = o2.split(" ");
                    return firstWordStrings[1].compareTo(secondWrodStrings[1]);
                }

            }
        };
        l.sort(boxComparatior);
    }

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


        for(int i=0;i<=boxList.size()-1 && newBoxIndex<boxList.size();i++){
            while(oldBoxIndex+1<boxList.size() && isOldVersion(boxList.get(oldBoxIndex))){
                oldBoxIndex++;
            }
            while(newBoxIndex<boxList.size() && !isOldVersion(boxList.get(newBoxIndex))){
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
                return false;
            }
            return true;
        }
        return false;
    }
}
