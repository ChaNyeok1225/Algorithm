import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] clear = new int[N+1];
        for(int i = 0;  i < stages.length; i++) {
            clear[stages[i]-1]++;
        }
        
        
        int total = stages.length;
        
        int c = 0;
        double[][] ratio = new double[N][2];
        for(int i = 0; i < N; i++) {
            System.out.println( clear[i] + " , " +total);
            if(total == 0)    
                ratio[i][0] = 0;
            else
                ratio[i][0] = (double)clear[i] / total;
            
            ratio[i][1] = i+1;
            total -= clear[i];
        }
        
        
        Arrays.sort(ratio, (a,b) -> Double.compare(b[0],a[0]));
        for(int i = 0; i < N; i++)
            answer[i] = (int)ratio[i][1];
        return answer;
    }
}