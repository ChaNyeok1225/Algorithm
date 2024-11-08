import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int n = cookie.length;
        
        int l, r, ltotal, rtotal;
        for(int m = 0; m < n - 1; m++) {
            l = m;
            r = m + 1;
            ltotal = cookie[m];
            rtotal = cookie[m+1];
           
            while(true) {
                if(ltotal == rtotal) {
                    answer = answer > ltotal ? answer : ltotal;
                }
                
                if(ltotal <= rtotal) {
                    l--;
                    if(l < 0)
                        break;
                    ltotal += cookie[l];
                } else {
                    r++;
                    if(r >= n)
                        break;
                    rtotal += cookie[r];
                }
            }
        }
        
        
        return answer;
    }
}