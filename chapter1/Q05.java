class Solution{
	public static void main(String[] args) {
		System.out.println(numOfCoin(1000,0,new int[]{10,50,100,500},0));
	}
	/**
	num 需要兑换的钱的数目
	cur 当前兑换的钱的数目
	coin 可以兑换的零钱的面值数组
	n 当前兑换的coin的数目
	*/
	public static int numOfCoin(int num,int cur,int[] coin,int n){
		if(cur > num || n > 15) return 0;
		if(cur == num) return 1;
		for(int i = 0;i<coin.length;i++) return numOfCoin(num,cur+coin[i],coin,n+1)+1;
		return 0;
	}
}