import java.io.*;
import java.util.*;

public class Main {

	static int[][] board, tmp;
	static ArrayList<int[]> ac = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		
		int n = Integer.parseInt(br.readLine());
		
		int[] time = new int[n+1];
		int[] inDegree = new int[n+1];
		ArrayList<Integer>[] rel = new ArrayList[n+1];
		for(int i = 1; i < n +1 ; i++)
			rel[i] = new ArrayList<>();
		
		for(int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			time[i] = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < m; j++) {
				int f = Integer.parseInt(st.nextToken());
				inDegree[i]++;
				rel[f].add(i);
			}
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
		
		int res = 0;
		for(int i = 1; i < n + 1; i++) 
			if(inDegree[i] == 0)
				q.offer(new int[] {i, time[i]});
		
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			res = cur[1];
			
			for(int nxt : rel[cur[0]]) {
				inDegree[nxt]--;
				
				if(inDegree[nxt] == 0) 
					q.offer(new int[] {nxt, cur[1] + time[nxt]});
			}
		}
		
		System.out.println(res);
	}

}