class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        
        long num, row, col;
        for(int i = 0; i < (int)(right - left + 1); i++) {
            num = i + left;
            
            row = (num / n) + 1;
            col = (num % n) + 1;
            
            answer[i] = col < row ? (int)row : (int)col;
        }
        
        return answer;
    }
}