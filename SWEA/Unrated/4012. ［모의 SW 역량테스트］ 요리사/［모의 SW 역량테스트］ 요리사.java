import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[][] ing = new int[20][20];
	
	
	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 횟수

		for (int tc = 1; tc < T + 1; tc++) { // T번 반복
			
			int n = Integer.parseInt(br.readLine()); // 재료의 개수
			
			// 재료 입력
			for(int i = 0; i < n; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					ing[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 부분집합 바이너리 카운팅 (A, B 요리를 선택하는 것이기 때문에 대칭 배제를 위해 n-1)
			int noc = 1 << n-1;
			int min = Integer.MAX_VALUE;
			int tmp, sel;
			int[] group = new int[2];
		
			for(int c = 0; c < noc; c++) { // 0 부터 noc까지
				tmp = c;
				group[0] = group[1] = 0; // 맛 초기화
				for(int i = 0; i < n; i++) { // 재료 선택
					
					sel = (tmp & 1 << i) != 0? 1 : 0; // 어디 음식에 속하는지 비트 마스킹 검정
					
					for(int j = i + 1; j < n; j++) { // 다른 재료가 어느 음식에 속하는지 비트 마스킹 검정
						
						if(((tmp & 1 << j) != 0? 1 : 0) == sel) { // 같다면 그룹에 더해줌
//							System.out.println(sel + "+ " + i + ", " + j + " = " +ing[i][j] + " " + ing[j][i]);
							group[sel] += ing[i][j] + ing[j][i];
						}
						
					}
				}
				
//				System.out.println(group[0] + " vs " + group[1]);
				
				if(Math.abs(group[0] - group[1]) < min)
					min = Math.abs(group[0] - group[1]);
				
			}
			
			System.out.printf("#%d %d\n",tc,min);
		}

	}
	
}
