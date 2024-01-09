package com.san.amazon;


//# you have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
//        #The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
//        # Each move consists of turning one wheel one slot.
//        # The lock initially starts at '0000', a string representing the state of the 4 wheels.
//        # You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
//        # the wheels of the lock will stop turning and you will be unable to open it.
//        # Given a target representing the value of the wheels that will unlock the lock,
//        # return the minimum total number of turns required to open the lock, or -1 if it is impossible.
//
//        # Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//        # Output: 6
//        # Explanation:
//        # A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
//        # Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
//        # because the wheels of the lock become stuck after the display becomes the dead end
//
//        # 0000 => 0009, 0001, 0002, 0003 .......
//        # 0001 => 0000, 0002, 0011, 0101 .......
//        #
//        # adjMat


import java.util.*;

class VisitChain {
        VisitChain origin;
        String sequence;

        public VisitChain(VisitChain origin, String sequence){
                this.origin = origin;
                this.sequence = sequence;
        }
}

class UnlockASequence {

        public int openLock_san(String[] deadends, String target) {

                int steps = -1;
                Set<String> visitedSeqStr = new HashSet<>();
                Queue<VisitChain> queue = new LinkedList<>();
                Set<String> deadendsSet = new HashSet<>();
                for(String deadend:deadends){
                        deadendsSet.add(deadend);
                        if(deadend.equals("0000"))
                                return -1;
                }
                queue.add(new VisitChain(null,"0000"));

                while(!queue.isEmpty()){
                        int qSize = queue.size();
                        steps++;
                        for(int i=0;i<qSize; i++) {
                                VisitChain currentValueChain = queue.poll();
                                String curSeq = currentValueChain.sequence;
                                if(curSeq.equals(target)) {
                                        printChain(currentValueChain);
                                        return steps;
                                }
                                visitedSeqStr.add(currentValueChain.sequence);
                                if(!deadendsSet.contains(curSeq)) {
                                        for (String nextSeq : getNeighbors(curSeq, deadendsSet, visitedSeqStr)) {
                                                if (!visitedSeqStr.contains(nextSeq)) {
                                                        visitedSeqStr.add(nextSeq);
                                                        queue.add(new VisitChain(currentValueChain, nextSeq));
                                                }
                                        }

                                }
                        }

                }
                return -1;
        }

        public void printChain(VisitChain vc) {
                while(vc!=null){
                        System.out.print(vc.sequence+" --> ");
                        vc = vc.origin;
                }
        }

        public List<String> getNeighbors(String s, Set<String> deadends, Set<String> visitedSeqStr) {
                List<String> neighbors = new ArrayList<>();
                for(int i=0;i<4;i++) {
                        for(int d=-1;d<=1;d+=2){
                            int y = ((s.charAt(i) - '0') + d + 10) %10;
                            String nei = s.substring(0,i)+y+s.substring(i+1);
                            if(!visitedSeqStr.contains(nei) && !deadends.contains(nei)) {
                                    neighbors.add(nei);
                            }
                        }
                }
                return neighbors;
        }

        public int openLock(String[] deadends, String target) {
                Set<String> dead = new HashSet();
                for (String d: deadends) dead.add(d);

                Queue<String> queue = new LinkedList();
                queue.offer("0000");
                queue.offer(null);

                Set<String> seen = new HashSet();
                seen.add("0000");

                int depth = 0;
                while (!queue.isEmpty()) {
                        String node = queue.poll();
                        if (node == null) {
                                depth++;
                                if (queue.peek() != null)
                                        queue.offer(null);
                        } else if (node.equals(target)) {
                                return depth;
                        } else if (!dead.contains(node)) {
                                for (int i = 0; i < 4; ++i) {
                                        for (int d = -1; d <= 1; d += 2) {
                                                int y = ((node.charAt(i) - '0') + d + 10) % 10;
                                                String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                                                if (!seen.contains(nei)) {
                                                        seen.add(nei);
                                                        queue.offer(nei);
                                                }
                                        }
                                }
                        }
                }
                return -1;
        }

        public static void main(String[] args) {
                String target = "0202";
                String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
//                String[] deadends = new String[]{"0000"}; String target = "8888";
//                String[] deadends = new String[]{"8888"}; String target = "0009";
//                String[] deadends = new String[]{"8889","8878","8898","8788","8988","7888","9888","8887"}; String target = "8888";
//                String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}; String target = "8888";
                System.out.println(new UnlockASequence().openLock_san(deadends, target));

        }


}


