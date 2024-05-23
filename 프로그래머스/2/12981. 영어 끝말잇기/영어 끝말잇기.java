import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int len = words.length;
        
        HashSet<String> wordSet = new HashSet<>();
        
        int sel = 1;
        int turn = 1;
        boolean flag = false;
        char prev = words[0].charAt(0);
        for(int i = 0; i < len; i++) {
            if(prev != words[i].charAt(0) || wordSet.contains(words[i])) {
                flag = true;
                break;
            }
               
            wordSet.add(words[i]);
            prev = words[i].charAt(words[i].length()-1);
            sel = (sel % n) + 1; 
            if(sel == 1)
                turn++;
        }
        
        if(flag)
            return new int[] {sel, turn};
        else
            return new int[] {0,0};
    }
}