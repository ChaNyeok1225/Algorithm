import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int cntZero;
	static int cntOne;
	
	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		int[][] board = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) 
				board[i][j] = ch[j] - '0';
		}
		
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(paper[i]));
		
		func(board, n, 0, 0);
		
		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(int[][] board, int n, int x, int y) {
		boolean flag = false;
		
		
		int num = board[x][y];
		L : for(int i = x; i < x + n; i++) {
			for(int j = y; j < y + n; j++) {
				if(board[i][j] != num) {
					flag = true;
					break L ;
				}
			}
		}
		
		if(flag) {
			sb.append("(");
			func(board,n/2, x + 0, y + 0);
			func(board,n/2, x + 0, y + n/2);
			func(board,n/2, x + n/2, y + 0);
			func(board,n/2, x + n/2, y + n/2);
			sb.append(")");
		} else {
			if(num == 0)
				sb.append(0);
			else if (num == 1) 
				sb.append(1);
		}
	}

}
