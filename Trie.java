import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class TrieNode{
    int count = 0;
    TrieNode[] trieNode = new TrieNode[26];
}


class Trie{
    TrieNode contacts = new TrieNode();
    
    public void add(String contact){
        
        TrieNode temp = contacts;
        temp.count++;
        
        for(char c : contact.toCharArray()){
            
            int index = c - 'a';
            if(temp.trieNode[index] != null){
                temp = temp.trieNode[index];
            }
            else{
                temp.trieNode[index] = new TrieNode();
                temp = temp.trieNode[index];
            }
            temp.count++; 
        }
        
    }
    
    public int find(String contact){
        
        TrieNode temp = contacts;
        
        for(char c : contact.toCharArray()){
            
            int index = c -'a';
            if(temp.trieNode[index]!=null){
                temp = temp.trieNode[index];
            }
            else{
                return 0;
            }
            
        }
        return temp.count;
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int numContacts;
        Scanner in = new Scanner(System.in);
        int numOperations = in.nextInt();
        
        Trie trie = new Trie();
        
        for(int i = 0; i <= numOperations; i++){
            String op = in.nextLine();
            
            String spl[] = op.split(" ");
            
            //System.out.println("Input:"+op);
            if(spl[0].equals("add")){
                //System.out.println("Adding"+spl[1]);
                trie.add(spl[1]);
            }
            if(spl[0].equals("find")){
                //System.out.println("finding"+spl[1]);
                numContacts = trie.find(spl[1]);
                System.out.println(numContacts);
            }
        }
    }
}

