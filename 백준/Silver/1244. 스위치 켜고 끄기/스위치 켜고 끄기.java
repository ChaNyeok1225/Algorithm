import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		boolean[] switchs = new boolean[n+1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			if (st.nextToken().equals("1"))
				switchs[i+1] = true;
			else
				switchs[i+1] = false;
		}

		int m = Integer.parseInt(br.readLine());

		while (m-- > 0) {
//			System.out.println(Arrays.toString(switchs));
			
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int step = 0;

			switch (g) {

			case 1:
				for (int i = num; i < n + 1; i += num)
					switchs[i] = !switchs[i];
				break;

			case 2:
				while (true) {
					
					if(num-step <= 0 || num + step > n) break;
					if (switchs[num - step] == switchs[num + step]) {
						switchs[num-step] = switchs[num+step] = !switchs[num-step];
					}
					else
						break;
					
					step++;
				}
				break;
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			if(switchs[i])
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
			if(i%20 == 0)
				sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
