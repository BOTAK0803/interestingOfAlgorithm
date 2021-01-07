class Solution{
	static int n = 10;
	static int steps = 4;
	public static void main(String[] args) {
		System.out.println(move(0,10));
		System.out.println(move2(0,10));
		for(int i = 0;i<record.length;i++){
			for(int j = 0;j<record[0].length;j++){
				System.out.print(record[i][j] + "  ");
			}
			System.out.println();
		}
	}
	// 直接递归进行操作
	public static int move(int a,int b){
		if(a>b) return 0;
		if(a==b) return 1;
		int res = 0;
		for(int i = 1;i<=steps;i++) for(int j = 1;j<=steps;j++) res+= move(a+i,b-j);
		return res;
	}
	// 备忘录算法
	static int[][] record = new int[n+1][n+1];
	public static int move2(int a,int b){
		// 越界的处理
		if(a>n||b<0) return 0;
		// 如果备忘录已经记录了，就直接返回
		if(record[a][b] != 0) return record[a][b];
		// 如果向上爬楼梯的人已经超过了向下下楼梯的人，那么之后无论如何都不能再次相遇直接返回
		if(a>b) {
			record[a][b] = 0;
			return record[a][b];
		}
		// 如果两者相遇了，那么更改备忘录
		if(a==b){
			record[a][b] = 1;
			return record[a][b];
		}
		// 没有相遇的情况下，记录
		int res = 0;
		// i表示向上上楼的人一次走的阶梯数目，j表示向下下楼的人一次走的阶梯的数目
		for(int i = 1;i<=steps;i++) for(int j = 1;j<=steps;j++) res+=move2(a+i,b-j);
		record[a][b] = res;
		return record[a][b]; 

	}
	/**
	动态规划：
	状态定义:dp[i][j] : 表示向上爬的人爬i个台阶，向下下的人下j个台阶时可能在同一个台阶的状态数目
	状态转移方程：dp[i][j] = 
	初始状态定义:
	*/
	public static int move3(int a,int b){
		int[][] dp = new int[n+1][n+1];
		return dp[n][n];
	}
}