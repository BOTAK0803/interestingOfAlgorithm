import java.util.*;
class Solution{
	public static void main(String[] args) {
		System.out.println(reverseCard());
		System.out.println(reverseCard2());
		
	}
	public static ArrayList<Integer> reverseCard(){
		ArrayList<Integer> res = new ArrayList<>();
		// 模拟卡片 其中false代表背面朝上 true代表正面朝上
		boolean[] cards = new boolean[100];
		// 模拟从第几个开始
		for(int i = 2;i<=cards.length;i++){
			// j代表每隔多少个进行反转
			int j=i-1;
			while(j<cards.length){
				cards[j] = !cards[j];
				j+=i;
			}
		}
		for(int i = 0;i<cards.length;i++) if(cards[i] == false) res.add(i+1);
		return res;

	}
	/**
	这个问题等价于“寻找被翻转次数为偶数的牌”。而翻牌操作的时机则是“翻牌间隔数字是这个数的约数时”，因此也就相当于寻找拥有偶数个“1 以外的约数”的数字。
	只有当牌面数字是平方数的时候约数才是奇数个.
	16 的约数是 "1、2、4、8、16" 这 5 个，也就是奇数个
	12 的约数是“1、2、3、4、6、12”这 6 个
	*/
	public static ArrayList<Integer> reverseCard2(){
		ArrayList<Integer> res = new ArrayList<>();

		for(int i = 1;i<=100;i++){
			double a = Math.sqrt(i);
			int b = (int) a;
			if(a - b == 0)  res.add(i);
		}
		return res;

	}


}