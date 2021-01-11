class Solution{
	/**
	
	*/
	public static void main(String[] args) {
		System.out.println(setTap(20));
		System.out.println(plugBoard(n));
		
	}
	/**
	param n : 代表剩余的等待创造的插口数目,初始值为20，代表需要创造出20个插口
	*/
	public static int setTap(int n){
		// 一个插口就只有一种插线方式
		if(n == 1) return 1;
		// 记录当前n个插口时的方案数目
		int res = 0;
		// 2 tap 两个插槽的插板
		// i 代表覆盖的的插口数目，i<=n/2 的原因是最多有i==n/2 就可以使得创造出n个插槽 因为n/2 * 2 == n
		for(int i = 1;i<=n/2;i++){
			// 如果i正好是当前n的1/2 那么返回覆盖i个插槽口的方案数目*(可能插入的插槽数目方案) +1的原因是最后一个插板会多一个插槽没有使用
			if(n - i == i) res += (setTap(i) * (setTap(i) + 1))/2;
			// 如果i不是n的1/2 返回覆盖i个插槽的方案数目以及覆盖n-i个插槽的方案数目
			else res+=setTap(n - i) * setTap(i);
		}
		// 3 tap 三个插槽的插板
		// i 代表三插槽插板覆盖的插口数目 i<=n/3 的原因是最多有i==n/3 就可以使得创造出n个插槽 因为n/3 * 3 == n
		for(int i = 1;i<=n/3;i++){
			// j 代表二插槽插板覆盖的插口数目 j从i起始的原因是因为 ？？ j<=(n-i)/2 的原因是因为 (n-i)/2 *2 = n-i , 而n-i就是经过i个三插槽插板覆盖的插槽数目剩余的插槽数目
			for(int j = i;j<=(n-i)/2;j++){
				if((n-(i+j) == i) && (i==j)) res +=setTap(i)*(setTap(i)+1)*(setTap(i)+2)/6;
				else if(n-(i+j) == i) res += setTap(i)*(setTap(i)+1)*setTap(j)/2;
				else if(i==j) res += setTap(n-(i+j))*setTap(i)*(setTap(i)+1)/2;
				else if(n-(i+j) == j) res+=setTap(j) * (setTap(j)+1)*setTap(i)/2;
				else res+=setTap(n-(i+j))*setTap(j)*setTap(i);
			}
		}
		return res;
	}
	static int n = 20;
	static int[] memo;

    public static int plugBoard(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    public static int dfs(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] == 0) {
            for (int i = 1; i <= n / 2; ++i) {
                int j = n - i;
                if (i == j) {
                    memo[n] += (dfs(i) + 1) * dfs(i) / 2;
                } else {
                    memo[n] += dfs(i) * dfs(j);
                }
            }
            for (int i = 1; i <= n / 3; ++i) {
                for (int j = i; j <= (n - i) / 2; ++j) {
                    int k = n - i - j;
                    if (i == j && j == k) {
                        memo[n] += (dfs(i) + 2) * (dfs(i) + 1) * dfs(i) / 6;
                    } else if (i == j) {
                        memo[n] += (dfs(i) + 1) * dfs(i) / 2 * dfs(k);
                    } else if (j == k) {
                        memo[n] += dfs(i) * (dfs(j) + 1) * dfs(j) / 2;
                    } else {
                        memo[n] += dfs(i) * dfs(j) * dfs(k);
                    }
                }
            }
        }
        return memo[n];
    }

}