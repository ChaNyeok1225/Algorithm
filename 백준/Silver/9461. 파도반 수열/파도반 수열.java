import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

        // 틀렸던 이유, 범위 확인
        // 최대로 나올만한 예제를 넣어보자
		long[] D = new long[101];

		D[1] = 1; D[2] = 1; D[3] = 1;
		D[4] = 2; D[5] = 2;

		for(int i = 6; i < 101; i++) {
			D[i] = D[i-1] + D[i-5];
		}
		
		while(T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(D[n]);
		}
		
	}

}
