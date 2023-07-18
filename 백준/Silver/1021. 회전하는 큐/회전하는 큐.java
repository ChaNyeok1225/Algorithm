import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++)
			deque.add(i);
		
		int res = 0, cnt = 0;
		int ele;
		for(int num : nums) {
			cnt = 0;
			ele = deque.pollFirst();
			
			while(ele != num) {
				deque.add(ele);
				cnt++;
				ele = deque.pollFirst();
			}
			res += Math.min(cnt, deque.size() + 1 - cnt);
		}
		
		System.out.println(res);
		
		////////////////////////////////////////////////////
		br.close();

	}

}
