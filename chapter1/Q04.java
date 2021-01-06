class Solution{
	public static void main(String[] args) {
		System.out.println(cutBar(20,3,1));
		System.out.println(cutBar2(20,3));
	}
	/**
	params n : the length of the bar
	params m : the numbers of people
	params cur : the current number of bar
	*/
	public static int cutBar(int n,int m,int cur){
		if(cur >= n) return 0;
		else if(cur < m) return 1 + cutBar(n,m,cur*2);
		else return 1 + cutBar(n,m,cur + m);
	}
	/**
	稍稍改变一下思路会发现，还有另一个方法可以解决问题。逆向思考后，本题题干可以等价为 m 个人黏合 1 厘米的木棒以组成 n 厘米的木棒。
	也就是说，最终使黏合的木棒总长度为 n 厘米就可以了。
	*/
	public static int cutBar2(int n,int m){
		int current = 1;
		int count = 0;
		while(current < n){
			current += current<m?current:m;
			count+=1;
		}
		return count;
	}

}