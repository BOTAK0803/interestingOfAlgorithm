class Soultion{
	public static void main(String[] args) {
		int[] area=new int[]{0,11000,8000,400,800,900,1800,1000,7000,100,300};
		int[] people = new int[]{0,40,30,24,20,14,16,15,40,10,12};
		System.out.println(maxValue1(150,10,people,area));
		System.out.println(maxValue2(150,10,people,area));
	}
	/**
	典型的背包问题
	area相当于value价值
	people相当于v 也就是背包的体积
	*/
	public static int maxValue1(int V,int N,int[] v,int[] w){
		int[][] dp = new int[N+1][V+1];
		for(int i = 1;i<=N;i++){
			for(int j = 1;j<=V;j++){
				if(j>=v[i]) dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[i]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		return dp[N][V];
	}
	public static int maxValue2(int V,int N,int[] v,int[] w){
		int[] dp = new int[V+1];
		for(int i = 1;i<N;i++) for(int j = V;j>=v[i];j--) dp[j] = Math.max(dp[j],dp[j-v[i]]+w[i]);
		return dp[V];
	}
}