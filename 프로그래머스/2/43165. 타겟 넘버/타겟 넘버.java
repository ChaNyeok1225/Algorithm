class Solution {
    
    static int cnt;
    
    public int solution(int[] numbers, int target) {

        dfs(0,0,numbers.length,numbers, target);
        
        return cnt;
    }
    
    
    static void dfs(int val, int idx, int end, int[] numbers,int target) {
        if(idx == end) {
            if(target == val)
                cnt++;
            return;
        }
        
        dfs(val + numbers[idx], idx+1, end, numbers, target);
        dfs(val - numbers[idx], idx+1, end, numbers, target);
        
    }
    
}