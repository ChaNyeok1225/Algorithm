import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		boolean[][] board = new boolean[105][105]; // 색종이를 붙일 도화지
		
		int n = Integer.parseInt(br.readLine()); // 색종이의 수
		int cnt = 0; // 색종이가 붙은 영역을 셀 변수
		
		while(n-- > 0) {// n만큼 반복
			st = new StringTokenizer(br.readLine());  // 색종이의 x y 값 입력
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x + 10; i++)    // 색종이의 크기는 10 * 10, 도화지 밖으로 나가지 않는다.
				for(int j = y; j < y + 10; j++) 
					if(!board[i][j]) { // 아직 붙지 않은 영역이면
						cnt++;			// 영역 값 증가
						board[i][j] = true; // 붙었다고 표시
					}
				
		}
		
		System.out.println(cnt); // cnt 출력
	}

}