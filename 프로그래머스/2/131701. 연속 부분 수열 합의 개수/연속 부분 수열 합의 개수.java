import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < len; i++) {
            int sum = 0;
            for(int j = 0; j < len; j++) {
                sum+=elements[(i+j) % len];
                set.add(sum);
            }
        }        
        
        return set.size();
    }
}