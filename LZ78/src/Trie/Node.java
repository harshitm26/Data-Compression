package Trie;

/**
 * @author Harshit Maheshwari 
 * This is an additional data structure that is used with the trie structure. It can be replaced with any other data structure 
 * which can then be used as the generic type argument to Trie data structure. The methods and fields of this data structure 
 * have meaning only w.r.t to LZ78.
 */
public class Node {
	private int location;
	/**
	 *	Constructs a new Node with default location -1.
	 */
	public Node(){
		this.location = -1;
	}
	/**
	 * Constructs a new Node with location as specified in location.
	 * @param location New Node's location in trie data structure.
	 */
	public Node(int location){
		this.location = location;
	}
	/**
	 * Get the location of node (occurrence of phrase in LZ78).
	 * @return Location of occurrence of phrase in LZ78.
	 */
	public int getLocation(){
		return location;
	}
	
	/**
	 * Sets the location of node (occurrence of phrase in LZ78).
	 * @param location Location of occurrence of phrase in LZ78. 
	 */
	public void setLocation(int location ){
		this.location = location;
	}

	
	
}
