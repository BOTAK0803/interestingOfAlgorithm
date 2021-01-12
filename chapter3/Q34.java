class Solution{
	static int n = 6;
	static int res = 0;
	static int meet = 0;
	public static void main(String[] args) {
		helper(0,0,n,n,0);
		System.out.println(res);
	}
	public static void helper(int x1,int y1,int x2,int y2,int meet){
		// 如果两个人均没有越界，才得以进行下面的相关的比较操作
		if(x1 <= n && y1 <= n && x2 >= 0 && y2 >= 0) {
			if((x1 == n) && (y1 == n) && (meet >=2)) res+=1;
			if(x1 == x2 ) meet+=1;
			if(y1 == y2 ) meet+=1;
			helper(x1+1,y1,x2-1,y2,meet);
			helper(x1+1,y1,x2,y2-1,meet);
			helper(x1,y1+1,x2-1,y2,meet);
			helper(x1,y1+1,x2,y2-1,meet);
		}
	}
}