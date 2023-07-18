import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////구현부/////////////////
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> nameset = new HashSet<>();
		
		for(int i = 0; i < N; i++) 
			nameset.add(br.readLine());
		
		int cnt = 0;
		List<String> name = new ArrayList<>();
		for(int i = 0; i < M; i++) {
			String n = br.readLine();
			
			if(nameset.contains(n)) {
				name.add(n);
				cnt++;
			}
				
		}
		
		Collections.sort(name);
		
		bw.write(cnt + "\n");
		for(int i = 0; i < name.size(); i++)
			bw.write(name.get(i) + "\n");
		
		bw.flush();
		//////////////////////////////////////
		
		br.close();
		bw.close();
		
	}
	
}
