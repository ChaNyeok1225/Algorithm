import java.io.*;
import java.util.*;

class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		int[] gyu = new int[9];
		int[] in = new int[9];
		int gw, iw, gs, is, idx;
		
		for (int tc = 1; tc < T + 1; tc++) {

			gw = iw = 0;
			boolean[] nums = new boolean[19];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				gyu[i] = Integer.parseInt(st.nextToken());
				nums[gyu[i]] = true;
			}

			idx = 0;
			for (int i = 1; i < 19; i++)
				if (!nums[i])
					in[idx++] = i;

			do {
				gs = is = 0;
				
				for(int i = 0; i < 9; i++) {
					if(gyu[i] > in[i])
						gs += gyu[i] + in[i];
					else if(gyu[i] < in[i])
						is += gyu[i] + in[i];
				}
				
				if(gs > is)
					gw++;
				else if(gs < is)
					iw++;
				
			} while (np(in));

			System.out.printf("#%d %d %d\n", tc, gw, iw);
		}
	}

	private static boolean np(int[] in) {

		int i = in.length - 1;
		
		while(i > 0 && in[i-1] >= in[i])
			i--;
		
		if(i==0)
			return false;
		
		int j = in.length-1;
		
		while(in[i-1] >= in[j])
			j--;
		
		int tmp = in[i-1];
		in[i-1] = in[j];
		in[j] = tmp;
		
		int k = in.length-1;
		
		while(i < k) {
			tmp = in[i];
			in[i] = in[k];
			in[k] = tmp;
			i++; k--;
		}
		
		return true;
	}

	
	
}
