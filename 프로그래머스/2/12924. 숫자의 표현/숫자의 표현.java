class Solution {
    public int solution(int n) {
        int answer = 1;
        
        int len = n / 2 + 1;
        
        int sum = 0;
        int j = 1;
        for(int i = 1; i < len; i++) {
            while(sum < n) {
                sum += j++;
            }
            if(sum == n)
                answer++;
            sum -= i;
        }
        
        
        return answer;
    }
}