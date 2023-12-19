import java.io.*;
import java.util.*;

//start	2023. 12. 19  11 : 54
//end 	2023. 12. 19  12 : 23
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		while (T-- != 0) { // 테케 반복

			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			int[] in = new int[m + 1]; // 진입차수
			int[] level = new int[m + 1]; // 노드별 레벨
			boolean[] up = new boolean[m + 1];

			List<Integer>[] graph = new ArrayList[m + 1]; // 인접 리스트
			for (int i = 1; i < m + 1; i++) // 초기화
				graph[i] = new ArrayList<Integer>();

			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph[from].add(to); // 연결
				in[to]++; // 진입차수 증가
			}

			Queue<Integer> q = new ArrayDeque<>(); // 순회 큐

			for (int i = 1; i < m + 1; i++) { // 노드 탐색
				if (in[i] == 0) { // 진입차수가 0인 노드
					q.offer(i); // 큐에 삽입
					level[i] = 1; // 레벨은 1
				}
			}

			int ans = 1;
			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int nxt : graph[cur]) {
					in[nxt]--; // 진입차수 감소

					if (level[nxt] == level[cur]) // 이미 노드 레벨이 같으면 레벨 증가
						up[nxt] = true;
					else if (level[nxt] < level[cur]) {// 낮으면 레벨 동일하게
						up[nxt] = false;
						level[nxt] = level[cur];
					}

					if (in[nxt] == 0) { // 진입차수가 0 이면 큐에 삽입
						q.offer(nxt);
						if (up[nxt])
							level[nxt]++;
						ans = ans > level[nxt] ? ans : level[nxt];
					}
				}

			}
			sb.append(k).append(" ").append(ans).append("\n");
		}

		System.out.print(sb);

	}
}