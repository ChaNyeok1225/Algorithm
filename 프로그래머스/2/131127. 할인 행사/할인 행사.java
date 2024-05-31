import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = want.length;
        
        int[] wantCount = new int[len];
        
        HashMap<String, Integer> index = new HashMap<>();
        int idx = 0;
        for(int i = 0; i < len; i++) {
            index.put(want[i], idx++);
        }
        
        for(int i = 0; i < discount.length; i++) {
            Integer mIdx = index.get(discount[i]);
            if(mIdx != null) {
                wantCount[mIdx]++;
            }
            
            if(i > 9) {
                mIdx = index.get(discount[i-10]);
                if(mIdx != null) {
                    wantCount[mIdx]--;
                }
            }
            
            for(int j = 0; j < len; j++) {
                if(wantCount[j] < number[j])
                    break;

                if(j==len - 1)
                    answer++;
            }
        }
        
        
        
        return answer;
    }
}