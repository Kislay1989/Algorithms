package caching.lru;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head = new Node(-1);
    private final Node tail = new Node(-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new ConcurrentHashMap<>(capacity * 2);

        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        Node existing = map.get(key);
        if (existing != null) {
            existing.value = value;
            moveNodeToFront(existing);
        }

        Node node = new Node(value);
        map.put(key, node);
        addNodeToFront(node);

        if (map.size() > capacity) {
            removeLRU();
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        moveNodeToFront(node);

        return node.value;
    }

    private void moveNodeToFront(Node node) {
        removeNode(node);
        addNodeToFront(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    private void removeLRU() {
        Node lru = tail.prev;
        if (lru == head)
            return;

        removeNode(lru);
        map.values().remove(lru);
    }

    private void addNodeToFront(Node node) {
        Node first = head.next;
        node.prev = head;
        node.next = first;
        head.next = node;
        first.prev = node;
    }
}
