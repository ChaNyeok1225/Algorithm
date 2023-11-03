class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int b = 0; int s = 0;
        
        int size = sizes.length;
        
        for(int i = 0; i < size; i++) {
            int idx = 0;
            if(sizes[i][idx] < sizes[i][idx ^ 1])
                idx ^= 1;
            
            b = b > sizes[i][idx] ? b : sizes[i][idx];
            s = s > sizes[i][idx ^ 1] ? s : sizes[i][idx ^ 1];
        }
        
        return b*s;
    }
}