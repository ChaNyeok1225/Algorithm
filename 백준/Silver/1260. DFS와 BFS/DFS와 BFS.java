import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	// BOJ 1260_ 인접리스트, 스택과 큐 자료구조를 통해 구현
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v= Integer.parseInt(st.nextToken());
		
		boolean[] visBfs = new boolean[n+1];
		boolean[] visDfs = new boolean[n+1];
		ArrayList<Integer>[] graph = new ArrayList[n+1];
		
		
		for(int i = 0; i < m ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(graph[a]==null)
				graph[a] = new ArrayList<>();
			if(graph[b] == null)
				graph[b] = new ArrayList<>();
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 1; i < n +1; i++) 
			if(graph[i] != null)
				Collections.sort(graph[i]);
		
		Stack<Integer> stack = new Stack<>();
		stack.add(v);
		
		while(!stack.isEmpty()) {
			int cv = stack.pop();
			
			if(visDfs[cv]) continue;
			
			visDfs[cv] = true;
			sb.append(cv + " ");
			
			if(graph[cv] != null) {
				for(int i = graph[cv].size()-1; i >= 0; i--)
					stack.add(graph[cv].get(i));
			}
		}
		
		sb.append("\n");
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		visBfs[v] = true;
		
		while(!q.isEmpty()) {
			int cv = q.poll();
			sb.append(cv + " ");
			
			if(graph[cv] != null)
				for(int nv : graph[cv]) {
					if(visBfs[nv]) continue;
					q.offer(nv);
					visBfs[nv] = true;
				}
			
		}
		
		
		System.out.println(sb);
		

	}

}
