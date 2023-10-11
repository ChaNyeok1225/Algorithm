import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int min;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(br.readLine());
		loop: while (T-- > 0) {

			int n = Integer.parseInt(br.readLine());
			char[][] mbti = new char[n][];
			HashMap<String, Integer> map = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String str = st.nextToken();
				mbti[i] = str.toCharArray();

				map.put(str, map.getOrDefault(str, 0)+1);
				
				if (map.get(str) > 2) {
					sb.append(0).append("\n");
					continue loop;
				}
			}

			int ans = Integer.MAX_VALUE;

			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						int val = 0;
						
						for(int a = 0; a < 4; a++) {
							if(mbti[i][a] != mbti[j][a]) val++;
							if(mbti[i][a] != mbti[k][a]) val++;
							if(mbti[j][a] != mbti[k][a]) val++;
						}
						
						if(ans > val)
							ans = val;
					}	
				}
			}

			sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}


}