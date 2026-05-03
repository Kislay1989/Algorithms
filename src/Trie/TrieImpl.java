package Trie;

public class TrieImpl implements Trie {

    private final TrieNode root;

    public TrieImpl() {
        root = new TrieNode();
    }

    @Override
    public void insert(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }

        current.isEndOfWord = true;
    }

    @Override
    public boolean search(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }

    @Override
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;
            }
            current = current.children.get(ch);
        }

        return false;
    }

    @Override
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        // Base case: We've reached the end of the word
        if (index == word.length()) {
            // If the word is not registered in Trie, we can't delete it
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }

        char ch = word.charAt(index);
        TrieNode child = current.children.get(ch);
        // Word not found in Trie
        if (child == null) {
            return false;
        }

        boolean shouldDeleteChild = delete(child, word, index + 1);
        if (shouldDeleteChild) {
            current.children.remove(ch);
            return current.children.isEmpty() && !current.isEndOfWord;
        }
        return false;
    }
}
