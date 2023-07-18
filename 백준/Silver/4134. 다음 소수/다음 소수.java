import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int i = 0; i < T; i ++) {
			long n = Long.parseLong(br.readLine());
			
			n = n < 2? 2 : n;
			
			long res = 0;
			while (res == 0) {
				long j;
				long lim = (long)Math.sqrt(n);
				for(j = 2; j <= lim; j++) {
					if(n % j == 0)
						break;
				}
				if(j == (lim + 1))
					res = n;
				n++;
				
			}
			bw.write(String.valueOf(res) + "\n");
			bw.flush();
			
		}
		
		
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}


}
