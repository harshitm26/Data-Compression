package LZ77;

public class Node {
	private int offset;
	private int length;
	private char symbol;
	
	public Node(int offset, int length, char symbol){
		this.offset = offset;
		this.length = length;
		this.symbol = symbol;
	}
	
	public Node(){
		this.offset = -1;
		this.length = -1;
		this.symbol = '\0';
	}
	
	public void setOffset(int offset){
		this.offset = offset;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public void setSymbol(char symbol){
		this.symbol = symbol;
	}
	
	public int getOffset(){
		return offset;
	}
	
	public int getLength(){
		return length;
	}
	
	public char getSymbol(){
		return symbol;
	}
	
	public void print(){
		System.out.println(offset + " " + length + " " + symbol);
	}
	
}
