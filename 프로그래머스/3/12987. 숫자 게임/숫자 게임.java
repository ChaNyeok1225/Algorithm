import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        boolean[] chk = new boolean[n];
        Arrays.sort(B);
        
        int start = 0, end = n - 1, mid;
        for(int i = 0; i < n; i++) {
            int value = A[i];
            int idx = n;
            start = 0;
            end = n - 1;
            while(start <= end) {
                mid = start + (end - start) / 2;
                
                if(B[mid] > value) {
                    end = mid - 1;
                    idx = mid;
                } else {
                    start = mid + 1;
                }
            }
            // System.out.println("idx : " + idx);
            for(int j = idx; j < n; j++) {
                if(!chk[j]) {
                    chk[j] = true;
                    answer++;
                    // System.out.println("select : " + j);
                    break; 
                }
            }
            
        }
        
        return answer;
    }
}