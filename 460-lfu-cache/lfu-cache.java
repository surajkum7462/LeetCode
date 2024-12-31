import java.util.*;

class LFUCache {
    private class Node {
        int key, value, frequency;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
    }

    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> keyToNode;
    private final Map<Integer, LinkedHashSet<Node>> freqToNodes;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToNode = new HashMap<>();
        this.freqToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateNode(node);
        } else {
            if (keyToNode.size() == capacity) {
                evictLFU();
            }
            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToNodes.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFrequency = 1; // Reset minimum frequency to 1 for the new node
        }
    }

    private void updateNode(Node node) {
        // Remove node from current frequency list
        int freq = node.frequency;
        freqToNodes.get(freq).remove(node);

        // Clean up if the frequency list becomes empty
        if (freqToNodes.get(freq).isEmpty()) {
            freqToNodes.remove(freq);
            if (freq == minFrequency) {
                minFrequency++;
            }
        }

        // Update node's frequency
        node.frequency++;
        freqToNodes.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node);
    }

    private void evictLFU() {
        // Evict the least frequently used node
        LinkedHashSet<Node> lfuNodes = freqToNodes.get(minFrequency);
        Node nodeToRemove = lfuNodes.iterator().next(); // Remove the first (oldest) node
        lfuNodes.remove(nodeToRemove);

        // Clean up if the frequency list becomes empty
        if (lfuNodes.isEmpty()) {
            freqToNodes.remove(minFrequency);
        }

        keyToNode.remove(nodeToRemove.key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity); **/
