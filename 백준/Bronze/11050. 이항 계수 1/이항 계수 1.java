import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int a = 1, b = 1;
		for(int i = 0; i < K; i++) {
			a *= (N-i);
			b *= (K-i);
		}
		bw.write(String.valueOf(a/b));
		
		bw.flush();
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}


}
