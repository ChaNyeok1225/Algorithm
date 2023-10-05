import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 인원 수
		int m = Integer.parseInt(st.nextToken()); // 비교 횟수

		ArrayList<Integer>[] ingraph = new ArrayList[n + 1]; // 작은 관계를 담는 그래프
		ArrayList<Integer>[] outgraph = new ArrayList[n + 1]; // 큰 관계를 담는 그래프
		for (int i = 1; i < n + 1; i++) {
			ingraph[i] = new ArrayList<>();
			outgraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a < b
			ingraph[b].add(a); 
			outgraph[a].add(b);
		}

		boolean[] vis = new boolean[n+1]; // 방문 체크
		Queue<Integer> q = new ArrayDeque<Integer>();
		int res = 0; // 출력 답
		
		for (int i = 1; i < n + 1; i++) { // 1번 학생부터 확인
			int cnt = 1;
			vis[i] = true;
				
			q.offer(i);
			while(!q.isEmpty()) { // i번 학생보다 작은 학생 수 확인
				int c = q.poll();
				
				for(int nxt : ingraph[c]) {
					if(vis[nxt]) continue;
					vis[nxt] = true;
					q.offer(nxt);
					cnt++;
				}
			}
			
			q.offer(i);
			while(!q.isEmpty()) { // i번 학생보다 큰 학생 수 확인
				int c = q.poll();
				
				for(int nxt : outgraph[c]) {
					if(vis[nxt]) continue;
					vis[nxt] = true;
					q.offer(nxt);
					cnt++;
				}
			}
			
			if(cnt == n) // 모든 학생이 확인되었다면 값 증가
				res++;
				
			Arrays.fill(vis, false);
		}
		
		System.out.println(res); // 출력

		
	}
	
}