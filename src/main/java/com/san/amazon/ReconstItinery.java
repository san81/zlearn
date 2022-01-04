package com.san.amazon;

import java.util.*;

class ReconstItinery {
    // origin -> list of destinations
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> visitBitmap = new HashMap<>();
    int flights = 0;
    List<String> result = null;


    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for (List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                List<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                List<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations and init the visit bitmap
        for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
            Collections.sort(entry.getValue());
            this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }

        this.flights = tickets.size();
        LinkedList<String> route = new LinkedList<String>();
        route.add("JFK");

        // Step 3). backtracking
        this.backtracking("JFK", route);
        return this.result;
    }

    protected boolean backtracking(String origin, LinkedList<String> route) {
        if (route.size() == this.flights + 1) {
            this.result = (List<String>) route.clone();
            return true;
        }

        if (!this.flightMap.containsKey(origin))
            return false;

        int i = 0;
        boolean[] bitmap = this.visitBitmap.get(origin);

        for (String dest : this.flightMap.get(origin)) {
            if (!bitmap[i]) {
                bitmap[i] = true;
                route.add(dest);
                boolean ret = this.backtracking(dest, route);
                route.pollLast();
                bitmap[i] = false;

                if (ret)
                    return true;
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
        List<List<String>> tickets =  new ArrayList<>();
        tickets.add(new ArrayList<String>(){{add("JFK");  add("KUL");}});
        tickets.add(new ArrayList<String>(){{add("JFK");  add("NRT");}});
        tickets.add(new ArrayList<String>(){{add("NRT");  add("JFK");}});

        System.out.println(new ReconstItinery().findItinerary(tickets));
    }

}
