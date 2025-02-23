import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringBuffer[] map = new StringBuffer[100];
        for(int i = 0; i < 100; i++) {
            map[i] = new StringBuffer();
        }
        for(int i = 0; i < n; i++) {
            StringTokenizer tok = new StringTokenizer(in.readLine());
            int v = Integer.parseInt(tok.nextToken());
            String s = tok.nextToken();
            map[v].append(i < n / 2 ? "-" : s).append(" ");
        }
        for(int i = 0; i < 100; i++) {
            System.out.print(map[i]);
        }
        System.out.println();
    }
}

