package LZ77;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class LZ77 {
	String input;
	int alphabets;
	int searchBuffer;
	int laBuffer;
	
	public LZ77(String input, int alphabets, int searchBuffer, int laBuffer){
		this.input = input;
		this.alphabets = alphabets;
		this.searchBuffer = searchBuffer;
		this.laBuffer = laBuffer;
	}
	
	public LZ77(String input, int alphabets){
		this.input = input;
		this.alphabets = alphabets;
		this.searchBuffer = 4;
		this.laBuffer = 4;
	}
	
	public LZ77(){
		this.input = "";
		this.alphabets = 0;
		this.searchBuffer = -1;
		this.laBuffer = -1;
	}
	
	public char[] rightShift(char[] array, int toShift, char[] nextArray){
		array = Arrays.copyOfRange(array, toShift, array.length);
		return ArrayUtils.addAll(array, Arrays.copyOfRange(nextArray, 0, toShift));
	}
	
	public Node match(char[] search, char[] buffer){
		Node n = new Node(0,0,buffer[0]);
		for(int i=0; i<search.length; i++){
			for(int j=0; j<buffer.length; j++){
				if((i+j) >= search.length){
					//System.out.println("i: "+ i + " j: " + j);
					return n;
				}
				if(search[i+j] == buffer[j]){
					if(n.getLength() <= j){
						n.setLength(j+1);
						n.setOffset(i);
						n.setSymbol(buffer[j+1]);
					}
				}
				else{
					break;
				}
//				if(search[i+j] != buffer[j]){
//					if(n.getLength() > j){
//						break;
//					}
//					else{ 
//						n.setLength(j);
//						n.setOffset(i);
//						n.setSymbol(buffer[j]);
//						break;
//					}
//				}
//				else if(n.getLength() <= j){
//					n.setLength(j+1);
//					n.setOffset(i);
//					n.setSymbol(buffer[j]);
//				}
			}
		}
		return n;
	}
	
	public void compress() throws InterruptedException{
		char[] inputArray = input.toCharArray();
		char[] search = new char[searchBuffer];
		Arrays.fill(search, '0');
		char [] buffer = Arrays.copyOfRange(inputArray, 0, laBuffer);
		int length = 0;
		while((inputArray.length - length) > laBuffer){
			Thread.sleep(1000);
			Node output = match(buffer, search);
			length += output.getLength();
			System.out.println(Arrays.toString(search) + " " + Arrays.toString(buffer));
			output.print();
			search = rightShift(search, output.getLength(), buffer);
			buffer = rightShift(buffer, output.getLength(), inputArray);
		}
	}
}
