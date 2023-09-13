import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        boolean[] vis = new boolean[words.length];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < words.length; i++) {
            if(vis[i]) continue;
            int diff = 0;

            for(int j = 0; j < words[i].length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j))
                    diff++;     
            }

            if(diff == 1) {
                vis[i] = true;
                q.offer(new int []{i,1});
            } 
        }
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            if(words[cur[0]].equals(target)) {
                answer = cur[1];
                break;
            }
            
            for(int i = 0; i < words.length; i++) {
                if(vis[i]) continue;
                int diff = 0;

                for(int j = 0; j < words[i].length(); j++) {
                    if(words[cur[0]].charAt(j) != words[i].charAt(j))
                        diff++;     
                }

                if(diff == 1) {
                    vis[i] = true;
                    q.offer(new int[] {i, cur[1]+1});
                } 
            }
        }
        
        
        
        return answer;
    }
    

    
}