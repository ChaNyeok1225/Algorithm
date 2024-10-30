import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int n = gems.length;
        HashMap<String, Integer> index = new HashMap<>();
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            Integer tmp = index.putIfAbsent(gems[i], idx);
            if(tmp == null)
                idx++;
        }

        int total = index.size();
        if(total == 1) {
            return new int[] {1,1};
        }
        int[] count = new int[total];
        int col = 0, max = Integer.MAX_VALUE;
        
        idx = 0;
        int cur = index.get(gems[0]);
        count[cur]++;
        col++;
        
        for(int i = 1; i < n; i++) {
            cur = index.get(gems[i]);
            
            count[cur]++;
            if(count[cur] == 1) {
                col++;
            }
            
            // System.out.println("i : " + i + " idx : " + idx + " , col : " + col + " >> " + Arrays.toString(count));
            
            while(count[index.get(gems[idx])] > 1) {
                count[index.get(gems[idx++])]--;
            }
            
            if(col == total && max > i - idx) {
                max = i - idx;
                answer[0] = idx + 1;
                answer[1] = i + 1;
            }
            
        }
        
        
        return answer;
    }
}