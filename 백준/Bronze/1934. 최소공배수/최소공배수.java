import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/////////////// 구현부/////////////////

		// 1. 입력 받기
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			// 2. 최대 공약수 구하는 함수

			int gcd = func(A, B);
			// 3. 두 수의 곱 나누기 최대 공약수
			
			bw.write(String.valueOf(A * B / gcd) + "\n");
			

			bw.flush();
		}
		//////////////////////////////////////

		br.close();
		bw.close();

	}

	static int func(int a, int b) {
		int tmp;
		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}

}
