import java.util.*;
import java.io.*;

/*
 * BOJ 3040 백설 공주와 일곱 난쟁이
 * boolean 배열 넥퍼로 풀어보기
*/

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		int[] h = new int[9]; // 난쟁이의 키를 담을 배열

		// 키 입력
		for (int i = 0; i < 9; i++)
			h[i] = Integer.parseInt(br.readLine());

		// NextPermutation을 위한 배열
		boolean[] flag = new boolean[9];
		flag[7] = flag[8] = true; // 2개 선택

		// NextPermutation
		do {
			
			int sum = 0;
			for(int i = 0 ; i < 9; i++) { 
				if(!flag[i])     // 선택된 2개를 제외하고 덧셈
					sum += h[i];
			}
			
			if(sum == 100) { // 합이 100이면
				for(int i = 0; i < 9; i++) 
					if(!flag[i]) // 선택 안 된 7명 출력
						System.out.println(h[i]);
				
				return; // 답을 출력했으니 종료
			}
			
		} while (np(flag));

		////////////////////////////////////////////////////
		br.close();

	}

	// NextPermutation
	private static boolean np(boolean[] flag) {

		// 배열의 뒷부분부터
		int i = flag.length - 1;

		// 배열이 끝날 때까지, 또는 (i-1)False - (i)True를 찾을 때까지
		while (i > 0 && !(!flag[i - 1] && flag[i])) 
			i--; // i 감소
		
		// False - True가 없다면 종료
		if (i == 0)
			return false;

		// 배열의 끝부분부터
		int j = flag.length - 1;
		
		// True를 찾을 때까지 j 감소
		while(!flag[j])
			j--;
		
		// i-1을 true로 j를 false로
		flag[i-1] = true;
		flag[j] = false;
		
		
		// 배열의 끝부분부터
		int k = flag.length-1;
		
		// i와 k를 좁혀나가며 스왑해서 오름차순으로 만듦
		while(i < k) {
			boolean t = flag[i];
			flag[i] = flag[k];
			flag[k] = t;
			i++; k--;
		}

		return true;
	}

}
