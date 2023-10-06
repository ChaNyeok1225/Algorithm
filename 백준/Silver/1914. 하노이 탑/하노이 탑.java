import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		System.out.println(new BigInteger("2").pow(n).subtract(new BigInteger("1")));
		if (n <= 20) {
			func(n, 1, 3);
			System.out.println(sb);
		}
		br.close();
	}

	static void func(int k, int a, int b) {
		if (k == 0)
			return;

		func(k - 1, a, 6 - a - b);
		sb.append(a + " " + b + "\n");
		func(k - 1, 6 - a - b, b);
	}

}