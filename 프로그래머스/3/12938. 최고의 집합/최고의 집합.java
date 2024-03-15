import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s) {
            return new int[] {-1};
        }
        
        int left = 1, right = s;
        int mid = 0, ans = 1;
        while(left <= right) {
            mid = left + (right - left) /2;
            
            int cnt = s / mid;
            
            if(cnt >= n) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        
        Arrays.fill(answer, ans);
        
        int idx = n-1;
        int ex = s - ans * n;
        
        while(ex-- != 0) {
            answer[idx]++;
            idx--;
            if(idx == -1)
                idx = n-1;
        }
        
        return answer;
    }
}