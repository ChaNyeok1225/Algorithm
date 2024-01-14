class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int oneCnt = 0;
        int cnt = 0;
        while(!"1".equals(s)) {
            cnt++;
            oneCnt = 0;            
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == '1')
                    oneCnt++;
                else
                    zeroCnt++;
            }
            
            s = Integer.toBinaryString(oneCnt);
            
        }
        
        return new int[] {cnt, zeroCnt};
    }
}