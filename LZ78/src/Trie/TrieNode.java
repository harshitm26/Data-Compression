package Trie;

import java.util.ArrayList;

/**
 * TrieNode class is the nodes in the `trie` data structure implementation. Each node (TrieNode) has the usual two standard 
 * fields: a character symbol and a reference to the next TrieNodes. In addition it also has a Node field which has use for
 * the LZ78 algorithm implementation. For normal usage this field can be safely passed as null.
 * @author Harshit Maheshwari
 *  
 */
public class TrieNode {
	char c;
	private Node n;
	private ArrayList<TrieNodeSupp> aL;
	
	/**
	 * Constructs a new TrieNode with null fields.
	 */
	public TrieNode(){
		this.c = '\0';
		this.aL =  new ArrayList<TrieNodeSupp>();
	}
	
	/**
	 * Constructs a new TrieNode with character and ArrayList as specified.
	 * @param c Character in the `trie` data structure.
	 * @param aL ArrayList of supplementary TrieNodes - TrieNodeSupp.
	 */
	public TrieNode(char c, ArrayList<TrieNodeSupp> aL){
		this.c = c;
		this.aL = aL;
	}
	
	/**
	 * Constructs a new TrieNode with character as specified and am empty ArrayList.
	 * @param c Character in the `trie` data structure.
	 */
	public TrieNode(char c){
		this.c = c;
		this.aL = new ArrayList<TrieNodeSupp>();
	}
	
	/**
	 * Constructs a new TrieNode with character, Node as specified and an empty ArrayList of next TrieNodes.
	 * @param c Character in the `trie` data structure.
	 * @param n	Node which tells the position of the phrase in LZ78.
	 */
	public TrieNode(char c, Node n){
		this.c = c;
		this.n = n;
		this.aL = new ArrayList<TrieNodeSupp>();
	}
	
	/**
	 * Sets the Node in TrieNode (Node tells the position of the phrase in LZ78).
	 * @param n Node which tells the position of the phrase in LZ78.
	 */
	public void setNode(Node n){
		this.n = n;
	}
	
	/**
	 * Returns the ArrayList of next Nodes in `trie` data structure.
	 * @return ArrayList of next Nodes in `trie` data structure.
	 */
	public ArrayList<TrieNodeSupp> getSymbolsList(){
		return aL;
	}
	/**
	 * Returns the character symbol of the node in `trie`
	 * @return Character symbol of the node in `trie`
	 */
	public char getSymbol(){
		return c;
	}
	/**
	 * Returns the Node which tells the location of the phrase in LZ78.
	 * @return Returns the Node which tells the location of the phrase in LZ78.
	 */
	public Node getNode(){
		return n;
	}
	
	/**
	 * Adds the next next TrieNode reference using supplementary TrieNode-TrieNodeSupp  by adding an entry in the ArrayList  
	 * @param sT Supplementary TrieNode
	 */
	public void addTrieNodeSupp(TrieNodeSupp sT){
		aL.add(sT);
	}
	
	
}
