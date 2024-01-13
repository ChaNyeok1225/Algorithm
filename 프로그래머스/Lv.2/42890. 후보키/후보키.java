import java.util.*;

class Solution {
    
    static int sel[], n, m, answer;
    static List<String> list = new ArrayList<>();
    static Queue<Integer> q = new ArrayDeque<>();

    public int solution(String[][] relation) {
        
        n = relation[0].length;
        m = relation.length;
        sel = new int[n]; 
        dfs(0, 0, 0, relation);        
        
        int answer = 0;
        
        List<Integer> min = new ArrayList<>();
        
        Collections.sort(list, (a,b) -> a.length() - b.length());
        
        boolean chk;
        int flag;
        for(int i = 0; i < list.size(); i++) {
            flag = 0;
            char[] cur = list.get(i).toCharArray();
            for(int j = 0; j < cur.length; j++) 
                flag |= (1<<(cur[j]-'0'));
            
            chk = true;
            for(int j = 0; j < min.size(); j++) {
                if((min.get(j) & flag) == min.get(j)) {
                    chk = false;
                    break;
                }
            }
            
            if(chk)
                min.add(flag);
            
        }
        
        
        return min.size();
    }
    
    static StringBuilder sb = new StringBuilder();
    static void dfs(int idx, int cnt, int flag, String[][] relation) {
        if(idx == n) {
            if(cnt == 0)
                return;
            
            int index = 0;
            sb.setLength(0);
            for(int i = 0; i < n; i++) {
                if((flag & (1<<i)) != 0) {
                    sel[index++] = i;
                    sb.append(i);
                }
            }
            
            boolean rchk;
            for(int i = 0; i < m - 1; i++) {
                for(int j = i + 1; j < m; j++) {
                    rchk = false;
                    for(int k = 0; k < cnt; k++) {
                        if(!relation[i][sel[k]].equals(relation[j][sel[k]]))
                            rchk = true;
                    }
                    if(!rchk)
                        return;
                }
            }
            list.add(sb.toString());
            return;
        }
        
        dfs(idx + 1, cnt, flag, relation);
        dfs(idx + 1, cnt+1, flag | (1<<idx), relation);
        
    }

}