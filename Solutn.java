import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solutn {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len =  s.length();
        int n = in.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        int i=0;
        while(i<len){
             int j=i;
             int sum =0;
             while( j<len && s.charAt(i)==s.charAt(j) ){
                 sum += (s.charAt(i)-'a') +1;
                 set.add(sum);
                 j++;
             }
            i = j;
        }
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if (set.contains(x)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}

