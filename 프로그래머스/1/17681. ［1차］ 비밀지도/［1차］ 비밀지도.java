import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        char[][] map = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            
            for(int j = n-1; j >= 0; j--) {
                int a1 = arr1[i] % 2;
                int a2 = arr2[i] % 2;
                
                if(a1 + a2 == 0) {
                    map[i][j] = ' ';
                } else {
                    map[i][j] = '#';
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
        }
        
        for(int i = 0; i < n; i++)
            answer[i] = String.valueOf(map[i]);
        
        return answer;
    }
}