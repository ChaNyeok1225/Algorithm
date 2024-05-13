class Solution {
    public int solution(int[] arr) {
        
        int val = arr[0];
        for(int i = 1; i < arr.length; i++) {
            val = val * arr[i] / gcd(val, arr[i]);
        }
        
        return val;
    }
    
    int gcd(int a, int b) {
        int tmp;
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}