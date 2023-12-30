class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        int size = queue1.length;
        int[] queue = new int[size*2];
        int idx = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < size; i++) {
            queue[idx++] = queue1[i];
            sum1 += queue1[i];
        }
        for(int i = 0; i < size; i++) {
            queue[idx++] = queue2[i];
            sum2 += queue2[i];
        }
        long target = (sum1 + sum2) / 2; 
        int len = size * 2;
        int idx1 = 0;
        int idx2 = size;
        while(answer < len * 2) {
            if(sum1 == sum2)
                break;
            
            if(sum1 > target) {
                sum2 += queue[idx1];
                sum1 -= queue[idx1++];
                idx1 %= len;
            }
            else if (sum2 > target) {
                sum1 += queue[idx2];
                sum2 -= queue[idx2++];
                idx2 %= len;
            }
            answer++;
        }
        
        if(answer >= len * 2)
            answer = -1;
        return answer;
    }
}