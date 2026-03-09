package com.san.datastructures.graphs;

//package com.san;
//
//
//import java.util.LinkedList;
//        import java.util.Map;
//        import java.util.Queue;
//        import java.util.Set;
//
//// interface MemberConnections {
//// given a member, it will return all his/her connections, if no connections, the list is an empty list
//// List<Member> getConnections(Member member);
//
//
//public class HelloWorld {
//
//    public static void main(String[] args){
//        //Prints "Hello, World" to the terminal
//        System.out.println("Hello, World");
//    }
//}
//
//class Member {
//    int memberId;
//    String firstName;
//    String lastName;
//    int age;
//    List<Member> connections;
//}
//
//    Pair<Member, Integer> pair = new Pair();
//
//interface FindConnectionDistance {
//    /**
//     * get connection distance between two members
//     */
//    int calculateConnectionDistance(Member member1, Member member2);
//}
//
//class FindConnectionDistanceImpl implements FindConnectionDistance {
//
//    // member1 <> member2 <> member3 <> member4 <> m5 <> m6
//    // m4 <> m2
//    int calculateConnectionDistance(Member member1, Member member2) {
//
//        Queue<Member> q1 = new LinkedList<>();
//        Queue<Member> q2 = new LinkedList<>();
//
//        Map<Member, Integer> memberToDepth1 = new HashMap<>();
//        Map<Member, Integer> memberToDepth2 = new HashMap<>();
//        q1.add(member1);
//        q2.add(member2);   // member1, depth =0  m6
//        memberToDepth1.put(member1, 0);
//        memberToDepth2.put(member2, 0);
//        while(!q1.isEmpty() || !q1.isEmpty()) {
//
//            int ans = scanNextLayer(q1, memberToDepth1, memberToDepth2, member2);
//            if(ans==-1) {
//                ans = scanNextLayer(q2, memberToDepth2, memberToDepth1, member1);
//            }
//
//            if(ans!=-1) {
//                return ans;
//            }
//        }
//        return -1;
//    }
//
//    public int scanNextLayer(Queue q, Map<Member, Integer> memberToDepth1, Map<Member, Integer> memberDepth2, Member memberToFind) {
//        int size = q.size();   //1
//
//        for(int i=0;i<size;i++) { //1
//            Member m = q.poll();   // member1
//            if(m.equals(memberToFind)) {  //false
//                return memberToDepth1.get(m);
//            }
//
//            if(memberToDepth2.get(m)!=null) {
//                return memberToDepth1.get(m) + memberToDepth2.get(m)-1;
//            }
//
//            if(memberToDepth1.get(m)==null) {
//                List<Member> childs = getConnections(m);
//                for(Member child:childs) {  //member2
//                    q1.add(child);
//                }
//                int val = memberToDepth1.getOrDefault(m, 1);
//                memberToDepth1.put(m, val+1);
//            }
//        }
//        return -1;
//    }
//
//}