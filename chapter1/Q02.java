import javax.script.*;
import java.util.*;
class Solution{
	public static void main(String[] args) throws ScriptException{
		calc();
	}
	public static String calc() throws ScriptException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("javascript");
		String[] op = new String[]{"+","-","*","/",""};
		int n = op.length;
		for(int m = 1000;m<=10000;m++){
			String s = String.valueOf(m);
			for(int i = 0;i<n;i++){
				for(int j = 0;j<n;j++){
					for(int k = 0;k<n;k++){
						// 这个地方使用了一个小的技巧,倒序进行计算，那么就可以直接和原字符串比较，而不用反转原字符串
						String res = s.charAt(3) + op[i] + s.charAt(2) + op[j] + s.charAt(1) + op[k] + s.charAt(0);
						// >4 表示一定要插入一个运算符
						if(res.length()>4) if ((int)se.eval(res) == m) return res;
					}
				}
			}
		}
		return "";
	}

}