class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int n = a.length;
        
        int[] larr = new int[n];
        int[] rarr = new int[n];
        
        int min;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = min < a[i] ? min : a[i];
            larr[i] = min;
        }
        min = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            min = min < a[i] ? min : a[i];
            rarr[i] = min;
        }
        
        
        for(int i = 0; i < n; i++) {
            if(i == 0 || i == n - 1) {
                answer++;
                continue;
            }
            if(larr[i-1] < a[i] && rarr[i+1] < a[i])
                continue;
            answer++;
        }
        
        return answer;
    }
}