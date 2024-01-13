import java.util.*;

class Solution {
    
    public int solution(String[][] relation) {
        
        int n = relation.length;
        int m = relation[0].length;
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < m; i++)
            q.offer(1 << i);
        
        List<Integer> min = new ArrayList<>();
        
        boolean[] sel = new boolean[m];
        loop: while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i < min.size(); i++) {
                if((min.get(i) & cur) == min.get(i))
                    continue loop;
            }
            
            Arrays.fill(sel, false);
            for(int i = 0; i < m; i++) {
                if((cur & (1 << i)) != 0)
                    sel[i] = true;
            }
            
			boolean chk = false;
			uniq : for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					chk = false;
					for (int k = 0; k < m; k++) {
						if (!sel[k])
							continue;

						if (!relation[i][k].equals(relation[j][k])) {
							chk = true;
						}
					}
					
					if (!chk)
						break uniq;
				}
			}

            
            if(chk) {
                min.add(cur);
            } else {
                for(int i = 0; i < m; i++) {
                    if(sel[i]) continue;
                    q.offer(cur | (1<<i));
                }
            }
            
        }
        
        
        return min.size();
    }

}