import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] susi = new int[n*2];
		int[] kind = new int[d+1];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			susi[i] = susi[n+i] = Integer.parseInt(br.readLine());
			if(i<k) {
				if(kind[susi[i]] == 0)
					cnt++;
				kind[susi[i]]++;
			}
		}
		
		int max = 0;
		int flag = 0;
		
		for(int i = 0; i < n; i++) {
			if(kind[c] == 0)
				flag = 1;
			else
				flag = 0;
			
			if(max < cnt + flag)
				max = cnt + flag;
			
			if(kind[susi[i+k]] == 0)
				cnt++;
			kind[susi[i+k]]++;
			
			kind[susi[i]]--;
			if(kind[susi[i]] == 0)
				cnt--;
		}
		
		System.out.println(max);
		
	}

}