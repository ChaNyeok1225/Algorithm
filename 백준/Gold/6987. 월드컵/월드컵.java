import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] arr = new int[6][3]; // 경기 결과 배열
	static boolean flag;				// 올바른지 확인, 결과를 확인했으면 나머지 가지치기용
	static int ans;						// 결과

	public static void main(String[] args) throws IOException {
		int sum; // 경기 수 확인
		
		for (int t = 0; t < 4; t++) { // 테케 4가지
			ans = 0;					// 결과 0으로 초기화
			flag = false;				// 플래그 false 초기화
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				sum = 0;
				for (int j = 0; j < 3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];
				}

				if (sum != 5) // 팀마다 경기 수가 5가 아니면 올바르지 않음
					flag = true;
			}

			if (!flag)			// 팀마다 5개 확인되었다면 백트래킹
				dfs(0, 0, 1);

			System.out.print(ans + " "); // 결과 출력
		}
	}

	static void dfs(int idx, int cnt, int m) {
		if(flag) return; // 결과가 나왔다면 가지치기

		if (cnt == 15) { // 총 경기가 15개로 완료되었다면
			ans = 1;		// 출력은 1
			flag = true;	// 가지치기 활성화
			return;
		}

		if (arr[idx][0] + arr[idx][1] + arr[idx][2] == 0) 	// 지금 결과를 확인하는 팀의 승무패가 모두 0이라면
			dfs(idx + 1, cnt, idx + 2);	// 다음 팀, 동일한 매치경기 수, 그 다음팀들부터 확인
		else 
			for (int i = 0; i < 3; i++) 					// 0: 승, 1: 무, 2: 패
				for (int j = m; j < 6; j++) 				// 지금 팀의 아래쪽 팀들을 확인
					
					if (arr[idx][i] > 0 && arr[j][2 - i] > 0) {	// 내 승,무,패가 0보다 크고 확인하는 팀의 패,무,승이 0보다 크면
						
						arr[idx][i]--;				// 둘다 감소
						arr[j][2 - i]--;
						
						dfs(idx, cnt + 1, j + 1); // 같은 팀, 매치경기 + 1, 중복 경기 제거를 위해 j+1 팀부터 확인
					
						arr[idx][i]++;				// 복원
						arr[j][2 - i]++;
					}
	}
}
