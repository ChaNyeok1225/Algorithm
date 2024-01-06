import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int n = id_list.length;
        
        HashMap<String, Integer> index = new HashMap<>();
        for(int i = 0; i < n; i++) 
            index.put(id_list[i], i);
        boolean[][] checkMail = new boolean[n][n]; 
        int[] totalReport = new int[n];
        
        List<Integer>[] mailFrom = new ArrayList[n];
        for(int i =0; i < n; i++)
            mailFrom[i] = new ArrayList<>();
        
        int m = report.length;

        for(int i = 0; i < m; i++) {
            String[] str = report[i].split(" ");
            int from = index.get(str[0]);
            int to = index.get(str[1]);
            if(!checkMail[from][to]) {
                checkMail[from][to] = true;
                mailFrom[to].add(from);
                totalReport[to]++;
            }
        }
        
        int[] answer = new int[n];
        
        for(int i = 0; i < n; i++) {
            if(totalReport[i] < k) continue; 
            
            for(int sender : mailFrom[i])
                answer[sender]++;
        }
        
        return answer;
    }
}