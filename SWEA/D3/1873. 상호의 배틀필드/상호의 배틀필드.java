import java.io.*;
import java.util.*;

public class Solution {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static char[][] board = new char[20][20];

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] tp;
	
	static int h, w, tdir;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			

			for (int i = 0; i < h; i++) {
				char[] c = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					board[i][j] = c[j];

					if (c[j] == '<' || c[j] == 'v' || c[j] == '^' || c[j] == '>')
						tp = new int[] { i, j };
				}
			}

			switch(board[tp[0]][tp[1]]) {
			case '^' :
				tdir = 0; break;
			case 'v' :
				tdir = 1; break;
			case '<' :
				tdir = 2; break;
			case '>' :
				tdir = 3; break;
			}
			
			
			int n = Integer.parseInt(br.readLine());
			char[] ins = br.readLine().toCharArray();
			for (int i = 0; i < n; i++) {

				switch (ins[i]) {

				case 'U':
					moveTank(0);
					break;

				case 'D':
					moveTank(1);
					break;

				case 'L':
					moveTank(2);
					break;

				case 'R':
					moveTank(3);
					break;

				case 'S':
					shot(tdir);
					break;

				}
			}
			
			sb.append("#"+tc+" ");
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++)
					sb.append(board[i][j]);
				sb.append("\n");
			}
			
			
		}
		System.out.println(sb);
	}
	
	static void shot(int dir) {
		
		int nx = tp[0] + dx[dir];
		int ny = tp[1] + dy[dir];
		while(true) {
			
			if(nx < 0 || ny < 0 || h <= nx || w <= ny || board[nx][ny] == '#')
				return;
			
			if(board[nx][ny] == '*') {
				board[nx][ny] = '.';
				return;
			}
			
			nx += dx[dir];
			ny += dy[dir];
		}
		
	}
	
	static void moveTank(int dir) {
		tdir = dir;
		switch(dir) {
		case 0:
			board[tp[0]][tp[1]] = '^';
			break;
		case 1:
			board[tp[0]][tp[1]] = 'v';
			break;
		case 2:
			board[tp[0]][tp[1]] = '<';
			break;
		case 3:
			board[tp[0]][tp[1]] = '>';
			break;
		}
		
		int nx = tp[0] + dx[dir];
		int ny = tp[1] + dy[dir];
		
		if(nx < 0 || ny < 0 || h <= nx || w <= ny || board[nx][ny] != '.')
			return;
		
		board[nx][ny] = board[tp[0]][tp[1]];
		board[tp[0]][tp[1]] = '.';
		
		tp[0] = nx;
		tp[1] = ny;
		
	}
	
}