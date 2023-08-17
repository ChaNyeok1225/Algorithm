import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static boolean flag;

	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());

		dfs(0);
	}

	static void dfs(int cnt) {
		if(flag) return;
		
		if (cnt == n) {
			System.out.println(sb);
			flag = true;
			return;
		}

		for (int i = 1; i < 4; i++) {
			sb.append(i);
			if (chkGood())
				dfs(cnt + 1);
			sb.setLength(sb.length() - 1);

		}

	}

	private static boolean chkGood() {

		for (int i = 1; i <= sb.length() / 2; i++) {
			if(sb.substring(sb.length()-2*i, sb.length()-i).equals(sb.substring(sb.length() - i, sb.length())))
				return false;
		}
		return true;
	}

}
