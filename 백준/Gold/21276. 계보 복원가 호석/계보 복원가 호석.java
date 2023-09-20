import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		
		HashMap<String,Integer> hm = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] graph = new ArrayList[n];		
		ArrayList<String>[] child = new ArrayList[n];
		int[] indegree = new int[n];
		
		st = new StringTokenizer(br.readLine());
		
		String[] names = new String[n];
		for(int i =0 ; i < n; i++) {
			names[i] = st.nextToken();
			graph[i] = new ArrayList<>();
			child[i] = new ArrayList<>();
		}
		Arrays.sort(names);
		
		for(int i =0 ; i < n; i++) {
			hm.put(names[i], i);
		}
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = hm.get(st.nextToken());
			int t = hm.get(st.nextToken());
			
			indegree[f]++;
			graph[t].add(f);
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		int cnt = 0;
		for(int i = 0;  i < n; i++) {
			if(indegree[i] == 0) {
				cnt++;
				sb.append(names[i]).append(" ");
				q.offer(i);
			}
		}sb.append("\n");
		
		
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int c : graph[p]) {
				indegree[c]--;
				
				if(indegree[c] == 0) {
					child[p].add(names[c]);
					q.offer(c);
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			sb.append(names[i]).append(" ");
			sb.append(child[i].size()).append(" ");
			Collections.sort(child[i]);
			for(int j = 0; j < child[i].size(); j++)
				sb.append(child[i].get(j)).append(" ");
			sb.append("\n");
		}
		
		System.out.println(cnt);
		System.out.print(sb);
		
	}
}