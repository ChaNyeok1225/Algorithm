import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : B)
            map.put(num, map.getOrDefault(num, 0) + 1);
        
        Map.Entry<Integer, Integer> entry;
        for(int num : A) {
            entry = map.higherEntry(num);
            if(entry != null) {
                answer++;
                if(entry.getValue() != 1) {
                    map.put(entry.getKey(), entry.getValue() - 1);
                } else {
                    map.remove(entry.getKey());
                }
            }
        }
        
        return answer;
    }
}