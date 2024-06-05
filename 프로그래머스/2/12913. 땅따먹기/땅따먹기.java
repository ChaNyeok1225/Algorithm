class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        int max;
        for(int i = 1; i < len; i++) {
            
            for(int j = 0; j < 4; j++) {
                max = 0;
                                
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    max = max > land[i-1][k] ? max : land[i-1][k];
                }
                
                land[i][j] += max;
            }
        }
        
        for(int i = 0; i < 4; i++)
            answer = answer > land[len-1][i] ? answer : land[len-1][i];
        
        return answer;
    }
}