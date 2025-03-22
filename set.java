import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Trie{
    
    char c;
    boolean isEndOfString;
    Trie []children;
}

public class set {

    Trie root;
    void input(){
        Scanner sin = new Scanner(System.in);
        int N = sin.nextInt();
        root = new Trie();
        root.children = new Trie[26];                        
        boolean flag = false;
        for(int i = 0; i < N; i++){
            String s = sin.next();
            if(!flag)
                flag = insert(s);
        }
        if(!flag){
           System.out.println("GOOD SET"); 
        }
    }
    
    Trie newNode(char c){
        Trie newNode = new Trie();
        newNode.c = c;
        newNode.isEndOfString = false;
        newNode.children = new Trie[26];
        return newNode;
    }
    boolean insert(String s){
        Trie ptr = root;
        boolean flag = false;
        int i = 0;
        int ctr = 0;
        for(; i < s.length(); i++){
            char c = s.charAt(i);
            int index = (int)c - 97;
            if(ptr.children[index] == null){
                Trie newNode = newNode(c);
                ptr.children[index] = newNode;                
                ptr = ptr.children[index];
            }
            else{
                ctr++;
                ptr = ptr.children[index];
                if(ptr.isEndOfString){
                    flag = true;
                    break;
                }
            }
        }
        if(i == s.length()){
            ptr.isEndOfString = true;    
        }
        if(flag){
            System.out.println("BAD SET");
            System.out.println(s);
        }
        else if(ctr == s.length()){
            System.out.println("BAD SET");
            System.out.println(s); 
            flag = true;
        }
        
        return flag;
    }
    
    public static void main(String[] args) {
        set s = new set();
        s.input();
    }
}


