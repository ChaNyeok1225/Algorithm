import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 버퍼리더 생성
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		dfs(10, 0);

		Collections.sort(list);
		
		if(n >= list.size())
			System.out.println(-1);
		else
			System.out.println(list.get(n));
	}

	private static void dfs(int prev, long num) {
		for (int i = 0; i < 10; i++) {
			if (i < prev) {
				dfs(i, (num*10 + i) );
				list.add(num*10 + i);
			}
		}
	}

}
