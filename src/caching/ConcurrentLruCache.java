package caching;

import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is a thread-safe implementation of an LRU (Least Recently Used) cache with O(1) get + put, thread-safe.
 * The cache evicts the least recently used item when the capacity is exceeded.
 * Since O(1) get and put are required, we can use a combination of a Map and a Doubly Linked List.
 * The HashMap will provide O(1) access to the cache items, while the Doubly Linked List will maintain the order of usage,
 * allowing us to quickly identify and evict the least recently used item when necessary.
 */

public class ConcurrentLruCache<K, V> {

    private final int capacity;
    private final ConcurrentHashMap<K, Node<K, V>> map;

    // One doubly linked list
    // With two dummy (sentinel) nodes → head and tail
    private final Node<K, V> head = new Node<>(null, null);
    private final Node<K, V> tail = new Node<>(null, null);

    public ConcurrentLruCache(int capacity) {
        this.capacity = capacity;
        this.map = new ConcurrentHashMap<>(capacity * 2);

        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }

        moveToFront(node);
        return node.value;
    }

    // Most recent always near head.
    // Least recent always near tail.
    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("key cannot be null");

        Node<K, V> existing = map.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }

        Node<K, V> node = new Node<>(key, value);
        map.put(key, node);
        addToFront(node);

        if (map.size() > capacity) {
            Node<K, V> lru = removeLru();
            if (lru != null) {
                map.remove(lru.key, lru);
            }
        }

    }

    private Node<K, V> removeLru() {
        Node<K, V> lru = tail.prev;
        if (lru == head)
            return null; // empty list

        removeNode(lru);
        return lru;
    }

    private void moveToFront(Node<K, V> node) {
        removeNode(node);
        addToFront(node);
    }

    private void removeNode(Node<K, V> node) {
        Node<K, V> p = node.prev;
        Node<K, V> n = node.next;

        if (p != null)
            p.next = n;
        if (n != null)
            n.prev = p;

        node.prev = null;
        node.next = null;
    }

    private void addToFront(Node<K, V> node) {
        Node<K, V> first = head.next;
        node.prev = head;
        node.next = first;
        head.next = node;
        first.prev = node;
    }

    private static final class Node<K, V> {
        final K key;
        V value;

        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

}
