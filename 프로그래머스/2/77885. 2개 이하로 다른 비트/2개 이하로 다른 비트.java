class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        char[] bin;
        boolean flag;
        for(int idx = 0; idx < numbers.length; idx++) {
            bin = Long.toString(numbers[idx], 2).toCharArray();
            flag = false;
            for(int i = bin.length - 1; i >= 0; i--) {
                if(bin[i] == '0') {
                    bin[i] = '1';
                    if(i != bin.length-1)
                        bin[i+1] = '0';
                    flag = true;
                    break;
                }
            }
            if(flag) {
                answer[idx] = Long.parseLong(String.valueOf(bin), 2);
            } else {
                bin[0] = '0';
                answer[idx] = Long.parseLong("1" + String.valueOf(bin), 2);
            }
            
        }
        
        
        return answer;
    }
}