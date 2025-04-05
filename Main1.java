

import java.util.*;


public class Main{

	public static void main(String[] args){
		Scanner input=new Scanner(System.in);


		int n=input.nextInt();
		
		ArrayList<Long> p=new ArrayList();
		
		for(int i=1;i<=n;i++)
			p.add(input.nextLong());
		
		
		long minLoss=Integer.MAX_VALUE;
		
		ArrayList<Long> p2=(ArrayList<Long>)p.clone();
		
		Collections.sort(p2);

		
		for(int i=n-1;i>0;i--){
			long a=p2.get(i);
			long b=p2.get(i-1);
			if(a-b<minLoss && p.indexOf(a)<p.indexOf(b))
				minLoss=a-b;
		}
		
		System.out.println(minLoss);
			
	}
}
