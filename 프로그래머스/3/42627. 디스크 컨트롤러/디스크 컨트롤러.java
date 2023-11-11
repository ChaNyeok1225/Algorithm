import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> {
            return a[1]-b[1];
        });
        
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        int time = 0;
        int idx = 0;
         while(idx < len || !q.isEmpty()) {
            
            while(idx < len && time >= jobs[idx][0]) {
                q.offer(new int[] {jobs[idx][0],jobs[idx][1]});
                idx++;
            }
            
            if(!q.isEmpty()){
                int[] cur = q.poll();
                time += cur[1];
                answer += time - cur[0];
            } else {
                time++;
            }
            
        }
        
        answer /= len;

        return answer;
    }
}