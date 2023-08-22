import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[n + 1];
			for (int i = 1; i < n + 1; i++)
				graph[i] = new ArrayList<>();
			
			for(int i = 0; i < m ; i++) {
				 st= new StringTokenizer(br.readLine());
				 int a= Integer.parseInt(st.nextToken());
				 int b = Integer.parseInt(st.nextToken());
				 
				 graph[a].add(b);
				 graph[b].add(a);
			}
			
			int[] group = new int[n+1];
			boolean flag = true;
			
			Queue<Integer> q = new ArrayDeque<Integer>();
			L : for(int i = 1; i < n + 1; i++) {
				if(group[i] != 0) continue;
				
				q.offer(i);
				group[i] = 2;
				
				while(!q.isEmpty()) {
					int cv = q.poll();
					
					for(int nv : graph[cv]) {
						if(group[nv] == 0) {
							group[nv] = group[cv] ^ 1;
							q.offer(nv);
						} else {
							if(group[nv] == group[cv]) {
								flag = false;
								break L;
							} else
								continue;
						}
					}
				}
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
