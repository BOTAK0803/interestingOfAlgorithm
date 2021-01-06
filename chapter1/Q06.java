class Solution{
	public static void main(String[] args) {
		int count = 0;
		for(int i =2;i<=10000;i+=2) if(isLoop(i)) count++;
		System.out.println(count);
		
	}
	public static boolean isLoop(int n){
		int start = n*3+1;
		// 如果计算得到了1或者初始值，就可以结束循环了。
		while(start!=1){
			start = start%2==1?(start*3+1):start/2;
			if(start == n) return true; 
		}
		return false;
	}
}