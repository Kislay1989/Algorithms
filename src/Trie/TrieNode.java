package Trie;

/**
 * Created by kislay on 3/27/18.
 */
public class TrieNode {

    private static final int ALPHABET_SIZE = 26;
    private boolean isEnd;
    private TrieNode[] children;

    TrieNode()
    {
	isEnd = false;
	children = new TrieNode[ALPHABET_SIZE];
	for (int i = 0; i < ALPHABET_SIZE; i++)
	    children[i] = null;
    }

    public boolean isEnd()
    {
	return isEnd;
    }

    public void setEnd(boolean end)
    {
	isEnd = end;
    }
}
