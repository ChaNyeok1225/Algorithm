	import java.util.*;
	import java.io.*;
	
	public class Main {
	
		public static void main(String[] args) throws IOException {
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			////////////////////// 구현부/////////////////////////
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
	
			if (a > b) {
				long tmp = a;
				a = b;
				b = tmp;
			}
			if (a == b) {
				sb.append(0);
			} else {
				sb.append(b - a - 1 + "\n");
				for (long i = a + 1; i < b; i++)
					sb.append(i + " ");
			}
			System.out.print(sb);
			////////////////////////////////////////////////////
			br.close();
	
		}
	
	}
