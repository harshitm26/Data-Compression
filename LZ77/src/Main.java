import java.util.Arrays;

import LZ77.*;
/**
 * Main class is used for testing LZ77 algorithm
 * @author Harshit Maheshwari
 *
 */
public class Main {
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	
	public static void main(String args[]) throws InterruptedException{
		String input = "0100011011" + "000001010011";
		LZ77 lz = new LZ77(input,2);
		//lz.compress();
//		char array[] = "1001".toCharArray();
//		char arrayNext[] = "1011".toCharArray();
//		System.out.println(Arrays.toString(lz.rightShift(array, 2, arrayNext)));
//		Node n = lz.match(array, arrayNext);
//		n.print();
		lz.compress();
	}
}
