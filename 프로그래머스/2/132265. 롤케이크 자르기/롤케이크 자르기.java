class Solution {
    public int solution(int[] topping) {
        int len = topping.length;
        
        int answer = 0;
        int a = 0;
        int b = 0;
        
        int[] aArr = new int[10001];
        int[] bArr = new int[10001];
        for(int i = 0; i < len; i++) {
            if(bArr[topping[i]] == 0) b++;
            bArr[topping[i]]++;
        }
        
        for(int i = 0; i < len; i++) {
            if(aArr[topping[i]] == 0) a++;
            aArr[topping[i]]++;
            bArr[topping[i]]--;
            if(bArr[topping[i]] == 0) b--;
            if(a == b)
                answer++;
        }
        
        
        
        
        
        
        
        
        return answer;
    }
}