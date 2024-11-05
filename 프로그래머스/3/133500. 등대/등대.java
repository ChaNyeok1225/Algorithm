import java.util.*;

class Solution {
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        int[] degree = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 차수 기록 및 연결
        for(int[] edge : lighthouse) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        // 리프노드와 연결된 노드를 찾는 것
        TreeSet<Integer> set = new TreeSet<>();
        
        int max, select, v;
        // 불을 켜나가는 반복문
        while(true) {
            
            for(int i = 1; i < n + 1; i++) {
                if(degree[i] == 1) {
                    
                    for(int next : graph[i]) {
                        if(degree[next] > 0)
                            set.add(next);
                    }
                    
                }
            }
            
            if(set.isEmpty())
                break;
            
            for(int conn : set) {
                if(degree[conn] <= 0)
                    continue;
                degree[conn] = 0;
                answer++;
                
                for(int next : graph[conn]) {
                    degree[next]--;
                }
            }
            
            set.clear();
        }
        
        // 1 - (2) - 3 - 4 - (5) - 6
        
        return answer;
    }
}