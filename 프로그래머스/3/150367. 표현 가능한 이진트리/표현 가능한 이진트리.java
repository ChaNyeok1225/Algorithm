import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
       
        for(int i = 0; i < n; i++) {
            long number = numbers[i];
            int zeroCnt = 0;
            boolean flag = false;
            int bitSize = 0;
            while(number > 0) {
                bitSize++;
                if(number % 2 == 1)
                    zeroCnt++;
                number /= 2;
            }
            
            // System.out.println("value " + numbers[i] + " : " + bitSize + " & " + zeroCnt);
            
            int binSize = 1;
            int step = 1;
            for(int j = 1; ; j++) {
                step *= 2;
                binSize = step - 1;
                
                if(binSize >= bitSize * 3) 
                    break;
                
                
                Queue<int[]>q = new ArrayDeque<>();
                q.offer(new int[] {binSize / 2, step/2});
                
                int cnt = 0;
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    // System.out.println(cur[0] + " , " + cur[1]);
                    // System.out.println((numbers[i] & (1L<<cur[0])));
                    if( (numbers[i] & (1L<<cur[0])) != 0) {
                        cnt++;
                        if(cur[1] > 1) {
                            int nxt = cur[1] / 2;
                            q.offer(new int[] {cur[0]+nxt, nxt});
                            q.offer(new int[] {cur[0]-nxt, nxt});
                        }
                        
                    }
                }
                // System.out.println("binSize : " + binSize + " = " + cnt);
                if(zeroCnt == cnt) {
                    flag = true;
                    break;
                }
            }
            
            answer[i] = flag ? 1 : 0;
            
        }
        
        return answer;
    }
    
}