import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	static int[][] board;
	static int n,m;
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			int inst = Integer.parseInt(st.nextToken());
			func(inst);
		}
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++)
				sb.append(board[i][j] + " ");
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	static void func(int inst) {
		
		int[][] tmp;
		
		switch (inst) {
		case 1:
			tmp = new int[board.length][board[0].length];
			
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[i].length; j++)
					tmp[i][j] = board[board.length-1-i][j];
			}
			
			break;
		case 2:
			tmp = new int[board.length][board[0].length];
			
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[i].length; j++)
					tmp[i][j] = board[i][board[0].length-1-j];
			}
			
			break;
		case 3:
			tmp = new int[board[0].length][board.length];
			
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[i].length; j++) 
					tmp[i][j] = board[board.length-1-j][i];
			}
			
			break;
			
		case 4:
			tmp = new int[board[0].length][board.length];
			
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[i].length; j++) 
					tmp[i][j] = board[j][board[0].length-1-i];
			}
			
			break;
		case 5:
			tmp = new int[board.length][board[0].length];

			part(tmp, 0, 0, 0, board[0].length/2);
			part(tmp, 0, board[0].length/2, board.length/2, board[0].length/2);
			part(tmp, board.length/2, board[0].length/2, board.length/2, 0);
			part(tmp, board.length/2, 0, 0, 0);
			break;
			
		default:
			
			tmp = new int[board.length][board[0].length];

			part(tmp, 0, 0, board.length/2, 0);
			part(tmp, board.length/2, 0, board.length/2, board[0].length/2);
			part(tmp, board.length/2, board[0].length/2, 0, board[0].length/2);
			part(tmp, 0, board[0].length/2, 0, 0);
			break;
		}
		
		board = tmp;
		
	}
	
	public static void part(int[][] tmp, int sx, int sy, int x, int y) {
		
		for(int i = 0; i < board.length/2; i++) {
			for(int j = 0; j < board[0].length/2; j++) {
				tmp[x+i][y+j] = board[sx+i][sy+j];
			}
		}
		
	}

}