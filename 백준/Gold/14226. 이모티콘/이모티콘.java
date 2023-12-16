import java.io.*;
import java.util.*;

//start	2023. 12. 16  14 : 27
//end	2023. 12. 16  14 : 47
public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		boolean[] vis = new boolean[n + 10];

		Queue<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] { 1, 0, 0 }); // 이모티콘 수, 시간, 클립보드 저장된 이모티콘
		
		int ans = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == n) { // 정답을 찾았으면 BREAK;
				ans = cur[1];
				break;
			}
			int time = cur[1] + 1; 
			
			if(!vis[cur[0]]) { // 복사 
				vis[cur[0]] = true;
				q.offer(new int[] { cur[0], time, cur[0] });
			}
			if(cur[0] + cur[2] < n + 10) // 붙여넣기
				q.offer(new int[] { cur[0] + cur[2], time, cur[2] });
			if(cur[0] - 1 > 0) // 빼기
				q.offer(new int[] { cur[0] - 1, time, cur[2] });
		}

		System.out.println(ans);

	}
}