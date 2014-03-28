package LZ78;

public class lzNode {
	private int offset;
	private char symbol;
	public lzNode(){
		this.offset = 0;
		this.symbol = '\0';
	}
	public lzNode(int offset, char symbol){
		this.offset = offset;
		this.symbol = symbol;
	}
	public int getOffset(){
		return this.offset;
	}
	public void setOffset(int offset){
		this.offset = offset;
	}
	public char getSymbol(){
		return symbol;
	}
	public void setSymbol(char symbol){
		this.symbol = symbol;
	}
}
