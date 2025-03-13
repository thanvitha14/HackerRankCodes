import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Permutation {
	private static HashMap cache=new HashMap<ArrayList<Integer>, Boolean>();

	private static boolean isSorted(ArrayList<Integer> list){
		int l=list.size();
		for(int i=0;i<l-1;i++){
			if(list.get(i)>list.get(i+1))return false;
		}
		return true;
	}

	
	
	private static boolean isWinning(ArrayList<Integer> list){
		if(cache.containsKey(list)){
			return (boolean) cache.get(list);
		}
		int l=list.size();
		int val;
		for(int i=0;i<l;i++){
			val=list.get(i);
			list.remove(i);
			if(isSorted(list)){
				list.add(i, val);
				cache.put(list,Boolean.TRUE);
				return true;
			}
			if(!isWinning(list)){
				list.add(i,val);
				cache.put(list,Boolean.TRUE);
				return true;
			}
			list.add(i,val);
		}
		cache.put(list,Boolean.FALSE);
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt(),N;
		ArrayList<Integer> list;
		ArrayList<String> result=new ArrayList<String>();
		for(int t=0;t<T;t++){
			N=sc.nextInt();
			sc.nextLine();
			list=new ArrayList<Integer>();
			for(int i=0;i<N;i++){
				list.add(sc.nextInt());
			}
			if(isWinning(list)){
				result.add("Alice");
			}else {
				result.add("Bob");
			}
		}
		for(String s:result){
			System.out.println(s);
		}
	}
}
