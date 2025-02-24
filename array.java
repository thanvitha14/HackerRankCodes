import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        
        for (int i = 0; i < num; i++) {
            String count = br.readLine();
            String[] ns = br.readLine().split(" ");
            sansaXor(ns, Integer.valueOf(count));
        }

    }
    
    public static void sansaXor(String[] strs, int count){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        long result = 0;
        for(int i = 0; i < count; i++){
            int numCount = (i + 1)*(count - i);
            int tmp = Integer.valueOf(strs[i]);
            if(map.containsKey(tmp)){
                map.put(tmp, numCount+map.get(tmp));
            }else{
                map.put(tmp, numCount);
            }
        }
        
        for(int k: map.keySet()){
            int value = map.get(k);
            if(value%2!=0){
                result = result^k;
            }
        }
        
        System.out.println(result);
    }
}

