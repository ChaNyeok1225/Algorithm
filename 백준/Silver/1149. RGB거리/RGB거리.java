import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); // 집의 수 n
		
		int[][] cost = new int[n][3]; // 0 ~ n-1 번의 집을 빨강, 초록, 파랑으로 칠하는 비용
		
		for(int  i = 0; i < n; i++) { // 비용 입력
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// [0: 빨강으로, 1: 초록으로, 2: 파랑으로 ] 칠 했을 떄의 최솟 값
		int[][] D = new int[n][3];
		
		// 0번째 집을 칠 했을 때의 비용 지정
		D[0][0] = cost[0][0]; // 빨간색으로
		D[0][1] = cost[0][1]; // 초록색으로
		D[0][2] = cost[0][2]; // 파란색으로
		
		for(int i = 1; i < n; i++) { // 1번 집부터 n-1집까지
			// 해당 색으로 칠하는 비용 + 나와 다른 색을 가진 집 중 최소를 선택
			D[i][0] = Math.min(D[i-1][1], D[i-1][2]) + cost[i][0]; 
			D[i][1] = Math.min(D[i-1][0], D[i-1][2]) + cost[i][1];
			D[i][2] = Math.min(D[i-1][0], D[i-1][1]) + cost[i][2];
		}
		
		// 각 색중 가장 비용이 적게든 값 선택하여 출력
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++)
			if(D[n-1][i] < min)
				min = D[n-1][i];
		System.out.println(min);
	}
}
