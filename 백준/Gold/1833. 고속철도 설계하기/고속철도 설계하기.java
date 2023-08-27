import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] p;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int[][] graph = new int[n + 1][n + 1];
		ArrayList<int[]> edge = new ArrayList<>();
		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) 
				graph[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < n +1; i++)
			for(int j = i+1; j < n+1; j++)
				edge.add(new int[] {graph[i][j],i,j});
		Collections.sort(edge, (a,b) -> a[0]-b[0]);
		
		p = new int[n+1];
		for(int i = 1; i < n +1;i++)
			p[i] = i;
		
		int total = 0, cnt = 0, idx =0;
		for(int i = 0; i < edge.size(); i++) {
			int[] e = edge.get(i);
			
			if(e[0] < 0) {
				total -= e[0];
				union(e[1], e[2]);
			} else {
				if(find(e[1]) != find(e[2])) {
					total += e[0];
					cnt++;
					union(e[1],e[2]);
					sb.append(e[1] + " " + e[2] + "\n");
				}
			}
		}
		
		System.out.println(total + " " + cnt);
		System.out.print(sb);
		
	}
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
		
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		p[b] = a;
	}

}
