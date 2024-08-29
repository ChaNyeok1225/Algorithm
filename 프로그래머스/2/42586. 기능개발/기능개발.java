import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        
        int idx,cnt, time;
        idx = cnt = time = 0;
        while(idx < n) {
            if(progresses[idx] + time * speeds[idx] >= 100) {
                idx++;
                cnt++;
            } else {
                if(cnt != 0) {
                    answer.add(cnt);
                    cnt=0;
                }
                time++;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}