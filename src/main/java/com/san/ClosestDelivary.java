package com.san;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by santhoshgandhe on 9/2/18.
 */

// CLASS BEGINS, THIS CLASS IS REQUIRED


class Pair {
    Integer x;
    Integer y;

    public Pair(Integer x,Integer y){
        this.x=x;
        this.y=y;
    }

    public Double getDistance(){
        return Math.sqrt((x*x)+(y*y));
    }

    public List<Integer> toList(){
        ArrayList<Integer> listToReturn = new ArrayList();
        listToReturn.add(x);
        listToReturn.add(y);
        return listToReturn;
    }
}

public class ClosestDelivary
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static List<List<Integer>> closestXdestinations(int numDestinations,
                                                    List<List<Integer>> allLocations,
                                                    int numDeliveries)
    {
        Set<Pair> dest = new TreeSet<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getDistance().compareTo(o2.getDistance());
            }
        });

        for(List<Integer> allLocationsEntry:allLocations){
            dest.add(new Pair(allLocationsEntry.get(0),allLocationsEntry.get(1)));
        }

        List<List<Integer>> deliveriesToRun = new ArrayList<List<Integer>>();
        Iterator<Pair> destIterator = dest.iterator();
        int i = 0;
        while(destIterator.hasNext() && i<numDeliveries ) {
            deliveriesToRun.add(destIterator.next().toList());
            i++;
        }
        return deliveriesToRun;
    }


    public static void main(String ar[]){

        List<List<Integer>>  allLocations = new ArrayList<List<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>(2);
        l1.add(3); l1.add(6);
        allLocations.add(l1);

        ArrayList<Integer> l2 = new ArrayList<>(2);
        l2.add(2); l2.add(4);
        allLocations.add(l2);

        ArrayList<Integer> l3 = new ArrayList<>(2);
        l3.add(5); l3.add(3);
        allLocations.add(l3);

        ArrayList<Integer> l4 = new ArrayList<>(2);
        l4.add(2); l4.add(7);
        allLocations.add(l4);

        ArrayList<Integer> l5 = new ArrayList<>(2);
        l5.add(1); l5.add(8);
        allLocations.add(l5);

        ArrayList<Integer> l6 = new ArrayList<>(2);
        l6.add(7); l6.add(9);
        allLocations.add(l6);

        List<List<Integer>> lists = closestXdestinations(6, allLocations, 3);
        System.out.print(lists);

        System.out.print(Math.sqrt(9+36));
        System.out.print(Math.sqrt(9+25));
    }

}