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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());

		boolean[][] star = new boolean[n][n];

		func(star, n, 0, 0);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(star[i][j] == false)
					sb.append("*");
				else 
					sb.append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		////////////////////////////////////////////////////
		br.close();
	}

	static void func(boolean[][] star, int n, int x, int y) {
		if (n == 1)
			return;

		func(star, n / 3, x, y);
		func(star, n / 3, x, y + n / 3);
		func(star, n / 3, x, y + n / 3 * 2);
		func(star, n / 3, x + n / 3, y);

		for (int i = x + n / 3; i < x + n / 3 * 2; i++) {
			for (int j = y + n / 3; j < y + n / 3 * 2; j++)
				star[i][j] = true;
		}

		func(star, n / 3, x + n / 3, y + n / 3 * 2);
		func(star, n / 3, x + n / 3 * 2, y);
		func(star, n / 3, x + n / 3 * 2, y + n / 3);
		func(star, n / 3, x + n / 3 * 2, y + n / 3 * 2);

	}

}
