package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    // Every Node is represented by its data (character) as key and
    // value is the node that represents the next state information.
    // Each Node represents the prefix of the string that is being inserted in the Trie.

    Map<Character, TrieNode> children;

    // If for any Node isEndOfWord is true, it means that the path from root to that Node represents a complete word in the Trie.
    boolean isEndOfWord;

    TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
