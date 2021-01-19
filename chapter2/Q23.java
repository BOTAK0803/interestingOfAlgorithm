import java.util.*;
class Solution{
	public static void main(String[] args) {
		System.out.println(helper(10,24));
		System.out.println(helper2(10,24));
		
	}
	/**
	直接使用回溯
	*/
	public static int helper(int coin,int depth){
		if(coin == 0) return 0;
		if(depth == 0) return 1;
		int win = helper(coin+1,depth-1);
		int lose = helper(coin-1,depth-1);
		return win+lose;
	}
	/**
	使用内存化的操作，以空间换时间
	*/
	static HashMap<String,Integer> record = new HashMap<>();
	public static int helper2(int coin,int depth){
		String tmp = ""+coin+depth;
		if(record.containsKey(tmp)) return record.get(tmp);
		if(coin == 0) return 0;
		if(depth == 1) return 1;
		int win = helper(coin+1,depth-1);
		int lose = helper(coin-1,depth-1);
		record.put(tmp,win+lose);
		return win+lose;

	}
}