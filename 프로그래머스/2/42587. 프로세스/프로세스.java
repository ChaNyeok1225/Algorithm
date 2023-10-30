import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int cnt = 0;
        int size = priorities.length;
        
        int[] sorting = priorities.clone();
        Arrays.sort(sorting);
        
        int idx = 0;
        loop : for(int i = size-1; i >= 0; i--) {
            
            while(true) {
                if(sorting[i] == priorities[idx]) {
                    cnt++;
                    priorities[idx] = 0;             
                    if(idx == location)
                        break loop;
                    break;
                }
                idx = (idx + 1) % size;
            }    
        }
        
        return cnt;
    }
}