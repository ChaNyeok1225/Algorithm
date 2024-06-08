import java.util.*;

class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        
        devide(0, 0, arr.length, arr);
        
        return answer;
    }
    
    void devide(int x, int y, int n, int[][] arr) {
        int p = arr[x][y];
        boolean dflag = true;        
        for(int i = 0; i < n && dflag; i++) {
            for(int j = 0; j < n && dflag; j++) {
                if(p != arr[x+i][y+j]) {
                    dflag = false;
                }
            }
        }
        
        if(!dflag) {
            int m = n / 2;
            devide(x, y, m, arr);
            devide(x + m, y, m, arr);
            devide(x, y + m, m, arr);
            devide(x + m, y + m, m, arr);
        } else {
            answer[p]++;
        }
        
    }
    
}