import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int idx1 = 0;
        int idx2 = 0;
        int gidx = 0;
        
        while(gidx < goal.length) {
            if(idx1 < cards1.length && goal[gidx].equals(cards1[idx1])) {
                gidx++;
                idx1++;
            } else if(idx2 < cards2.length && goal[gidx].equals(cards2[idx2])) {
                gidx++;
                idx2++;
            } else {
                answer = "No";
                break;
            }
        }
        
        return answer;
    }
}