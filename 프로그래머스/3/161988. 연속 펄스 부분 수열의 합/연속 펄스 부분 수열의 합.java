class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int n = sequence.length;
        
        long sum1 = 0;
        long sum2 = 0;
        
        int seq = 1;
        
        for(int i = 0; i < n; i++) {
            if(sum1 < 0)
                sum1 = 0;
            if(sum2 < 0) 
                sum2 = 0;
            
            sum1 += sequence[i] * seq;
            sum2 += sequence[i] * -seq;
            
            answer = Math.max(answer, Math.max(sum1, sum2));
            
            seq = -seq;
        }
        
        return answer;
    }
}