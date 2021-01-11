import java.util.*;
class Solution{
	public static void main(String[] args) {
		helper(10);
		
	}
	public static double seriesConnection(double preValue,double one){
		double res = 0.0;
		res += preValue;
		return res+one;
	}
	public static double parallelConnection(double preValue,double one){
		double res = 0.0;
		res+=1/preValue;
		res+= 1/1.0;
		return 1/res;
	}
	public static void helper(int n){
		ArrayList<Double> possibleValues = new ArrayList<>();
		possibleValues.add(1.0);
		for(int i = 1;i<n;i++){
			ArrayList<Double> newValues = new ArrayList<>();
			for(double preValue:possibleValues){
				newValues.add(seriesConnection(preValue,1.0));
				newValues.add(parallelConnection(preValue,1.0));
			}
			for(double t:newValues) possibleValues.add(t);
		}
		double res = 0.0;
		double goldenValue = 1.6180339887;
		double minDistance = goldenValue;
		for(double value:possibleValues){
			if(Math.abs(goldenValue - value)<minDistance){
				minDistance = Math.abs(goldenValue - value);
				res = value;
			}
		}
		System.out.println("最接近黄金分割的数字为:"+res);
		System.out.println(String.format("%.10f",res));


	}
}