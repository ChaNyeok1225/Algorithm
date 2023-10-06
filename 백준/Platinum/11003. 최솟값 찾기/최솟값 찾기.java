import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(q.isEmpty() || q.peek()[0] >= num) {
				q.clear();
				q.offer(new int[] {num, i});
			} else  {
				while(!q.isEmpty() && q.peekLast()[0] >= num)
					q.pollLast();
				q.offer(new int[] {num, i});
			}
			
			while(!q.isEmpty() && q.peek()[1] < i-l+1)
				q.poll();
			
			sb.append(q.peek()[0]).append(" ");
		}
		System.out.println(sb);
	}
	
}