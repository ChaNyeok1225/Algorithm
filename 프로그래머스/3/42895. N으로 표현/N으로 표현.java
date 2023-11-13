class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int goalNum;
    static boolean flag = false;
    
    public int solution(int N, int number) {
        goalNum = number;
        
        int tmp = 0;
        for(int i = 0; i <= 8; i++) {
            tmp = tmp * 10 + N;
            dfs(0, i, N);
        }
        
        if(answer == Integer.MAX_VALUE)
            answer = -1;
        return answer;
    }
    
    
    static void dfs(long num, int cnt,int n) {
        if(cnt > 8 || cnt >= answer)
            return;
        
        if(goalNum == num) {
            answer = answer < cnt ? answer : cnt;            
            return;
        }        
        
        
        int tmp = 0;
        for(int i = 1; i <= 8-cnt; i++) {
            tmp = tmp * 10 + n;
            dfs(num / tmp,cnt+i,n);
            dfs(num*tmp, cnt+i,n);
            dfs(num+tmp, cnt+i, n);
            dfs(num-tmp, cnt+i, n);
        }
        
    }
    
}