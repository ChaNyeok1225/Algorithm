import java.io.*;
import java.util.*;

public class Main {

	static int n, m;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		char[][] board = new char[n][m];		
		int[][] wdist = new int[n][m];
		int[][] kdist = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			Arrays.fill(wdist[i], -1);
			Arrays.fill(kdist[i], -1);
		}
		
		Queue<int[]> water = new ArrayDeque<>();
		Queue<int[]> kak = new ArrayDeque<>();
		
		int hx = 0, hy = 0;
		
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < m; j++) {
				board[i][j] = ch[j]; 
				if(board[i][j] == '*') {
					water.offer(new int[] {i,j});
					wdist[i][j] = 0;
				}
				else if(board[i][j] == 'S') {
					kak.offer(new int[] {i,j});
					kdist[i][j] = 0;
				}
				else if(board[i][j] == 'D') {
					hx = i;
					hy = j;
				}
			}
		}
		
		int[] dx=  {1,0,-1,0}, dy = {0,1,0,-1};
		
		while(!water.isEmpty()) {
			int[] p = water.poll();
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(rangeChk(nx, ny)) continue;
				if(board[nx][ny] == 'X'||board[nx][ny] == 'D' || wdist[nx][ny] >= 0) continue;
				
				wdist[nx][ny] = wdist[p[0]][p[1]] + 1;
				water.offer(new int[] {nx,ny});
			}
		}
		
		while(!kak.isEmpty()) {
			int[] p = kak.poll();
			
			if(p[0] == hx && p[1] == hy)
				break;
			
			for(int dir = 0; dir < 4; dir++) {
				int nx = p[0] + dx[dir];
				int ny = p[1] + dy[dir];
				
				if(rangeChk(nx, ny)) continue;
				if(board[nx][ny] == 'X' || kdist[nx][ny] >= 0) continue;
				if(wdist[nx][ny] != -1 && (kdist[p[0]][p[1]] + 1) >= wdist[nx][ny]) continue;
				kdist[nx][ny] = kdist[p[0]][p[1]] + 1;
				kak.offer(new int[] {nx,ny});
			}
		}
		
		if(kdist[hx][hy] == -1)
			System.out.println("KAKTUS");
		else
			System.out.println(kdist[hx][hy]);
	}

	static boolean rangeChk(int x, int y) {
		return (x < 0 || y < 0 || n <= x || m <= y);
	}

}