import java.util.*;
class Solution{
	public static void main(String[] args) {
		helper();
		
	}
	public static void helper(){
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 1;i<=50;i++) {
			if(i%2==0 || i%5==0) continue;
			arr.add(i);
		}
		ArrayList<Integer> res = new ArrayList<>();
		int k = 1;
		while(!arr.isEmpty()){
			int x = Integer.valueOf(Integer.toBinaryString(k))*7;
			if(x<0) break;
			for(int i = arr.size() - 1;i>=0;i--){
				// System.out.println(arr);
				if(x%arr.get(i) == 0){
					if(isH(Integer.toBinaryString(x))) res.add(arr.get(i));
					arr.remove(i);
				}
			}
			k+=1;
		}
		System.out.println(res);
	}
	public static boolean isH(String str){
		int i = 0;
		int j = str.length()-1;
		while(i<j){
			if(str.charAt(i) != str.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
}