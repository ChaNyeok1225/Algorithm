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
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		A *= b;
		A += a * B;
		B *=b ;
		
		// 2. 최대 공약수 구하는 함수

		int gcd = func(A, B);
		// 3. 두 수의 곱 나누기 최대 공약수

		bw.write(String.valueOf(A / gcd) + " " + String.valueOf(B / gcd));

		bw.flush();

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
