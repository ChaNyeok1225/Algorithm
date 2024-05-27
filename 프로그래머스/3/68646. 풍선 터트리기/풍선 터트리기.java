import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        int leftMin = Integer.MAX_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i = 0; i < len; i++) {
            ts.add(a[i]);
        }
        
        for(int i = 0; i < len; i++) {
            ts.remove(a[i]);
            
            if(!(a[i] > leftMin && (!ts.isEmpty() && a[i] > ts.first())))
                answer++;
            
            leftMin = leftMin < a[i] ? leftMin : a[i];
        }
        
        return answer;
    }
}