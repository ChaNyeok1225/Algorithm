import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		// 스위치 배열 크기 입력
		int n = Integer.parseInt(br.readLine());

		// 스위치 on, off를 나타내는 boolean 배열 선언
		// ture == on, false == off
		boolean[] switchs = new boolean[n+1];

		// 배열의 크기 만큼 1이면 true, 0이면 false로 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if (st.nextToken().equals("1"))
				switchs[i+1] = true;
			else
				switchs[i+1] = false;
		}

		// 인원 수 입력
		int m = Integer.parseInt(br.readLine());

		
		// m번 반복
		while (m-- > 0) {
			
			// 성별, 스위치 번호 입력
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 성별의 경우에 따라 switch로 분기
			switch (g) {

			// 남자라면
			case 1:
				
				// num의 배수 인덱스들을 ! 연산
				for (int i = num; i < n + 1; i += num)
					switchs[i] = !switchs[i];
				break;

			// 여자라면
			case 2:
				
				// 서로 대칭 거리 스위치를 확인할 step 변수 선언
				int step = 0;
				
				// break까지 계속 확인
				while (true) {
					
					// 확인하려는 인덱스가 배열의 범위를 넘어서면 break
					if(num-step <= 0 || num + step > n) break;
					
					// step만큼 떨어진 거리의 스위치들이 같은 상태인지 확인
					if (switchs[num - step] == switchs[num + step]) {
						
						// 같다면 ! 연산
						switchs[num-step] = switchs[num+step] = !switchs[num-step];
					}
					// 같지 않으면 break
					else
						break;
					
					// 다음 step 진행
					step++;
				}
				break;
			}
		}
		
		// 스위치 1번부터 n번까지 출력
		for(int i = 1; i < n + 1; i++) {
			// true면 1 출력, false면 0 출력
			if(switchs[i])
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
			
			// 한 줄에 20개의 스위치만 출력하기 위해서 개행
			if(i%20 == 0)
				sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}

}
