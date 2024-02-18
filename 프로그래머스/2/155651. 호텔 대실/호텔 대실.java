import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int len = book_time.length;
        
        int[][] convert = new int[len][2];
        for(int i = 0; i < len; i++) {
            String[] time = book_time[i];
            
            String[] start = time[0].split(":");
            String[] end = time[1].split(":");
            
            convert[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            convert[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        }
        
        Arrays.sort(convert, (a,b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
            
        PriorityQueue<Integer> pq = new PriorityQueue<>(); 
        pq.offer(convert[0][1]);
        for(int i = 1; i < len; i++) {
            int[] cur = convert[i];
            
            int peek = pq.peek();
            
            if(peek+10 <= cur[0]) {
                pq.poll();
                pq.offer(cur[1]);
            }else {
                pq.offer(cur[1]);
            }
        }
        
        
        return pq.size();
    }
}