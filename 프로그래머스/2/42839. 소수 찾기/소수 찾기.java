class Solution {
    
    static int size =10000000;
    static boolean isPrime[] = new boolean[size + 1];
    static boolean chk[] = new boolean[size + 1];
    static boolean[] use;
    static int answer;
    
    public int solution(String numbers) {
        use = new boolean[numbers.length()];
        isPrime[0] = isPrime[1] = true;
        for(int i = 2; i * i <= size; i++) {
            if(isPrime[i]) continue;
            for(int j = i * i; j <= size; j += i)
                isPrime[j] = true;
        }
        
        dfs(0, 0, numbers.length(), numbers);
        
        return answer;
    }
    
    static void dfs(int cnt, int num, int len, String numbers) {

        if(!isPrime[num] && !chk[num]) {
            chk[num] = true;
            answer++;
        }

        for(int i = 0; i < len; i++) {
            if(use[i]) continue;
            use[i] = true;
            dfs(cnt+1, num * 10 + numbers.charAt(i) - '0', len, numbers);
            use[i] = false;
        }
    }
}