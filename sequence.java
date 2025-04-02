


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws Exception{
BufferedReader inR = new BufferedReader(new InputStreamReader(System.in));
        String s = inR.readLine().trim();
        long MOD = 1000000000L+7;
        long[] cnt = new long[26];
        long[][] sumK = new long[26][26];
        long[][] delta = new long[26][26];
        long ans = 0;
        for(int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for(int j=0; j<26; j++) {
                ans = (ans + delta[c][j]) % MOD;
            }
            
            for(int j=0; j<26; j++) {
                delta[j][c] = (delta[j][c] + sumK[j][c]) % MOD;
                sumK[j][c] = (sumK[j][c] + cnt[j]) % MOD;
            }
            
            cnt[c] += 1;
        }
        System.out.println(ans % MOD);
        inR.close();
    }
}
