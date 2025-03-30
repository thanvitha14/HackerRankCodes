



import static java.lang.Math.*;
import static java.util.Arrays.*;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
    StreamTokenizer in;
    PrintWriter out;
    //deb////////////////////////////////////////////////

    public static void deb(String n, Object n1) {
        System.out.println(n + " is : " + n1);
    }

    public static void deb(int[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(long[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(String[] A) {

        for (Object oo : A) {
            System.out.print(oo + " ");
        }
        System.out.println("");
    }

    public static void deb(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(long[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }

    public static void deb(String[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (Object oo : A[i]) {
                System.out.print(oo + " ");
            }
            System.out.println("");
        }

    }
    /////////////////////////////////////////////////////////////

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    class Pair<X, Y> {

        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        public void setX(X x) {
            this.x = x;
        }

        public void setY(Y y) {
            this.y = y;
        }
    }

    boolean inR(int x, int y) {
        return (x >= 0) && (x < nn) && (y >= 0) && (y < nn);
    }
    static int nn;

    void run() throws IOException {
        //  in = new StreamTokenizer(new BufferedReader(new FileReader("circles.in")));
        //  out = new PrintWriter(new FileWriter("circles.out"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }
static int[] parent; // n+1
 static int count;
private void init() {
 for (int i = 1; i < parent.length; i++) {
            parent[i]=i;
        }

}

private void union(int st, int en) {
       int ss=par(st),ee=par(en);
       if(ss!=ee){
       parent[ss]=ee;
       count--;
       }
       
    }

    private int par(int th) {
        if(parent[th]==th)return th;
        else {
            int k=par(parent[th]);
            parent[th]=k;
            return k;}
    }  
    void solve() throws IOException {
        //   BufferedReader re= new BufferedReader(new FileReader("C:\\Users\\ASELA\\Desktop\\A.in"));
        //      BufferedReader re = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
      parent= new int[n+1];
      init();
      int l=nextInt();
        for (int i = 0; i < l; i++) {
            int a=nextInt(),b=nextInt();
            union(a+1,b+1);
        }
        long[] A= new long[n+1];
        for (int i = 1; i < n+1; i++) {
            A[par(i)]++;
        }
        
        long ans=(long)n*(long)n;
        for (int i = 1; i < n+1; i++) {
            ans-=A[i]*A[i];
        }
      ans/=2;
        System.out.println(ans);
      
    }
}
