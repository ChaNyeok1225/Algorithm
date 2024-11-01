class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        
        int d = s / n;
        int e = s % n;
        
        if(d != 0) {
            answer = new int[n];
            
            for(int i = 0; i < n; i++) {
                answer[i] = d + (i > n - e - 1? 1 : 0);
            }
            
        }
        
        return answer;
    }
}