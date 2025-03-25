import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        int n = Integer.parseInt(input.nextLine()) ;
        char[][] A = new char[n][n] ;
        for(int i =0; i < n; i++){
            String s = input.nextLine() ;
            A[i] = s.toCharArray() ;
        }
        ArrayDeque<Node> queue = new ArrayDeque<Node>() ;
        String y = input.nextLine() ;
        String[] X = y.split(" ") ;
        int s1 = Integer.parseInt(X[0]) ;
        int s2 = Integer.parseInt(X[1]) ;
        int g1 = Integer.parseInt(X[2]) ;
        int g2 = Integer.parseInt(X[3]) ;
        Node s = new Node(s1,s2,0) ;
        Node g = new Node(g1,g2) ;
        queue.add(s) ;
        boolean[][] bool = new boolean[n][n] ;
        bool[s1][s2] = true ;
        while(!queue.isEmpty()){
            Node x = queue.poll() ;
            if(x.equality(g)){
                System.out.println(x.depth+" ");
                break;
            }
            int a1 = x.a ;
            int b1 = x.b+1 ;
            while(b1 < n && A[a1][b1] != 'X'){
                if(!bool[a1][b1]){
                    Node temp = new Node(a1,b1,x.depth+1) ;
                    bool[a1][b1] =true ;
                    queue.add(temp) ;
                }
                b1++ ;
            }
            b1 = x.b -1 ;
            while(b1 >= 0 && A[a1][b1] != 'X'){
                if(!bool[a1][b1]){
                    Node temp = new Node (a1,b1,x.depth+1) ;
                    bool[a1][b1] =true ;
                    queue.add(temp) ;
                }
                b1-- ;
            }
            a1 = x.a +1 ;
            b1 = x.b ;
            while(a1 < n && A[a1][b1] != 'X'){
                if(!bool[a1][b1]){
                    Node temp = new Node(a1,b1,x.depth+1) ;
                    bool[a1][b1] =true ;
                    queue.add(temp) ;
                }
                a1++ ;
            }
            a1 = x.a -1 ;
            while(a1 >=0 && A[a1][b1] != 'X'){
                if(!bool[a1][b1]){
                    Node temp = new Node(a1,b1,x.depth+1) ;
                    bool[a1][b1] =true ;
                    queue.add(temp) ;
                }
                a1--;
            }
        }
        
       
    }
    
}
class Node{
        int a ;
        int b ;
        int depth ;
        public Node(int a,int b){
            this.a = a ;
            this.b = b ;
        }
        public Node(int a ,int b,int d){
            this.a = a;
            this.b = b;
            this.depth = d;
        }
        
        public boolean equality(Node other){
            if(this.a == other.a && this.b == other.b){
                return true ;
            }else{
                return false ;
            }
        }
    }








