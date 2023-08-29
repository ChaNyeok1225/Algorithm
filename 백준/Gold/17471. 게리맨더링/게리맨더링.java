import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] state, group, vis;
	static int n, ans = Integer.MAX_VALUE;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q = new ArrayDeque<Integer>();

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		state = new int[n + 1]; // 지역구의 인원 수를 담을 배열
		group = new int[n + 1]; // 나눈 그룹을 담을 배열
		vis = new int[n + 1];	// bfs 방문 체크 배열
		graph = new ArrayList[n + 1]; // 인접 리스트
		for (int i = 1; i < n + 1; i++)//인접 리스트 초기화
			graph[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine()); // 지역구 인원수 입력
		for (int i = 1; i < n + 1; i++)
			state[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < n + 1; i++) { // 그래프 입력
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph[i].add(a);
			}
		}

		group[1] = 1; // 불필요한 연산의 낭비를 막기 위해서 1번 지역구는 항상 1번 그룹으로
		makeGroup(2); // 2번 지역구부터 그룹 지정
		
		if(ans == Integer.MAX_VALUE) ans = -1; // 두 개의 지역구로 나눌 수 없으면 -1로
		System.out.println(ans); // 출력

	}

	private static void makeGroup(int idx) {
		if (idx == n + 1) { // 모든 지역구를 나눴다면

			if(chkAdj()) {  // 지역구들이 서로 인접한지 체크하는 메소드 실행
				int teamA = 0;
				int teamB = 0;
				
				for(int i = 1; i < n +1; i++) { // 각 그룹별로 인원 수 차이 체크하여 저장
					if(group[i] == 1)
						teamA += state[i];
					else
						teamB += state[i];
				}
				// 결과 값 저장
				ans = Math.min(ans , Math.abs(teamA - teamB));
			}
			return;
		}

		group[idx] = 1;		// 1번 그룹이거나
		makeGroup(idx + 1);
		group[idx] = 2;		// 2번 그룹으로
		makeGroup(idx + 1);

	}

	private static boolean chkAdj() { // 인접체크
		Arrays.fill(vis, 0); // 방문체크 배열 0으로 초기화
		
        int cnt = 0; // 몇 개의 그룹으로 나눠지는지 체크
        
		for (int i = 1; i < n + 1; i++) { // 1번부터 n번 지역구까지
			if (vis[i] != 0) // 이미 한 그룹에 속하는 것으로 체크 됐다면 continue
				continue;
            if(cnt > 1)		 // 그룹 방문체크가 2회를 넘었다면 (그룹이 3개 이상이 된다면)
                return false;// return false
            
            cnt++;			 // 그룹 수 증가
			vis[i] = i;		 // 방문체크에 그룹 번호 부여
			q.offer(i);      // 그래프 bfs
			
			while (!q.isEmpty()) { // 큐가 빌 때까지
				int cv = q.poll();

				for (int nv : graph[cv]) { // 인접한 정점을 꺼내서
					// 이미 방문한 적 있거나 해당 정점이 속하는 그룹이 나의 그룹과 다르면 continue
					if (group[nv] != group[cv] || vis[nv] != 0)
						continue;
					
					vis[nv] = i; //  그룹이 같고 인접하면 offer
					q.offer(nv);
				}
			}
		}
        
        return true; // 2번이하로 for문을 벗어났다면(그룹이 2개이하라면) true
	}

}
