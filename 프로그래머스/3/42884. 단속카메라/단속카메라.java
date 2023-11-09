import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> {
           if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int idx = 1;
        answer = 1;
        int dis = routes[0][1];
        while(idx < routes.length) {
            if(routes[idx][0] <= dis)
                idx++;
            else {
                answer++;
                dis = routes[idx][1];
            }
        }
        
        return answer;
    }
}