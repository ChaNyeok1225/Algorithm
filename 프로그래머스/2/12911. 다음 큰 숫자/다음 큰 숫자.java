class Solution {
    public int solution(int n) {
        
        
        int cmp = 1;
        int cnt = 0;
        boolean flag = false;
        for(int i = 0; ; i++) {
            if((n & cmp) == 0) {
                if(flag) {
                    n |= cmp;
                    for(int j = 0; j <= cnt; j++) {
                        cmp >>= 1;
                        n &= ~(cmp);
                    }

                    break;
                } else {
                    n |= cmp;
                    cnt++;
                }
                
            } else {
                flag = true;
            }
            
            cmp <<= 1;
        }
        
        
        return n;
    }
}