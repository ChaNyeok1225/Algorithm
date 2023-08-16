import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		char[][] board = new char[n][n];
		ArrayList<int[]> blank = new ArrayList<>();
		ArrayList<int[]> teacher = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = st.nextToken().charAt(0);

				if (board[i][j] == 'X')
					blank.add(new int[] { i, j });
				else if (board[i][j] == 'T')
					teacher.add(new int[] {i, j});
			}
		}

		boolean[] sel = new boolean[blank.size()];
		Arrays.fill(sel, sel.length - 3, sel.length, true);
		
		boolean flag;

		do {
			flag = true;
			
			
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					int[] p = blank.get(i);
					board[p[0]][p[1]] = 'W';
				}
			}
			
			for(int i = 0; i < teacher.size(); i++) {
				int[] p = teacher.get(i);
				
				for(int dir = 0; dir < 4; dir++) {
					int nx = p[0];
					int ny = p[1];
					
					while(flag) {
						nx += dx[dir];
						ny += dy[dir];
						
						if(nx < 0 || ny < 0 || n <= nx || n <= ny)
							break;
						if(board[nx][ny] == 'W')
							break;
						
						if(board[nx][ny] == 'S') {
							flag = false;
							break;
						}
						
					}
					
				}
				
			}
			
			if(flag)
				break;
			
			for(int i = 0; i < sel.length; i++) {
				if(sel[i]) {
					int[] p = blank.get(i);
					board[p[0]][p[1]] = 'X';
				}
			}
			
		} while (np(sel));

		
		if(flag)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}

	private static boolean np(boolean[] sel) {
		int i, j, k;
		i = j = k = sel.length - 1;
		
		while(i >0 &&!(!sel[i-1] && sel[i]) )
			i--;
		
		if(i == 0)
			return false;
		
		while(!sel[j])
			j--;
		
		sel[i-1] = true;
		sel[j] = false;
		
		while(i < k) 
			swap(sel, i++, k--);
			
		return true;
	}

	private static void swap(boolean[] sel, int i, int j) {
		boolean tmp = sel[i];
		sel[i] = sel[j];
		sel[j] = tmp;
	}
}
