import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        int len = enroll.length;
        int[] answer = new int[len];
        
        HashMap<String,Integer> index = new HashMap<>();
        int idx = 0;
        for(String name : enroll)
            index.put(name, idx++);
        
        int[] Recomm = new int[idx];
        
        for(int i = 0; i < len; i++) {
            String from = referral[i];
            
            Recomm[i] = index.getOrDefault(from, -1);
        }
        
        for(int i = 0; i < seller.length; i++) {
            idx = index.get(seller[i]);
            int val = amount[i] * 100;
            
            while(idx != -1) {
                int ex = (int)(val * 0.1);
                
                if(ex == 0) {
                    answer[idx] += val;
                    break;
                }
                answer[idx] += val - ex;
                val = ex;
                idx = Recomm[idx];
            }
            
        }
        
        
        
        
        return answer;
    }
}