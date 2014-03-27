package LZ78;
import Trie.*;

/**
 * 
 * LZ78 implements the Lempel-Ziv '78 algorithm using Trie data structures for increased time complexity. 
 * @author Harshit Maheshwari
 *
 */
public class LZ78 {
	String input;
	int alphabetSize;
	private int inputLength, outputLength;
	/**
	 * Constructs the Lempel-Ziv algorithm object.
	 * @param input String to be compressed
	 * @param alphabetSize Alphabet size of the input string 
	 */
	public LZ78(String input, int alphabetSize){
		this.inputLength = input.length();
		this.outputLength = 0;
		this.input= input;
		this.alphabetSize = alphabetSize;
	}
	/**
	 * Converts the specified integer into binary string and makes the binary string of appropriate length by left padding zeroes 
	 * @param i	Integer to be converted into binary string
	 * @param phraseNumber Specifies the phrase number so that the output binary string can be of suitable length (i.e.
	 *  Upperbound(log(j*alpha)))
	 * @return Binary String conversion of specified integer
	 */
	private String binary(int i, int phraseNumber){
		String encoding = Integer.toBinaryString(i);
		double size = Math.log(phraseNumber*alphabetSize)/Math.log(2);
		int ceil = (int)Math.ceil(size);
		return org.apache.commons.lang3.StringUtils.leftPad(encoding, ceil, "0");
	}
	
	/**
	 * `setter` method for setting the input string 
	 * @param input String specifying the input string to be compressed
	 */
	public void setInput(String input){
		this.input = input;
		this.inputLength = input.length();
		this.outputLength = 0;
	}
	/**
	 * Compresses the input string based on LZ78 algorithm
	 * @param parse		Boolean parameter specifying whether the parsed input string is printed on system output or not
	 * @param output	Boolean parameter specifying whether output string (as produced by LZ'78)should be printed on
	 *  system output or not
	 * @param graph Boolean parameter specifying whether compressibility data for graph should be produced on system output
	 * @return Output length of the compressed string
	 */
	public int compress(boolean parse, boolean output, boolean graph){
		Trie<Node> trie = new Trie<Node>(new Node(0));
		char c[] =input.toCharArray();
		int pointer = 0;
		TrieNode trieNodePointer = trie.getTrieNodeHead();
		TrieNode pTNP;
		int phraseNumber = 1;
		while(pointer < c.length){
			pTNP = trieNodePointer;
			trieNodePointer = trie.findChar(trieNodePointer, c[pointer]);
			if(parse){
				System.out.print(c[pointer]);
			}
			if(trieNodePointer == null){
				if(graph){
					System.out.println(pointer + " " +  ((double)pointer/outputLength));
				}
				int delta = phraseNumber - pTNP.getNode().getLocation();
				if(parse){
					System.out.print(" " );
					System.out.println( delta + " " + c[pointer]);
				}
				this.outputLength += binary(delta*alphabetSize + c[pointer]-48, phraseNumber).length();
				if(output){
					System.out.println(binary(delta*alphabetSize + c[pointer]-48, phraseNumber));
				}
				trie.addCharNode(pTNP, c[pointer], new Node(phraseNumber));
				trieNodePointer = trie.getTrieNodeHead();
				phraseNumber++;
			}
			pointer ++;
		}
		return this.outputLength;
	}
	
	public String decompress(String input){
		
	}
	/**
	 * Returns the compressibility ratio of Lempel-Ziv 78 algorithm on the input string.
	 * @return double-the compressibility ratio of Lempel-Ziv 78 algorithm on the input string.
	 */
	public double compressibilityRatio(){
		return this.outputLength/(double)this.inputLength;
	}
	
}
