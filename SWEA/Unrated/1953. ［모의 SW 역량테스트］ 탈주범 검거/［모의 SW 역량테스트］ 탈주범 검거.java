import java.io.*;
import java.util.*;
 
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
 
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
 
    static String[] path = { null, "0123", "02", "13", "12", "01", "03", "23" };
 
    public static void main(String[] args) throws IOException {
 
        int T = Integer.parseInt(br.readLine().trim());
         
        for (int tc = 1; tc < T+1; tc++) { 
 
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int hx = Integer.parseInt(st.nextToken());
            int hy = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
 
            int[][] board = new int[n][m];
            boolean[][] vis = new boolean[n][m];
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }
 
            Queue<int[]> q = new ArrayDeque<int[]>();
            q.offer(new int[] { hx, hy, 1 });
            vis[hx][hy] = true;
 
            int posCase = 0;
            while (!q.isEmpty()) {
                int[] p = q.poll();
 
                if (p[2] > l)
                    break;
 
                posCase++;
 
                int type = board[p[0]][p[1]];
 
                int nx, ny;
                
                for(char c : path[type].toCharArray()) {
                	int dir = c - '0';
                	
                	nx = p[0] + dx[dir];
                	ny = p[1] + dy[dir];
                	
                	if(nx < 0 || ny < 0 || n <= nx || m <= ny || vis[nx][ny] || board[nx][ny]==0)
                		continue;
                	
                	if(path[board[nx][ny]].contains(String.valueOf( (dir+2) %4))) {
                		vis[nx][ny] = true;
                		q.offer(new int[] {nx,ny,p[2]+1});
                	}
                }
 
            }
 
            System.out.printf("#%d %d\n", tc, posCase); // 결과 출력
 
        }
 
    }
}