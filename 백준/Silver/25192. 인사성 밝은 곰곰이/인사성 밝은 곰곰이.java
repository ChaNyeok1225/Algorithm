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
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.equals("ENTER")) {
				cnt += nameset.size();
				nameset.clear();
			} else {
				nameset.add(str);
			}

		}
		cnt += nameset.size();

		bw.write(String.valueOf(cnt));

		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
