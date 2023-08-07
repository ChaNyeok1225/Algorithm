import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		// 10번 실행
		for(int tc = 1; tc < 11; tc++) {
			
			// Input
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> password = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++)
				password.add(Integer.parseInt(st.nextToken()));
			
			int m = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " I");
			
			// 명령어로 받은 숫자들을 저장하고 index에 addAll
			for(int i = 0; i < m; i++) {
				int index = Integer.parseInt(st.nextToken());
				
				int k = Integer.parseInt(st.nextToken());
				
				
				LinkedList<Integer> ins = new LinkedList<>();
				for(int j = 0; j < k; j++) 
					ins.add(Integer.parseInt(st.nextToken()));
				
				
				password.addAll(index, ins);
			}
			
			sb.append("#"+tc+" ");
			for(int i = 0; i < password.size() && i < 10; i++)
				sb.append(password.get(i)+ " ");
			sb.append("\n");
		}
		System.out.print(sb);
		////////////////////////////////////////////////////
		br.close();

	}

}
