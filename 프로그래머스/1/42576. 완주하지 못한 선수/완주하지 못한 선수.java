import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int idx = 0;
        for(; idx < completion.length; idx++) {
            if(!participant[idx].equals(completion[idx])) {
                break;
            }
        }
        
        return participant[idx];
    }
}