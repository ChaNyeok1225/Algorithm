import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] vip = new int[m + 2];

		for (int i = 1; i < m + 1; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		vip[m + 1] = n + 1;

		int[] D = new int[41];
		D[0] = 1;
		D[1] = 1;
		D[2] = 2;
		for (int i = 3; i < n+1; i++)
			D[i] = D[i - 1] + D[i - 2];

		int total = 1;
		for (int i = 1; i < m + 2; i++) {
			total *= D[vip[i] - vip[i-1] - 1];
		}

		System.out.println(total);
	}

}
