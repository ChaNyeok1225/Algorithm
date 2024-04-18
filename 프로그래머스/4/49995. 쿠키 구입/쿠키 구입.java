class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int len = cookie.length;
        
        
        for(int k = 0; k < len; k++) {
            
            int ai = 1;
            int bi = 1;
            int av = cookie[k];
            int bv = 0;
            
            
            while(true) {        
                if(av == bv) {
                    answer = answer > av ? answer : av;
                }
                
                if(av > bv) {
                    if(k+bi >= len) break;
                    
                    bv += cookie[k+bi++];
                } else {
                    if(k - ai < 0) break;
                    
                    av += cookie[k - ai++];
                }
                
            }
            
            
            
        }
        
        
        return answer;
    }
}