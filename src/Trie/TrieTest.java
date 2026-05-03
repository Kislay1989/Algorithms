package Trie;

/**
 * Created by kislay on 3/26/18.
 */
public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new TrieImpl();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("appl"));    // false
        System.out.println(trie.startsWith("ap"));  // false

        boolean status = trie.delete("apple");
        if (status) {
            System.out.println("Deleted successfully");
        } else {
            System.out.println("Deletion failed");
        }

        System.out.println(trie.search("apple"));   // false
        System.out.println(trie.search("app"));     // t    // returns true
    }
}
