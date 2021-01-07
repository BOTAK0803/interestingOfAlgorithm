import java.util.*;
class Solution{
	public static void main(String[] args) {
		System.out.println(sumOfInt(303));
		fib();
		
	}
	public static void fib(){
		ArrayList<Integer> res = new ArrayList<Integer>();
		int n = 1;
		long a = 1;
		long b = 1;
		while(n<=5){
			long c = a+b;
			a = b;
			b = c;
			if(c > 144 && c%sumOfInt(c) == 0){
				System.out.println(c);
				n++;
			}
		}
	}
	public static long sumOfInt(long num){
		String num2str = num+"";
		long res = 0;
		for(char c:num2str.toCharArray()) res += c-'0';
		return res;
	}
}