import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int[] board;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		
		
		int n = Integer.parseInt(br.readLine());
		
		board = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n+1; i++)
			board[i] = Integer.parseInt(st.nextToken());
		
		bt(1);
		
		if(flag)
			System.out.println(sb);
		else
			System.out.println(-1);
		
	}
	
	static void bt(int idx) {
		if(flag) return;
		
		if(idx == board.length) {
			
			for(int i = 1; i < board.length; i++)
				sb.append(board[i]).append(" ");
			flag = true;
			return;
		}
		
		
		if(board[idx] != 0) {
			bt(idx+1);
			return;
		}
		
		for(int i = 1; i < board.length; i++)  {
			
			if(chk(idx , i)) {
				board[idx] = i;
				bt(idx+1);
				board[idx] = 0;
			}
			
			
		}
		
	}
	
	static boolean chk(int idx, int val) {
		
		for(int i = 1; i < board.length; i++) {
			if(board[i] == 0)
				continue;
			if(board[i] == val)
				return false;
			if((idx+val) == i + board[i])
				return false;
			if((idx-val) == i - board[i])
				return false;
		}
		return true;
	}
	
}