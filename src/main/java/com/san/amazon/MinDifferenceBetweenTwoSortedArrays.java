package com.san.amazon;

import java.util.*;

public class MinDifferenceBetweenTwoSortedArrays {
}

/*
Q: Tell me about a time when you took on something significant outside your area of responsibility.
        Why was it important? What was the outcome?



        Q: Tell me about a time when you were able to make something simpler for customers?



        Assume that you have a straight road from your home to office and you have started the journey.
        As you procceed though the journey, you see diferent type of installation (e.g. Hospital, Police Station, Pub).
        For example, you see a police station 1KM from home and a pub at 3 KM from home.
        As user would like to know max Or min distance b/w two installation of same or different type at any point of time.
        You can provide a fun to query.

        Home -> Hopsital  10km
        Home -> PoliceStation 12km   (min dinstance between hopital and poicate station = 2km)
        Home -> Hopistal 13km       (min dinstance between hopital and poicate station = 1km)
        Home -> PoliceStation 15km       (min dinstance between hopital and poicate station = 1km)


        H      P       H        S
        0 --- 1 ---- 4 ----- 7 ----- 10 -----


        H  1   7    15   20   22...

        P  4   16   25   30   35....

        minDisntance between the entities = 3
   */





class Journey {

    Set<String> distinctEntities = new HashSet<>();

    Map<String, List<Integer>> entityDistances = new HashMap<>();



    public void recordEncounter(String entity, int distance) {


    }

    public int query(String entity1, String entity2) {
        //return the min disntance between the these two entities given in the input
        List<Integer> e1Distnace = entityDistances.get(entity1);
        List<Integer> e2Distnace = entityDistances.get(entity2);

        int answer = 0;
        int e1Pointer = 0;
        int e2Pointer = 0;
        while(e1Pointer < e1Distnace.size() && e2Pointer<e2Distnace.size()) {
            answer = Math.min(answer, Math.abs(e1Distnace.get(e1Pointer) - e2Distnace.get(e2Pointer)));

            if(e1Pointer==e1Distnace.size() && e2Pointer<e2Distnace.size()) {
                e2Pointer++;
            }else if(e2Pointer == e2Distnace.size() && e1Pointer < e2Distnace.size()){
                e1Pointer++;
            }
            else if(e1Distnace.get(e1Pointer) <= e2Distnace.get(e2Pointer) && e1Pointer<e1Distnace.size()) {
                e1Pointer++;
            }else if(e1Distnace.get(e1Pointer) > e2Distnace.get(e2Pointer) && e2Pointer<e2Distnace.size()) {
                e2Pointer++;
            }

        }
        return answer;
    }
}


/*
H  1   7    15   20   22  35..


P  4   16   25   30   35....

e1pointer = 2 e2Pointer=1;
answer = 1



Q: If you were to design a client for file upload where we can assume there is a backend,
how would approach the problem and what kind of issues you might face during the design?


 */


