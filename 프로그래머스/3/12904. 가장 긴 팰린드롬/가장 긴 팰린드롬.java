class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int len = s.length();
        char[] c = s.toCharArray();
        
        
        int plen, l;
        boolean eflag, oflag; 
        for(int i = 0; i < len; i++) {
            plen = 1;
            eflag = oflag = true;
            
            while(i - plen >= 0) {
                
                if(oflag && i + plen < len && c[i + plen] == c[i - plen]) {
                     answer = answer > plen * 2 + 1 ? answer : plen * 2 + 1;
                } else {
                    oflag = false;
                }
                
                if(eflag && i + plen - 1 < len && c[i + plen - 1] == c[i - plen]) {
                     answer = answer > plen * 2 ? answer : plen * 2;
                } else {
                    eflag = false;
                }
                
                if(!eflag && !oflag)
                    break;
                
                plen++;
            }
            
        }

        return answer;
    }
}
