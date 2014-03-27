package Trie;

import java.util.ArrayList;

/**
 * Trie is the implmentation of the `trie` data structure in Java
 * @author Harshit Maheshwari
 *
 */
public class Trie <Type> {
	private TrieNode t;
	/**
	 * Constructs a new Trie with a default root node.
	 */
	public Trie(){
		this.t = new TrieNode();
	}
	
	/**
	 * Constructs a new Trie with default root node and specified node for the root node.
	 * @param n Node of the default root node of the Trie.
	 */
	public Trie( Node n){
		this.t = new TrieNode();
		this.t.setNode(n);
	}
	
	/**
	 * Returns the root node(TrieNode) of Trie
	 * @return Root TrieNode
	 */
	public TrieNode getTrieNodeHead(){
		return t;
	}
	
	/**
	 * Adds a new String as specified to Trie and adds all the additional TrieNodes needed for the addition of the string.
	 * @param s String to be added to Trie.
	 */
	public void addNode(String s){
		char[] stringArray = s.toCharArray();
		int matchPosition = 0;

		TrieNode iterator = t;
		boolean escapeLoop = false;
		while(iterator != null){
			if(iterator.getSymbolsList().size() != 0){
				TrieNodeSupp sIterator;
				int size = 0;
				ArrayList<TrieNodeSupp> sT = iterator.getSymbolsList();
				while(size++ != sT.size()){
					sIterator = sT.get(size - 1);
					if(sIterator.getSymbol() == stringArray[matchPosition]){
						matchPosition++;
						iterator = sIterator.getTrieNode();
						escapeLoop = true;
						break;
					}
				}
			}
			if(!escapeLoop){
				while(matchPosition != s.length()){
					TrieNode newT = new TrieNode(stringArray[matchPosition]);
					iterator.addTrieNodeSupp(new TrieNodeSupp (stringArray[matchPosition++], newT));
					iterator = newT;
				}
				iterator = null;
			}
			escapeLoop = false;
		}		
	}
	
	/**
	 * Prints the Trie Structure
	 */
	public void print(){
		printTrie(t);
	}
	
	/**
	 * Prints the Trie recursively. Called by the public method `print()`
	 * @param t TrieNode whose supplementary TrieNodes should be printed
	 */
	private void printTrie( TrieNode t){
		if(t.getSymbol() != '\0'){
			System.out.println(t.getSymbol());
		}
		if(t.getSymbolsList().size() != 0){
			TrieNodeSupp sIterator;
			int size = 0;
			ArrayList<TrieNodeSupp> sT = t.getSymbolsList();
			while(size++ != sT.size()){
				sIterator = sT.get(size-1);
			}
			size = 0;
			while(size++ != sT.size()){
				sIterator = sT.get(size-1);
				printTrie(sIterator.getTrieNode());
			}
		}
	}
	
	/**
	 * Searches the specified string in the Trie and returns the last TrieNode which matched with the characters in String.
	 * The method matches the longest prefix of the string in the Trie.
	 * @param s String to be searched
	 * @return TrieNode 
	 */
	public TrieNode find(String s){
		char[] c = s.toCharArray();
		TrieNode iterator = t;
		int matchPosition = 0;
		boolean conditionCheck = true;
		while(iterator!=null){
			TrieNodeSupp sIterator;
			int size = 0;
			ArrayList<TrieNodeSupp> sT = iterator.getSymbolsList();
			while(size++ != sT.size()){
				if(matchPosition >= c.length){
					break;
				}
				sIterator = sT.get(size - 1);
				if(sIterator.getSymbol() == c[matchPosition]){
					matchPosition ++;
					iterator = sIterator.getTrieNode();
					conditionCheck = false;
					break;
				}
			}
			if(conditionCheck){
				return iterator;
			}
			else{
				conditionCheck = true;
			}
		}
		return null;
	}
	/**
	 * TrieNode which contain the specified character and is next TrieNode to the specified TrieNode. Returns null 
	 * if no such TrieNode can be found.
	 * @param pointer TrieNode in which next TrieNode containing specified character is to be searched. 
	 * @param c Character to be searched.
	 * @return TrieNode which contain the specified character and is next TrieNode to the specified TrieNode. Returns null 
	 * if no such TrieNode can be found. 
	 */
	public TrieNode findChar(TrieNode pointer, char c){
		ArrayList<TrieNodeSupp> aL = pointer.getSymbolsList();
		if(aL.size() == 0){
			return null;
		}
		int size = 0;
		TrieNodeSupp sIterator;
		while(size++ < aL.size()){
			sIterator = aL.get(size-1);
			if(c == sIterator.getSymbol()){
				return sIterator.getTrieNode();
			}
		}
		return null;
	}
	
	/**
	 * Adds a new TrieNode containing the specified character and Node next to the specified TrieNode
	 * @param pointer TrieNode next to which the new TrieNode is to be added
	 * @param c Character t be added
	 * @param n Node (which specifies the phrase location in LZ78)
	 */
	public void addCharNode(TrieNode pointer, char c, Node n){
		TrieNode newNode = new TrieNode(c,n);
		pointer.addTrieNodeSupp(new TrieNodeSupp(c, newNode));
	}
	
	
	
	
}
