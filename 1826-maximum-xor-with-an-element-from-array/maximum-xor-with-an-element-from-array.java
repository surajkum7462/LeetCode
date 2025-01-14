class Node {
    Node[] links = new Node[2];

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public void put(int bit, Node node) {
        links[bit] = node;
    }

    public Node get(int bit) {
        return links[bit];
    }
}
class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int findMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}


class Solution {
   
         public int[] maximizeXor(int[] nums, int[][] queries) {
        // Sort nums in ascending order
        Arrays.sort(nums);
        
        // Store the original indices of the queries
        int[][] extendedQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            extendedQueries[i][0] = queries[i][0]; // xi
            extendedQueries[i][1] = queries[i][1]; // mi
            extendedQueries[i][2] = i;            // original index
        }
        
        // Sort queries by mi
        Arrays.sort(extendedQueries, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Result array to store the answers
        int[] result = new int[queries.length];
        
        // Trie to manage binary representation of numbers
        Trie trie = new Trie();
        int idx = 0; // Pointer for nums array
        
        // Process each query
        for (int[] query : extendedQueries) {
            int xi = query[0];
            int mi = query[1];
            int originalIndex = query[2];
            
            // Insert all nums ≤ mi into the Trie
            while (idx < nums.length && nums[idx] <= mi) {
                trie.insert(nums[idx]);
                idx++;
            }
            
            // Compute the maximum XOR if Trie is not empty
            if (idx == 0) {
                result[originalIndex] = -1; // No valid nums ≤ mi
            } else {
                result[originalIndex] = trie.findMax(xi);
            }
        }
        
        return result;
    }
}