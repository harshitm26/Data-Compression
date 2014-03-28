import java.io.BufferedReader;

import Trie.*;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import LZ78.*;
/**
 * The test file for Lempel-Ziv '78 algorithm. 
 * Ehrenfeucht-Mycielski sequence with initial 10,000 bits is compressed and the compressibility ratio is studied.
 * @author Harshit Maheshwari
 *
 */


public class Main {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void part1() throws IOException{
		try {
			BufferedReader br = new BufferedReader( new FileReader("input/Ehrenfeucht-Mycielski.txt"));
			BufferedWriter bw = new BufferedWriter( new FileWriter("output.dat"));
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null){
				sb.append(line);
	            sb.append(System.lineSeparator());
			}
			LZ78 lz78 = new LZ78(sb.toString(),2);
			for(int i=1; i<sb.toString().length(); i++){
				lz78.setInput(sb.toString().substring(0, i));
				lz78.compress(false, false, false);
				bw.write(i + " " + lz78.compressibilityRatio() + "\n");
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot open the file");
		}
	}
		
	public static void testTrie(){
		Trie<Node> trie = new Trie<Node>();
		trie.addNode("a");
		trie.addNode("aed");
		trie.addNode("bc");
		trie.addNode("bb");
		System.out.println(trie.find("a").getSymbol());
		trie.print();
	}
	
	public static void main(String args[]) throws IOException{		
		//part1();
		try {
			BufferedReader br = new BufferedReader( new FileReader("input/Ehrenfeucht-Mycielski.txt"));
			String line;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine())!=null){
				sb.append(line);
	            sb.append(System.lineSeparator());
			}
			LZ78 lz78 = new LZ78(sb.toString(),2);
			//lz78.compress(false, true, false);
			lz78.decompress("10101100101100100111010");
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Cannot open the file");
		} 
	}
}
