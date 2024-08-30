import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            int comp = Character.compare(a.charAt(n), b.charAt(n)); 
            if(comp == 0) 
                return a.compareTo(b);
            return comp;
        });
        
        return strings;
    }
}