import java.util.*;
import java.math.BigInteger;
class Solution{
	public static void main(String[] args) {
		System.out.println(helper());
		System.out.println(helper2());
			
	}
	public static int helper(){
		int count = 0;
		int line = 1;
		ArrayList<Integer> row = new ArrayList<>();
		row.add(1);
		while(count < 2014){
			ArrayList<Integer> nextRow = new ArrayList<>();
			nextRow.add(1);
			for(int i = 0;i<row.size()-1;i++){
				int cell = row.get(i) ^ row.get(i+1);
				nextRow.add(cell);
				if(cell == 0) count++;
			}
			nextRow.add(1);
			line++;
			row = nextRow;
		}
		return line;

	}
	/**
	用二进制里的1和0表示行，通过“用前一行左移一位后的值与该行（即‘前一行’）的值作异或运算”就可以求得下一行的值。
	*/
	public static int helper2(){
		int count = 0;
		int line = 1;
		BigInteger row = new BigInteger("1");
		while(count < 2014){
			row = row.xor(row.shiftLeft(1));
			System.out.println(row.toString(2));
			count+=countZero(row.toString(2));
			line+=1;
		}
		return line;
	}
	public static int countZero(String str){
		int count = 0;
		for(int i = 0;i<str.length();i++) if(str.charAt(i) == '0') count++;
		return count;
	}
}