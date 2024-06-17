import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int len = weights.length;
        
        HashMap<Integer, Integer> count = new HashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        int weight;
        for(int i = 0; i < len; i++) {
            count.put(weights[i], count.getOrDefault(weights[i], 0) + 1);
            for(int j = 2; j < 5; j++) {
                weight = weights[i] * j;
                tm.put(weight, tm.getOrDefault(weight, 0) + 1);
            }
        }
        Arrays.sort(weights);
        
        int cur, cnt, target;
        for(int i = 0; i < len; i++) {
            cur = weights[i];
            if(i > 0 && cur == weights[i-1])
                continue;
            cnt = count.get(cur);
            
            answer += (long)cnt * (cnt - 1) / 2;
            
            for(int j = 2; j < 5; j++) {
                weight = weights[i] * j;
                target = tm.get(weight);
                answer += (long)cnt * (target - cnt);
                tm.put(weight, target - cnt);
            }
        }
        
        
        return answer;
    }
}