import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer,Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		
		int num;
		for(int i = 0; i < n; i++) {
			num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			map.put(num,i);
		}
		int val = Integer.parseInt(br.readLine());
		
		
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			if(map.containsKey(val - arr[i]) && i < map.get(val - arr[i]))
				cnt++;
			
		}
		
		
		System.out.println(cnt);
		////////////////////////////////////////////////////
		br.close();
	}

}
