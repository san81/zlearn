package com.san.weekly233;

public class NicePairsCount {
        public int countPairs(int[] nums, int low, int high) {
            int n = nums.length;
            // Create root node of Trie
            TrieNode root = new TrieNode();
            // Stores count of pairs that satisfy the given conditions
            int cntPairs = 0;
            // Traverse the given array
            for(int i = 0; i < n; i++) {
                // Update cntPairs
                cntPairs += cntSmaller(root, nums[i], high + 1) - cntSmaller(root, nums[i], low);
                // Insert nums[i] into Trie
                insertTrie(root, nums[i]);
            }
            return cntPairs;
        }

        // Function to count elements in Trie whose XOR with N less than K
        private int cntSmaller(TrieNode root, int N, int K) {
            // Stores count of elements whose XOR with N less than K
            int cntPairs = 0;
            // Traverse binary representation of N and K in Trie
            for (int i = 31; i >= 0 && root != null; i--) {
                // Stores ith bit of N
                int x = (N >> i) & 1;
                // Stores ith bit of K
                int y = (K >> i) & 1;
                // If the ith bit of K is 1
                if (y == 1) {
                    // If an element already present in Trie having ith bit (x)
                    if(root.child[x] != null)
                        cntPairs += root.child[x].cnt;

                    root = root.child[1 - x];
                } else {
                    // Update root
                    root = root.child[x];
                }
            }
            return cntPairs;
        }

        // Structure of Trie
        class TrieNode {
            // Stores binary represention of numbers
            TrieNode child[] = new TrieNode[2];
            // Stores count of elements present in a node
            int cnt;
            // Function to initialize a Trie Node
            public TrieNode() {
                this.cnt = 0;
            }
        }

        // Function to insert a number into Trie
        private void insertTrie(TrieNode root, int N) {
            // Traverse binary representation of X
            for (int i = 31; i >= 0; i--) {
                // Stores ith bit of N
                int x = (N >> i) & 1;
                // Check if an element already present in Trie having ith bit x
                if(root.child[x] == null) {
                    // Create a new node of Trie.
                    root.child[x] = new TrieNode();
                }
                // Update count of elements whose ith bit is x
                root.child[x].cnt += 1;
                // Update root
                root = root.child[x];
            }
        }


    public static void main(String[] args) {
//        int[] nums = new int[]{1,4,2,7};
//        int low = 2, high = 6;  //ans = 6
        System.out.println(2^1);
        int[] nums = new int[]{9,8,4,2,1};
        int low = 5, high = 14; // ans = 8
        System.out.println(new NicePairsCount().countPairs(nums, low, high));
    }
}
