import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] friends = new ArrayList[n+1];
		
		for(int i = 0; i < n+1; i++)
			friends[i] = new ArrayList<>();
		
		int[] score = new int[n+1];
		
		int min = Integer.MAX_VALUE;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			
			if(p1==-1 && p2==-1)
				break;
			
			friends[p1].add(p2);
			friends[p2].add(p1);
		}
		
		int[] dep = new int[n+1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i = 1; i < n + 1; i++) {
			Arrays.fill(dep, -1);
			
			q.offer(i);
			dep[i] = 0;
			
			while(!q.isEmpty()) {
				int v = q.poll();
				
				for(int nv : friends[v]) {
					if(dep[nv] == -1) {
						dep[nv] = dep[v] + 1;
						q.offer(nv);
					}
				}
			}
			
			int sc = 0;
			for(int j = 1; j < n +1; j++)
				if(dep[j] > sc)
					sc = dep[j];
			
			score[i] = sc;
			if(min > sc)
				min = sc;
		}
		
		int cnt = 0;
		for(int i = 1; i < n+1;i++) {
			if(score[i]==min) {
				cnt++;
				sb.append(i + " ");
			}
		}
		
		System.out.println(min + " " + cnt);
		System.out.println(sb);
	}
	
}
