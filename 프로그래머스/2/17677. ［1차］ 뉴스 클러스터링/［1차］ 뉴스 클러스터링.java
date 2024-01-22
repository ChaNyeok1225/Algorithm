import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        
        div(str1, map1, set);
        div(str2, map2, set);

        int minSum = 0, maxSum = 0;
        
        for(String s : set) {
            int val1 = map1.getOrDefault(s, 0);
            int val2 = map2.getOrDefault(s, 0);
            
            maxSum += val1 > val2 ? val1 : val2;
            minSum += val1 < val2 ? val1 : val2;
        }
        
        if(maxSum == 0)
            answer = 65536;
        else
            answer = 65536 * minSum / maxSum;
        
        return answer;
    }
    
    static void div(String str, HashMap<String, Integer> map, HashSet<String> set) {
        char[] carr= str.toCharArray();
        char a, b = Character.toLowerCase(carr[0]);
        for(int i = 1; i < carr.length; i++) {
            a = b;
            b = Character.toLowerCase(carr[i]);
            
            if(Character.isLetter(a) && Character.isLetter(b)) {
                String s = "" + a + b;
                set.add(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}