class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r = arr1.length;
        int c = arr2[0].length;
        int v = arr2.length;
        
        int[][] answer = new int[r][c];
            
        for(int i = 0; i < r; i++) {
                        
            for(int j = 0; j < c; j++) {
                
                int sum = 0;
                
                for(int k = 0; k < v; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                
                answer[i][j] = sum;
                
            }
            
        }
        
        
        return answer;
    }
}