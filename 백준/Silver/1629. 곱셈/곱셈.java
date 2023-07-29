import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		long res = func(a, b, c);

		System.out.println(res);
		////////////////////////////////////////////////////
		br.close();
	}

	static long func(int a, int b, int c) {
		if (b == 1)
			return a % c;

		long num = func(a, b / 2, c) % c;
		num = num * num % c;
		if (b % 2 == 1)
			return num * a % c;
		else
			return num;
	}

}
