import java.util.*;
import java.math.BigDecimal;
import java.math.*;
class Solution{
	public static void main(String[] args) {
		BigDecimal n = new BigDecimal("2");
		find2(sqrt(n));

		
	}
	public static BigDecimal sqrt(BigDecimal num) {
        if(num.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
        while(x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.000000000000000000000000001")) > 0);
        return x;
    }
     
    private static BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
        return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
    }
	public static void find1(BigDecimal num){
		String num2str = num+"";
		int[] record = new int[10];
		StringBuilder sb = new StringBuilder();
		for(char c:num2str.toCharArray()){
			if(sum(record) == 10) {
				System.out.println(sb);
				System.out.println(sb.length()-1);
				return;
			}
			int tmp = c - '0';
			
			if(tmp >= 0 && tmp <= 9 && record[tmp] == 0) record[tmp]++;
			sb.append(c);
		}
	}
	public static int sum(int[] arr){
		int res = 0;
		for(int i:arr) res+=i;
		return res;
	}
	public static void find2(BigDecimal num){
		String num2str = num + "";
		int[] record = new int[10];
		StringBuilder sb = new StringBuilder();
		String[] s = num2str.split("\\.");
		for(char c:s[1].toCharArray()){
			if(sum(record) == 10) {
				System.out.println(sb);
				System.out.println(sb.length()-1);
				return;
			}
			int tmp = c - '0';
			if(tmp >= 0 && tmp <= 9 && record[tmp] == 0) record[tmp]++;
			sb.append(c);
		}

	}
}