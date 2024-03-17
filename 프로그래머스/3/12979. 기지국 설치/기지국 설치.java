class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int slen = stations.length;
        int value = 2 * w + 1;
        
        int start = 1, end;
        for(int i = 0; i < slen; i++) {
            end = stations[i] - w;
            
            int dis = end - start;
            if(dis > 0) {
                answer += ((dis-1)/ value) + 1;
            }
            start = stations[i] + w + 1;
        }
        
        if(start <= n) {
            answer += ((n - start - 1) / value ) + 1;
        }
        
        return answer;
    }
}