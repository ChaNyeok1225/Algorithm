import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//////////////////////구현부/////////////////////////
		
		int N = Integer.parseInt(br.readLine());

		Map<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			bw.write(map.getOrDefault(n, 0) + " ");
		}
		
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
