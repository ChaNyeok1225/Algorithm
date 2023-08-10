import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] gyu = new int[9];
	static int[] in = new int[9];
	static int gw, iw;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {

			int flag = 0;
			gw = iw = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				flag |= 1 << gyu[i];
			}

			func(0, flag);
			
			System.out.printf("#%d %d %d\n",tc, gw, iw);
			
			
		}
	}

	static void func(int cnt, int flag) {

		if (cnt == 9) {
			int gs = 0, is = 0;
			
			for(int i = 0; i < 9; i++) {
				if(gyu[i] > in[i])
					gs += gyu[i] + in[i];
				else if( gyu[i] < in[i])
					is += gyu[i] + in[i];
			}
			
			if(gs > is)
				gw++;
			else if(gs < is)
				iw++;
			
			return;
		}

		for (int i = 1; i < 19; i++) {
			if((flag & 1 << i) != 0) continue;
			in[cnt] = i;
			func(cnt + 1, flag | 1 << i);
		}

	}

}
