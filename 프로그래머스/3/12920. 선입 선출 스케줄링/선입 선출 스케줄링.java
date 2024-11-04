import java.util.*;

class Solution {
    
    class Core {
        int index;
        int time;
        
        Core(int i, int t) {
            index = i;
            time = t;
        }
    }
    
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        if(cores.length >= n) 
            return n;

        int l = 0, r = 50_000_000, mid;
        int jobs;
        int save = 0, time = 0;
        while(l <= r) {
            mid = l + (r - l) / 2;
            jobs = 0;
            
            for(int i = 0; i < cores.length; i++) {
                jobs += (mid / cores[i]) + 1;
            }
            
            if(jobs > (n - 1)) {
                r = mid - 1;
            } else {
                l = mid + 1;
                save = jobs;
                time = mid;
            }
        }

        PriorityQueue<Core> pq = new PriorityQueue<>((a, b) -> {
            return a.time == b.time ? a.index - b.index : a.time - b.time;
        });
        
        int min = Integer.MAX_VALUE, value;
        for(int i = 0; i < cores.length; i++) {
            value = cores[i] - (time % cores[i]);
            pq.offer(new Core(i, value == 0 ? cores[i] : value));
        }
        
        Core core;
        for(int i = save + 1; i < n; i++) {
            core = pq.poll();
            core.time += cores[core.index];
            pq.offer(core);
        }
        
        return pq.peek().index + 1;
    }

}