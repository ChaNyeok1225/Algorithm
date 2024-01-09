import java.util.*;

class Solution {

    static List<Integer>[] tree;
    static int n, m, answer;


    public int solution(int[] info, int[][] edges) {
        n = info.length;
        m = edges.length;

        boolean[] vis = new boolean[n];
       tree = new ArrayList[n];
        for(int i = 0; i < n; i++)
            tree[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) 
            tree[edges[i][0]].add(edges[i][1]);

        dfs(0, 0, 0, 0, info);

        return answer;
    }

    static void dfs(int node, int sheep, int wolf, int vis, int[] info) {

        if(info[node] == 0) {
            sheep++;
        }else {
            wolf++;
        }

        for(int nxt : tree[node])
            vis |= (1<<nxt);

        if(sheep == wolf)
            return;

        answer = answer > sheep ? answer : sheep;

        for(int i = 0; i < n; i++) {
            if((vis & (1<<i)) != 0) {
                vis ^= (1 << i);
                dfs(i, sheep, wolf, vis, info);
                vis ^= (1<< i);
            }
        }

    }
}