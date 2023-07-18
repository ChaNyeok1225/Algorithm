import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;

		HashSet<String> nameset = new HashSet<>();
		nameset.add("ChongChong");
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			
			if (nameset.contains(s1) || nameset.contains(s2)) {
				nameset.add(s1);
				nameset.add(s2);
			}
			
		}
		bw.write(String.valueOf(nameset.size()));

		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
