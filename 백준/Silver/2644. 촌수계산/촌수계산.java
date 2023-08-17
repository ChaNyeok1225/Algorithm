import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		st= new StringTokenizer(br.readLine());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());		
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		for(int i = 0; i < n+1; i++)
			list[i] = new ArrayList<>();
				
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int[] vis = new int[n+1];
		for(int i = 0; i < n + 1; i++)
			vis[i] = -1;
				
		q.offer(num1);
		vis[num1] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == num2)
				break;
			
			for(int c : list[cur]) {
				if(vis[c] > 0) continue ;
				vis[c] = vis[cur] + 1;
				q.offer(c);
			}
		}
		System.out.println(vis[num2]);
	}
}
