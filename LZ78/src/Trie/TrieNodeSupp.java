package Trie;

/**
 * @author Harshit Maheshwari
 * TrieNodeSupp class is the supplementary Node class for TrieNode which in turn is used for `trie` data structure implementation.
 * Each TrieNodeSupp node has a character symbol and a reference to the next TrieNode in `trie` data structure
 */
public class TrieNodeSupp {
	private char c;
	private TrieNode t;
	/**Returns the character symbol
	 * @return Character Symbol
	 */
	public char getSymbol(){
		return c;
	}
	/**Returns the next TrieNode in `trie` data structure
	 * @return Next TrieNode in the `trie` data structure
	 */
	public TrieNode getTrieNode(){
		return t;
	}
	/** Creates a supplementary TrieNode with null fields
	 * 
	 */
	public TrieNodeSupp(){
		this.c = '\0';
		this.t = null;
	}
	/** Creates a supplementary TrieNode with the character as specified by c and pointing to next TrieNode as specified by t
	 * @param c Character Symbol
	 * @param t TrieNode
	 */
	public TrieNodeSupp(char c, TrieNode t){
		this.c = c;
		this.t = t;
	}
	
}
