import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		
		int p = Integer.parseInt(br.readLine());
		
		boolean vis[] = new boolean[n+1];
		
		HashMap<Integer, List<Integer>> hm = new HashMap<>();
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if(!hm.containsKey(n1))
				hm.put(n1, new ArrayList<>());
			if(!hm.containsKey(n2))
				hm.put(n2, new ArrayList<>());
			
			hm.get(n1).add(n2);
			hm.get(n2).add(n1);
		}
		
		int cnt = 0;
		vis[1] = true;
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(1);
		
		while(!q.isEmpty()) {
			int t = q.poll();
			
			List<Integer> list = hm.get(t);
			if(list == null)
				continue;
			
			for(int i = 0; i < list.size(); i++) {
				int tn = list.get(i);
				
				if(vis[tn])
					continue;
				
				q.offer(tn);			
				vis[tn] = true;
				cnt++;
				
			}
			
		}
		
		System.out.println(cnt);
	}

}