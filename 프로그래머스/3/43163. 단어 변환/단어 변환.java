import java.util.*;

class Solution {
    
    static class Ele {
        String str;
        int dist;
        
        Ele(String s, int d) {
            str = s;
            dist = d;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] vis = new boolean[words.length];
        
        Queue<Ele> q = new ArrayDeque<>();
        q.offer(new Ele(begin, 0));
        
        while(!q.isEmpty()) {
            Ele e = q.poll();
            if(e.str.equals(target)) {
                answer = e.dist;
                break;
            }
            
            char[] c = e.str.toCharArray();
            
            for(int i = 0; i < words.length; i++) {
                if(vis[i]) continue;
                
                char[] nxt = words[i].toCharArray();
                
                int cnt = 0;
                for(int j = 0; j < c.length; j++) {
                    if(c[j] != nxt[j])
                        cnt++;
                    if(cnt > 1)
                        break;
                }
                
                if(cnt == 1) {
                    vis[i] = true;
                    q.offer(new Ele(words[i], e.dist + 1));
                }
            }
        }
        return answer;
    }
    
}