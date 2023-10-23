class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n+2];
        
        for(int i = 0; i < lost.length; i++)
            student[lost[i]]--;
        for(int i = 0; i < reserve.length; i++)
            student[reserve[i]]++;
        
        for(int i = 1; i < n+1; i++) {
            
            if(student[i] < 0) {
                if(student[i-1] > 0) {
                    student[i-1] --;
                    student[i] ++;
                    continue;
                }
                if(student[i+1] > 0) {
                    student[i+1] --;
                    student[i] ++;
                    continue;
                }
            }
        }
        
        for(int i = 1; i < n + 1; i++)
            if(student[i] >= 0)
                answer++;
        
        return answer;
    }
}