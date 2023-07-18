import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T + 1; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			boolean[] prime = new boolean[N+1];
			
			prime[0] = prime[1] = true;
			
			for(long i = 2; i <= N; i++) {
				if(prime[(int) i] == true)
					continue;
				for(long j = i*i; j <= N; j += i)
					prime[(int)j] = true;				
			}
			
			int s = N/2, e = N/2;
			
			int cnt = 0;
			while(s > 0 && e < N) {
				if(prime[s--] == false & prime[e++] == false)
					cnt++;
				
			}
			
			bw.write(String.valueOf(cnt) + "\n");
			
			bw.flush();
		}
		
		
		
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}


}
