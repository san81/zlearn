package com.san.amazon;

import java.util.*;

class TreeNode {
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(String val) { this.val = val; }
    TreeNode(String val, TreeNode left) { this.val = val; this.left = left; }
    TreeNode(String val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }

}


class Ticket {
    String origin;
    String dest;

    boolean isVisited = false;

    public Ticket(String origin, String dest) {
        this.origin = origin;
        this.dest = dest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(origin, ticket.origin) &&
                Objects.equals(dest, ticket.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origin, dest);
    }
}

public class ReconstructItinerary {

    Map<String, List<String>> adjMat = new HashMap<>();
    int nofTickets = 0;
    List<String> result = new ArrayList<>();
    Map<String, boolean[]> visited = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

       for(List<String> ticket:tickets){
           String origin = ticket.get(0);
           String dest = ticket.get(1);
           List<String> nextDest = adjMat.getOrDefault(origin, new ArrayList<String>());
           nextDest.add(dest);
           adjMat.put(origin, nextDest);
       }

       //Order the adj matrix before moving on
        for(Map.Entry<String, List<String>> entry:adjMat.entrySet()){
            Collections.sort(entry.getValue());
            this.visited.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
       nofTickets = tickets.size();
       result.add("JFK");
        backtrack("JFK", result);
        return result;
    }


    public boolean backtrack(String origin, List<String> result) {
        if(result.size() == nofTickets + 1){
            this.result = new ArrayList<>(result);
            return true;
        }

        List<String> nextDest = adjMat.get(origin);
        if(null==nextDest){
            //There is nothing more to travel in this path
            return false;
        }

        int i = 0;
        boolean[] visitMap = this.visited.get(origin);
        for(String nextAirport:nextDest) {
            Ticket nextTckt = new Ticket(origin, nextAirport);
            if(!visitMap[i]){
                result.add(nextTckt.dest);
                visitMap[i] = true;
                boolean doesThisPathWork = this.backtrack(nextTckt.dest, result);


                if(doesThisPathWork){
                    return true;
                }else{
                    visitMap[i] = false;
                    result.remove(result.size()-1);
                }
            }
            ++i;
        }
        return false;
    }

    public static void main(String[] args) {
//        List<List<String>> tickets =  new ArrayList<>();
//        tickets.add(new ArrayList<String>(){{add("MUC");  add("LHR");}});
//        tickets.add(new ArrayList<String>(){{add("JFK");  add("MUC");}});
//        tickets.add(new ArrayList<String>(){{add("SFO");  add("SJC");}});
//        tickets.add(new ArrayList<String>(){{add("LHR");  add("SFO");}});

        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        List<List<String>> tickets =  new ArrayList<>();
//        tickets.add(new ArrayList<String>(){{add("JFK");  add("SFO");}});
//        tickets.add(new ArrayList<String>(){{add("JFK");  add("ATL");}});
//        tickets.add(new ArrayList<String>(){{add("SFO");  add("ATL");}});
//        tickets.add(new ArrayList<String>(){{add("ATL");  add("JFK");}});
//        tickets.add(new ArrayList<String>(){{add("ATL");  add("SFO");}});

        // [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
//        List<List<String>> tickets =  new ArrayList<>();
//        tickets.add(new ArrayList<String>(){{add("JFK");  add("KUL");}});
//        tickets.add(new ArrayList<String>(){{add("JFK");  add("NRT");}});
//        tickets.add(new ArrayList<String>(){{add("NRT");  add("JFK");}});

        //[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],
        // ["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]

        List<List<String>> tickets =  new ArrayList<>();
        tickets.add(new ArrayList<String>(){{add("EZE");  add("AXA");}});
        tickets.add(new ArrayList<String>(){{add("TIA");  add("ANU");}});
        tickets.add(new ArrayList<String>(){{add("ANU");  add("JFK");}});
        tickets.add(new ArrayList<String>(){{add("JFK");  add("ANU");}});
        tickets.add(new ArrayList<String>(){{add("ANU");  add("EZE");}});
        tickets.add(new ArrayList<String>(){{add("TIA");  add("ANU");}});
        tickets.add(new ArrayList<String>(){{add("AXA");  add("TIA");}});
        tickets.add(new ArrayList<String>(){{add("TIA");  add("JFK");}});
        tickets.add(new ArrayList<String>(){{add("ANU");  add("TIA");}});
        tickets.add(new ArrayList<String>(){{add("JFK");  add("TIA");}});

        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }
}
