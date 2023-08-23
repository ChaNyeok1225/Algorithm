import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] state, group, vis;
	static boolean[] chk;
	static int n, ans = Integer.MAX_VALUE;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		state = new int[n + 1];
		group = new int[n + 1];
		vis = new int[n + 1];
		chk = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++)
			state[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph[i].add(a);
			}
		}

		group[1] = 1;
		makeGroup(2);
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);

	}

	private static void makeGroup(int idx) {
		if (idx == n + 1) {

			if(chkAdj()) {
//				System.out.println("IN!! : "+ Arrays.toString(vis));
				int teamA = 0;
				int teamB = 0;
				
				for(int i = 1; i < n +1; i++) {
					if(group[i] == 1)
						teamA += state[i];
					else
						teamB += state[i];
				}
				
				ans = Math.min(ans , Math.abs(teamA - teamB));
				
			}

			return;
		}

		group[idx] = 1;
		makeGroup(idx + 1);
		group[idx] = 2;
		makeGroup(idx + 1);

	}

	private static boolean chkAdj() {
		Arrays.fill(vis, 0);
		Arrays.fill(chk, false);

		for (int i = 1; i < n + 1; i++) {
			if (vis[i] != 0)
				continue;
			vis[i] = i;
			q.offer(i);
			int team = group[i];
			while (!q.isEmpty()) {
				int cv = q.poll();

				for (int nv : graph[cv]) {
					if (group[nv] != team || vis[nv] != 0)
						continue;
					vis[nv] = i;
					q.offer(nv);
				}
			}
		}
		
//		System.out.println("group : " + Arrays.toString(group));
//		System.out.println(Arrays.toString(vis));

		int cnt = 0;
		for (int i = 1; i < n + 1; i++) {
			if(!chk[vis[i]]) {
				chk[vis[i]] = true;
				cnt++;
			}
		}

		if(cnt==2)
			return true;
		else
			return false;
	}

}
