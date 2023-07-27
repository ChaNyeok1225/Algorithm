import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] board = new int[150000];
		LinkedList<Integer> q = new LinkedList<>();
		
		Arrays.fill(board, -1);
		board[n] = 0;
		q.add(n);
		
		while(!q.isEmpty()) {
			int p = q.pop();
			
//			System.out.println("p : " + p +", time : " + board[p]);
			if(p == k)
				break;
			
			if(2*p < board.length && board[2*p] < 0) {
				board[2*p] = board[p];
				q.addFirst(2*p);
			}
			
			if(p - 1 >= 0 && board[p-1] < 0) {
				board[p-1] = board[p] + 1;
				q.add(p-1);
			}
			
			if(p + 1 < board.length && board[p+1] < 0) {
				board[p+1] = board[p] + 1;
				q.add(p+1);
			}
			

		}
		
		System.out.println(board[k]);
		
		////////////////////////////////////////////////////
		br.close();
	}


}
