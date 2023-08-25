import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] board = new int[9][9];
	static ArrayList<int[]> bp = new ArrayList<>();
	static boolean[] nums = new boolean[10];
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {

		for(int i = 0; i < 9; i++) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				board[i][j] = ch[j] - '0';
				if(board[i][j] == 0) {
					bp.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(flag) return;
		
		
		if(idx == bp.size()) {
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			flag = true;
			
			return;
		}
		
		
		for(int i = 1; i < 10; i++) {
			int[] p = bp.get(idx);
			
			board[p[0]][p[1]] = i;
			
			if(chkBoard(p[0],p[1])) 
				dfs(idx + 1);
			
			board[p[0]][p[1]] = 0;
		}
		
	}

	private static boolean chkBoard(int x, int y) {
		setFalse();
		
		for(int i = 0; i < 9; i++) {
			if(board[x][i]==0) continue;
			
			if(nums[board[x][i]])
				return false;
			else
				nums[board[x][i]] = true;
		}
		
		setFalse();
		
		for(int i = 0; i < 9; i++) {
			if(board[i][y] == 0) continue;
			
			if(nums[board[i][y]])
				return false;
			else
				nums[board[i][y]] = true;
		}
		
		setFalse();
		
		int px = x/3 * 3;
		int py = y/3 * 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(board[px+i][py+j] == 0) continue;
				
				if(nums[board[px+i][py+j]])
					return false;
				else
					nums[board[px+i][py+j]] = true;
				
			}
		}
		
		return true;
	}
	
	public static void setFalse() {
		for(int i = 1; i < 10; i++)
			nums[i] = false;
	}

}
