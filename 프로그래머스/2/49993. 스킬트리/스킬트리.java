import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill_trees.length;
        int slen = skill.length();
        char[] skillArr = skill.toCharArray();

        int sidx = 0;
        TreeMap<Character, Integer> map = new TreeMap<>(); 
        for(char c : skillArr) {
            map.put(c, sidx++);
        }
        
        boolean flag;
        Integer seq;
        String sk;
        for(int i = 0; i < len; i++) {
            sk = skill_trees[i];
            flag = true;
            sidx = 0;
            for(int j = 0; j < sk.length(); j++) {
                seq = map.get(sk.charAt(j));
                if(seq == null)
                    continue;
                else {
                    if(sidx == seq) {
                        sidx++;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
            if(flag)
                answer++;
        }
        
        
        return answer;
    }
}