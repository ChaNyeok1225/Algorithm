import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine()); // 영상의 크기 N 입력
		
		int[][] board = new int[n][n]; // 영상 크기에 맞는 배열 선언
		
		for(int i = 0; i < n; i++) { // 영상 입력
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < n; j++) 
				board[i][j] = ch[j] - '0';
		}
		
		func(board, n, 0, 0); // 분할정복법
		
		System.out.println(sb); // 출력
		
		br.close();
	}

	static void func(int[][] board, int n, int x, int y) {
		
		boolean flag = false; 					// 형식이 맞는지 확인
		
		int num = board[x][y]; 					// 첫번째 수를 가지고
		L : for(int i = x; i < x + n; i++) { 	// 나머지 공간을 비교하면서 모두 같은지 비교
			for(int j = y; j < y + n; j++) {
				if(board[i][j] != num) { 		// 같지 않으면 break
					flag = true;
					break L ;
				}
			}
		}
		
		if(flag) {				// 모든 숫자가 같지 않다면 4분할
			sb.append("(");
			func(board,n/2, x + 0, y + 0);
			func(board,n/2, x + 0, y + n/2);
			func(board,n/2, x + n/2, y + 0);
			func(board,n/2, x + n/2, y + n/2);
			sb.append(")");
		} else {	
			if(num == 0)		// 모든 숫자가 같고 그 숫자가 0이면 출력에 0 추가
				sb.append(0);
			else if (num == 1) 	// 모든 숫자가 같고 그 숫자가 1이면 출력에 0 추가
				sb.append(1);
		}
	}

}
