import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Hackerland {

    static int hackerlandRadioTransmitters(int[] x, int k, int n) {
        // Complete this function
        Arrays.sort(x);
        int numOfTransmitters = 0;
        int i = 0;

        while (i < n ) {
            numOfTransmitters++;
            int loc = x[i] + k;
            
            while (i < n && x[i] <= loc) i++;
            loc = x[--i] + k; 
            while (i < n && x[i] <= loc) i++;
        }
        
        return numOfTransmitters;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k, n);
        System.out.println(result);
        in.close();
    }
}

