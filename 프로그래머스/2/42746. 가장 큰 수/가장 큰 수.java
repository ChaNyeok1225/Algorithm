import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len = numbers.length;
   
        int[][] snum = new int[len][2];
        
        for(int i = 0; i < len; i++) {
            String s = String.valueOf(numbers[i]);
            int idx = 0;
            
            while(s.length() < 4) {
                s += s.charAt(idx++);
            }            
            snum[i][0] = Integer.parseInt(s);
            snum[i][1] = i;
        }
        
        Arrays.sort(snum, (a,b) ->  b[0] - a[0]);
        
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < len; i++) 
            sb.append(numbers[snum[i][1]]);
        
        String result = sb.toString();
        if(result.charAt(0) == '0')
            result = "0";
        
        return result;
    }
}