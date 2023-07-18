import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/////////////// 구현부/////////////////

		// 1. 입력 받기
		st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		// 2. 최대 공약수 구하는 함수
		long gcd = func(A, B);
		// 3. 두 수의 곱 나누기 최대 공약수

		bw.write(String.valueOf((long)A*B/gcd));

		bw.flush();

		//////////////////////////////////////

		br.close();
		bw.close();

	}

	static long func(long a, long b) {
		long tmp;
		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}

}
