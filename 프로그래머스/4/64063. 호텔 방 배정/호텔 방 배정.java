import java.util.*;

class Solution {
    
    static HashMap<Long, Long> map = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];
        
        long number;
        for(int i = 0; i < n; i++) {
            number = room_number[i];
            answer[i] = find(number) - 1;
        }
        
        return answer;
    }
    
    long find(long num) {
        Long value = map.get(num);
        if(value == null) {
            map.put(num, num + 1);
            return num + 1;
        } 
        
        long ret = find(value);
        map.put(num, ret);
        return ret;
    }
    
}