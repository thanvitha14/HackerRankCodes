
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class index{

	public static void main(String[] args) throws Exception {
		new index().run();
	}
	
	StreamTokenizer st;
	
	private void run() throws Exception {
		st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		int n = nextInt();
		int m = nextInt();
		long[] a = new long[n + 1];
		for (int i = 0; i < m; i++) {
			int l = nextInt() - 1;
			int r = nextInt();
			int v = nextInt();
			a[l] += v;
			a[r] -= v;
		}
		long cur = 0;
		long max = 0;
		for (int i = 0; i < n; i++) {
			cur += a[i];
			max = Math.max(max, cur);
		}
		System.out.println(max);
	}

	private int nextInt() throws Exception {
		st.nextToken();
		return (int) st.nval;
	}
}


