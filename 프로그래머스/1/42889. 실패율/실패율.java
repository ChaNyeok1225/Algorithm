import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Integer[] answer = new Integer[N];
        for(int i = 1; i <= N; i++)
            answer[i-1] = i;
        
        int[] wait = new int[N+2];
        int[] arr = new int[N+3];
        
        int m = stages.length;
        for(int i = 0; i < m; i++)
            wait[stages[i]]++;
        for(int i = N+1; i > 0; i--)
            arr[i] = arr[i+1] + wait[i];
        
        Arrays.sort(answer, (a, b) -> {
            double ad = arr[a] == 0 ? 0 : (double)wait[a] / arr[a];
            double bd = arr[b] == 0 ? 0 : (double)wait[b] / arr[b];
            if(ad==bd)
                return a - b;
            return -Double.compare(ad, bd);
        });
        
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}