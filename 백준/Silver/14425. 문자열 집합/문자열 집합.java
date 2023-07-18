import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		//////////////////////구현부/////////////////////////
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int res = 0;
		
		for(int i = 0; i < M; i++) {
			if(set.contains(br.readLine())) {
				res++;
			}
		}
		
		
		bw.write(String.valueOf(res));
		
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
