import java.util.*;
class Solution{
	public static void main(String[] args) {
		/**
		System.out.println(de2bin(585));
		System.out.println(de2oct(585));
		*/
		System.out.println(de2x(find(),2));
		System.out.println(de2x(find(),8));
		System.out.println(isPalindrome(de2x(find(),2)));
		System.out.println(isPalindrome(de2x(find(),8)));
		System.out.println(find());
		// 使用内置函数进行不同进制之间的相互转化
		/**
		10To2 toBinaryString
		10To8 toOctalString
		10To16 toHexString
		*/
		System.out.println(Integer.toBinaryString(585));
		System.out.println(Integer.toOctalString(585));
		System.out.println(Integer.toHexString(585));	
	}
	/**
	// 将10进制转化成为2进制
	public static String de2bin(int num){
		StringBuilder sb = new StringBuilder();
		while(num!=0){
			int tmp = num%2;
			sb.insert(0,tmp);
			num=num/2;
		}
		return sb.toString();
	}
	// 将10进制转化成为8进制
	public static String de2oct(int num){
		StringBuilder sb = new StringBuilder();
		while(num!=0){
			int tmp = num%8;
			sb.insert(0,tmp);
			num=num/8;
		}
		return sb.toString();
	}
	*/
	/**
	params num : 要转化的十进制数
	params x: 要转化的x进制
	*/
	public static String de2x(int num,int x){
		StringBuilder sb = new StringBuilder();
		while(num!=0){
			int tmp = num%x;
			sb.insert(0,tmp);
			num=num/x;
		}
		return sb.toString();
	}
	/**
	判断是否是回文字符串
	*/
	public static boolean isPalindrome(String str){
		int i = 0;
		int j  = str.length()-1;
		while(i<j) {
			if(str.charAt(i) != str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
	/**
	寻找不小于10的十进制数，这个十进制数满足其二进制或者8进制的表示都是回文
	*/
	public static int find(){
		// for(int i = 10;i<Integer.MAX_VALUE;i++) if(isPalindrome(i+"") && isPalindrome(de2x(i,2)) && isPalindrome(de2x(i,8))) return i;
		// 优化：因为回文数二进制表示第一位不是0，所以二进制表示的数字的最后一位一定是1，也就是说一定是奇数
		for(int i = 11;i<Integer.MAX_VALUE;i+=2) if(isPalindrome(i+"") && isPalindrome(de2x(i,2)) && isPalindrome(de2x(i,8))) return i;
		return -1;
	}
}