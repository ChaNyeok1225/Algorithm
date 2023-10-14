import java.util.*;

class Solution {
    
    static class Ticket {
        String to;
        int idx;
        
        Ticket(String to, int idx) {
            this.to = to;
            this.idx = idx;
        }
        
        public String toString() {
            return this.to + ", " + this.idx;
        }
        
    }
 
    static HashMap<String, ArrayList<Ticket>> map  = new HashMap<>();
    static boolean flag, use[];
    static String[] path;
    static int len;
    
    public String[] solution(String[][] tickets) {
        len = tickets.length;
        use = new boolean[len];
        path = new String[len+1];
        
        for(int i = 0; i < len; i++) {
            if(!map.containsKey(tickets[i][0]))
                map.put(tickets[i][0], new ArrayList<>());
            
            map.get(tickets[i][0]).add(new Ticket(tickets[i][1], i));
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key), (a, b) -> a.to.compareTo(b.to));
            // System.out.println(key + ", " + map.get(key));
        }
        
        path[0] = "ICN";
        dfs(0, "ICN");
        
        return path;
    }
    
    static void dfs(int cnt, String name) {
        // System.out.println(cnt + " :: " + name);

        if(cnt == len) {
            flag = true;
            return;
        }
        if(!map.containsKey(name)) return;
        for(Ticket t : map.get(name)) {
            if(use[t.idx] || flag) continue;
            use[t.idx] = true;
    
            path[cnt+1] = t.to;
            dfs(cnt+1, t.to);
            
            
            use[t.idx] = false;
            
        }
        
        
        
    }
    
    
}