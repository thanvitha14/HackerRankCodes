

import java.util.Scanner;
public class Solution {
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    new Solution().ss();
  }

  private void ss() {
    int nrt = sc.nextInt();
    for (int i = 0; i < nrt; i++) {
      solve();
    }
  }

  long mat[][][];
  int n;

  private void update(int x, int yy, int zz, long val) {
    while (x <= n) {
      int y = yy;
      while (y <= n) {
        int z = zz;
        while (z <= n) {
          mat[x][y][z] += val;
          z += (z & -z);
        }
        y += (y & -y);
      }
      x += (x & -x);
    }
  }

  private long sum(int x, int yy, int zz) {
    long rez = 0;
    while (x > 0) {
      int y = yy;
      while (y > 0) {
        int z = zz;
        while (z > 0) {
          rez += mat[x][y][z];
          z -= (z & -z);
        }
        y -= (y & -y);
      }
      x -= (x & -x);
    }
    return rez;
  }

  private void solve() {
    n = sc.nextInt();
    int m = sc.nextInt();
    mat = new long[101][101][101];
    long[][][] actual = new long[101][101][101];
    for (int i = 0; i < m; i++) {
      String op = sc.next();
      if (op.equals("UPDATE")) {
        int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        long w = sc.nextLong();
        //        x--; y--; z--;
        update(x, y, z, w - actual[x][y][z]);
        actual[x][y][z] = w;
      } else {
        int x1 = sc.nextInt(), y1 = sc.nextInt(), z1 = sc.nextInt();
        int x2 = sc.nextInt(), y2 = sc.nextInt(), z2 = sc.nextInt();
        //        x1--; y1--; z1--;
        //        x2--; y2--; z2--;
        long v1 = sum(x2,y2,z2)- sum(x1-1,y2,z2)  - sum(x2,y1-1,z2) + sum(x1-1,y1-1,z2);
        long v2 = sum(x2,y2,z1-1) - sum(x1-1,y2,z1-1) - sum(x2,y1-1,z1-1)  + sum(x1-1,y1-1,z1-1);
        System.out.println(v1 - v2);
      }
    }
  }
}
