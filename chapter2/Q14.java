import java.util.*;
class Solution{
	static int maxLen = Integer.MIN_VALUE;
	static HashSet<String> set = new HashSet<>();
	static LinkedList<String> finalPath;
	public static void main(String[] args) {
		String[] countries = new String[]{"Brazil", "Croatia", "Mexico", "Cameroon","Spain", "Netherlands", "Chile", "Australia","Colombia", "Greece", "Cote d'Ivoire", "Japan","Uruguay", "Costa Rica", "England", "Italy","Switzerland", "Ecuador", "France", "Honduras","Argentina", "Bosnia and Herzegovina", "Iran","Nigeria", "Germany", "Portugal", "Ghana","USA", "Belgium", "Algeria", "Russia","Korea Republic"};
		// 将字符串全部变为小写
		for(int i =0;i<countries.length;i++) countries[i] = countries[i].toLowerCase();
		for(String country:countries) System.out.println(country);
		// 可以从任何一个开始
		LinkedList<String> path = new LinkedList<>();
		for(String country:countries) helper(countries,country,1,set,path);
		System.out.println(maxLen);
		System.out.println(finalPath);
	}
	public static void helper(String[] countries,String prev,int depth,HashSet<String> used,LinkedList<String> path){
		//将prev country 装进path中，并且装进已用的国家名称的集合内
		System.out.println(depth + "++++++++++++++++++"+path);
		used.add(prev);
		path.add(prev);
		// 如果当前的国家名称接龙的长度大于现在已经记录的全局的最长的成语接龙的长度，则更新最终记录的path，以及更新全局最长的长度
		if(depth > maxLen){
			finalPath = new LinkedList<>(path);
			maxLen = depth;
		}
		System.out.print(prev + " --- ");
		// 获得prev country的第一个末尾字母
		char prevLastChar = prev.charAt(prev.length()-1);
		// 获取所有可用的国家的名字,用一个队列进行存储
		Queue<String> queue = new LinkedList<>();
		for(String str:countries) if(str.length()>0 && !used.contains(str) && str.charAt(0) == prevLastChar) queue.offer(str);
		System.out.println(queue);
		// 然后对队列中的元素进行接龙
		while(!queue.isEmpty()) {
			String tmp = queue.peek();
			helper(countries,queue.poll(),depth+1,used,path);
			// 从已经用过的used的国家的名称集合中删除掉当前遍历的国家名称
			used.remove(tmp);
			path.remove(tmp);
		}
		used.remove(prev);
		path.remove(prev);
		



	}
}