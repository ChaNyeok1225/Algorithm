class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, 1_000_001};
        int len = sequence.length;
        
        int j = 0;
        int sum = 0;
        for(int i = 0; i < len; i++) {
            
            while(j < len && sum < k) {
                sum += sequence[j++];
            }
            if(sum == k) {
                if((j - 1) - i + 1 < answer[1] - answer[0] + 1) {
                    answer[0] = i;
                    answer[1] = j - 1;
                }
            }
            
            sum -= sequence[i];
        }
        
        
        return answer;
    }
}