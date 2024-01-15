class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            min = min < num ? min : num;
            max = max > num ? max : num;
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}