import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            sb.append(n%k);    
            n /= k;
        }
        
        String[] str = sb.reverse().toString().split("0+");
        for(int i = 0; i < str.length; i++) {
            long val = Long.parseLong(str[i]);
            if(prime(val))
                answer++;
        }
        
        return answer;
    }
    
    static boolean prime(long number) {
        if(number == 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0)
                return false;
        }
        return true;
    }
}