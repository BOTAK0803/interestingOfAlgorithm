class Solution{
	public static void main(String[] args) {
		System.out.println(helper());
		
	}
	public static int helper(){
		int n = 16;
		int[] dp = new int[n/2+1];
		dp[0] = 1;
		for(int i = 1;i<=n/2;i++){
			dp[i] = 0;
			for(int j = 0;j<i;j++){
				dp[i] += dp[j]*dp[i-j-1];
			}
		}
		return dp[n/2]; 
	}
}