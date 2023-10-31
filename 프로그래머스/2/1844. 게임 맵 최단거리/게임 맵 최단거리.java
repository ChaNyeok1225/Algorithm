import java.util.*;

class Solution {
    public int solution(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] p = q.poll();
            
            if(p[0] == n-1 && p[1] == m-1)
                return map[p[0]][p[1]];
            
            if(p[0] + 1 < n && map[p[0]+1][p[1]] == 1) {
                map[p[0]+1][p[1]] = map[p[0]][p[1]] + 1;
                q.offer(new int[] {p[0] + 1, p[1]});
            }   
            
            if(p[0] - 1 >= 0 && map[p[0]-1][p[1]] == 1) {
                map[p[0]-1][p[1]] = map[p[0]][p[1]] + 1;
                q.offer(new int[] {p[0] - 1, p[1]});
            } 
            
            if(p[1] + 1 < m && map[p[0]][p[1]+1] == 1) {
                map[p[0]][p[1]+1] = map[p[0]][p[1]] + 1;
                q.offer(new int[] {p[0], p[1]+1});
            }  
            
            if(p[1] - 1 >= 0 && map[p[0]][p[1]-1] == 1) {
                map[p[0]][p[1]-1] = map[p[0]][p[1]] + 1;
                q.offer(new int[] {p[0], p[1]-1});
            }
        }
        
        
        return -1;
    }
}