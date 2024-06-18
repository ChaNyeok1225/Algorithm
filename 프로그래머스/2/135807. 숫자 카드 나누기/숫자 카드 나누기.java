import java.util.*;

class Solution {
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int len = arrayA.length;
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i = 1; i < len; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean flagA = true, flagB = true;
        for(int i = 0; i < len; i++) {
            
            if(arrayB[i] % gcdA == 0)
                flagA = false;
            
            if(arrayA[i] % gcdB == 0)
                flagB = false;
            
        }
        
        if(flagA)
            answer = answer > gcdA ? answer : gcdA;
        if(flagB)
            answer = answer > gcdB ? answer : gcdB;
        
        return answer;
    }
    
    int gcd(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
    
    
}