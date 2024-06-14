import java.util.*;

class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] selFirst = new int[len];
        int[] selSecond = new int[len];
        
        selFirst[0] = selFirst[1] = money[0];
        selSecond[1] = money[1];
        
        for(int i = 2; i < len - 1; i++) {
            selFirst[i] = Math.max(selFirst[i-1], money[i] + selFirst[i-2]);
            selSecond[i] = Math.max(selSecond[i-1], money[i] + selSecond[i-2]);            
        }
        selFirst[len-1] = selFirst[len-2];
        
        selSecond[len-1] = Math.max(selSecond[len-2], money[len-1] + selSecond[len-3]);
        
        
        int answer = Math.max(selFirst[len-1], selSecond[len-1]);
        return answer;
    }
}