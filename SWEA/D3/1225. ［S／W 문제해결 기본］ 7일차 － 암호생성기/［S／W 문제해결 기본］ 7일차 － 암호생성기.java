import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		
		ArrayDeque<Integer> ad = new ArrayDeque<>();

		for(int tc = 1; tc < 11; tc++) {
			br.readLine();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++)
				ad.addLast(Integer.parseInt(st.nextToken()));
			
			int sub = 1;
			
			// 반복문
			while(true) {
				// sub보다 작으면 0으로 유지해서 프로그램 종료
				if(ad.peekFirst() <= sub) {
					ad.pollFirst();
					ad.addLast(0);
					break;
				}
				// 아니라면 sub만큼 뺴서 뒤에 추가
				else { 
					ad.addLast(ad.pollFirst() - sub++);
				}
				
				// 사이클 초기화
				if(sub > 5) sub = 1;
			}
			
			sb.append("#"+tc + " ");
			while(!ad.isEmpty()) {
				sb.append(ad.pollFirst()+ " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
