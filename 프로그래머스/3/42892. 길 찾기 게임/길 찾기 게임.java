import java.util.*;

class Solution {
    
    static Object[] heights;
    static TreeMap<Integer, TreeSet<int[]>> tm;
    static int index;
    static int[][] answer;
    
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        answer = new int[2][len];
        tm = new TreeMap<>(
            (a,b) -> b-a
        );
        
        for(int i = 0; i < len; i++) {
            int[] node = nodeinfo[i];
            
            if(!tm.containsKey(node[1]))
                tm.put(node[1], new TreeSet<>(
                    (a,b) -> a[0] - b[0]
                ));
            
            tm.get(node[1]).add(new int[] {node[0], i+1});
        }
        TreeMap<Integer, TreeSet<int[]>> tmp = new TreeMap<>();
        heights = tm.keySet().toArray();
        for(int i = 0; i < heights.length; i++) {
            tmp.put((Integer)heights[i], (TreeSet<int[]>)tm.get(heights[i]).clone());
        }
        
        predfs(0, 0, 100000);
        index = 0;
        tm = tmp;
        
        postdfs(0,0,100000);
        
        
        return answer;
    }
    
    static void predfs(int idx, int left, int right) {
        if(idx == heights.length) {
            return;
        }
        
        TreeSet<int[]> tmp = tm.get(heights[idx]);
        
        if(tmp.isEmpty() || tmp.first()[0] > right)
            return;
        
        int[] node = tmp.pollFirst();
        answer[0][index++] = node[1];
        predfs(idx+1, left, node[0]);
        predfs(idx+1, node[0], right);
    }
    
    static void postdfs(int idx, int left, int right) {
        if(idx == heights.length) {
            return;
        }
        
        TreeSet<int[]> tmp = tm.get(heights[idx]);
        
        if(tmp.isEmpty() || tmp.first()[0] > right)
            return;
        
        int[] node = tmp.pollFirst();
        postdfs(idx+1, left, node[0]);
        postdfs(idx+1, node[0], right);
        answer[1][index++] = node[1];
    }

}