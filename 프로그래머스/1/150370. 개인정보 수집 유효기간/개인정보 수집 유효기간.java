import java.util.*;

class Solution {
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] ans = new int[privacies.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i  = 0; i < terms.length; i++) {
            String[] s = terms[i].split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }
        
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int idx = 0;
        for(int i = 1; i < privacies.length + 1; i++) {
            st = new StringTokenizer(privacies[i-1], ". ");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int t = map.get(st.nextToken());
            
            y += t/12;
            t = t % 12;
            
            m += t;
            if (m > 12) {
                y ++;
                m-=12;
            }
            d--;
            if(d == 0) {
                d = 28;
                m--;
                if(m==0) {
                    y--;
                    m = 12;
                }
            }
            
            
            if(year > y) {
                ans[idx++] = i;
                continue;
            } else if(year == y){
                if(month > m) {
                    ans[idx++] = i;
                    continue;
                } else if(month == m) {
                    if(day > d) {
                        ans[idx++] = i;
                        continue;
                    }
                }
            }
            
        }
        
        return Arrays.copyOf(ans, idx);
    }
}