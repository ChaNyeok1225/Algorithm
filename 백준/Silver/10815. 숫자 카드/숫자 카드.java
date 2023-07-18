import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//////////////////////구현부/////////////////////////
		
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int[] res = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				res[i] = 1;
			}
			else {
				res[i] = 0;
			}
				
		}
		
		for(int i = 0; i < M; i++)
			bw.write(res[i] + " ");
		
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
