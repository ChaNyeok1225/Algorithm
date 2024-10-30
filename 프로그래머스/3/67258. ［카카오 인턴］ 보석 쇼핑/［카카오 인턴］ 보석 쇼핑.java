import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        int[] Igems = new int[n];
        
        Map<String, Integer> map = new HashMap<>();
        int total = 0;
        for(int i = 0; i < n; i++) {
            Integer index = map.putIfAbsent(gems[i], total);
            if(index == null)
                index = total++;
            Igems[i] = index;
        }
        
        int[] count = new int[total];
        int jewelCase = 0, idx = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            while(idx < n && jewelCase != total) 
                jewelCase += count[Igems[idx++]]++ == 0 ? 1 : 0;
            if(idx - i < min && jewelCase == total) {
                answer[0] = i + 1; answer[1] = idx;
                min = idx - i;    
            }
            jewelCase -= --count[Igems[i]] == 0 ? 1 : 0;
        }
        
        return answer;
    }
}