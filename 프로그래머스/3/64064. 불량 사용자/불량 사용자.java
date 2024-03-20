import java.util.*;

class Solution {
    
    static int len_id, len_banned, answer;
    static boolean[] sel;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        
        len_id = user_id.length;
        len_banned = banned_id.length;
        sel = new boolean[len_banned];
        
        dfs(0, 0, 0, user_id, banned_id);
        
        
        return set.size();
    }
    
    static void dfs(int idx, int cnt, int nl, String[] user_id, String[] banned_id ) {
        if(idx == len_id) {
            if(cnt == len_banned) {
                set.add(nl);
            }
            return;
        }
        
        String id = user_id[idx];
        for(int i = 0; i < len_banned; i++) {
            if(sel[i]) continue;
            
            boolean flag = true;
            if(id.length() == banned_id[i].length()) {
                for(int j = 0; j < id.length(); j++) {
                    if(banned_id[i].charAt(j) == '*') continue;
                    if(banned_id[i].charAt(j) != id.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
            } else {
                flag = false;
            }
            
            
            if(flag) {
                sel[i] = true;
                dfs(idx + 1, cnt + 1, nl | 1 << idx, user_id, banned_id);
                sel[i] = false;
            }
        }
        dfs(idx + 1, cnt, nl, user_id, banned_id);
        
    }
}