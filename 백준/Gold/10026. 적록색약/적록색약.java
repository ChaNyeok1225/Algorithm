import java.util.*;
import java.io.*;

public class Main {

	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		
		int n = Integer.parseInt(br.readLine());
		
		char[][] RGB = new char[n][n];
		char[][] RB = new char[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			
			for(int j = 0; j < n; j++) {
				RGB[i][j] = ch[j];
				if(ch[j] == 'G')
					ch[j] = 'R';
				RB[i][j] = ch[j];
			}
		}
		
		boolean[][] vis1 = new boolean[n][n];
		LinkedList<int[]> q1 = new LinkedList<>();
		
		int cnt1 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(vis1[i][j] == false) {
					vis1[i][j] = true;
					q1.add(new int[] {i,j});
					cnt1++;
				}
				
				while(!q1.isEmpty()) {
					int[] p = q1.pop();
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if(vis1[nx][ny] || RGB[nx][ny] != RGB[p[0]][p[1]]) 
							continue;
						
						vis1[nx][ny] = true;
						q1.add(new int[] {nx,ny});
					}
				}
			}
		}
		
		boolean[][] vis2 = new boolean[n][n];
		LinkedList<int[]> q2 = new LinkedList<>();
		
		int cnt2 = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(vis2[i][j] == false) {
					vis2[i][j] = true;
					q2.add(new int[] {i,j});
					cnt2++;
				}
				
				while(!q2.isEmpty()) {
					int[] p = q2.pop();
					
					for(int dir = 0; dir < 4; dir++) {
						int nx = p[0] + dx[dir];
						int ny = p[1] + dy[dir];
						
						if(nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						if(vis2[nx][ny] || RB[nx][ny] != RB[p[0]][p[1]]) 
							continue;
						
						vis2[nx][ny] = true;
						q2.add(new int[] {nx,ny});
					}
				}
			}
		}
//		for(char[] c : RGB)
//			System.out.println(Arrays.toString(c));
//		System.out.println();
//		for(char[] c : RB)
//			System.out.println(Arrays.toString(c));
//		System.out.println();

		System.out.println(cnt1 + " " + cnt2);
		
		
		////////////////////////////////////////////////////
		br.close();
	}

}
