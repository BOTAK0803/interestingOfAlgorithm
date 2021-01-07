import java.util.*;
class Solution{
	public static void main(String[] args) {
		String str = "READ+WRITE+TALK=SKILL";
		helpler(str);
	}
	public static void helpler(String str){
		// 利用Java的正则表达式将以字母之外的字符分割字符串
		String[] strs = str.split("[^a-zA-Z]");
		// for(String s:strs) System.out.print(s +" --- ");
		// System.out.println(strs.length);
		StringBuilder sb = new StringBuilder();
		HashSet<Character> set = new HashSet<>();
		for(String s:strs){
			for(char c:s.toCharArray()){
				if(!set.contains(c)){
					sb.append(c);
					set.add(c);
				}
			}
		}
		System.out.println(sb);
		System.out.println(set);
	}
}