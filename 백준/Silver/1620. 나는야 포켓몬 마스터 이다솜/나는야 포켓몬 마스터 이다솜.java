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

		Map<String, Integer> namemap = new HashMap<>();
		Map<String, String> numbermap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			
			namemap.put(name, i+1);
			numbermap.put(String.valueOf(i+1), name);
		}
		
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			
			if(namemap.containsKey(s))
				bw.write(namemap.get(s) + "\n");
			else
				bw.write(numbermap.get(s) + "\n");
			
		}
		
		bw.flush();
		
		////////////////////////////////////////////////////
		br.close();
		bw.close();
		
	}

}
