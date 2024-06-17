import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int a;
        while(n != 0) {
            
            a = n % 3;
            if(a == 0) {
                a = 4;
                n = n / 3 - 1;
            } else {
                n /= 3;
            }
            sb.append(a);
        }
        
        return sb.reverse().toString();
    }
}