import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		String s = br.readLine();
		
		int[] needs = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			needs[i] = Integer.parseInt(st.nextToken());
		}
		
		int nop = 0;
		
		int[] cnt = new int[4];
		for(int i = 0; i < m; i++) {
			cnt[ret(s.charAt(i))]++;
		}
		
		if(chk(needs,cnt))
			nop++;
		
		for(int i = 0; i < n-m; i++) {
			cnt[ret(s.charAt(i))]--;
			cnt[ret(s.charAt(i+m))]++;
			
			if(chk(needs,cnt))
				nop++;
		}
		
		System.out.println(nop);
	}

	public static boolean chk(int[] needs, int[] cnt) {
		boolean flag = true;
		
		for(int i = 0; i < 4; i++) {
			if(cnt[i] < needs[i]) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	public static int ret (char c) {
		switch(c) {
		case 'A' : return 0;
		case 'C' : return 1;
		case 'G' : return 2;
		case 'T' : return 3;
		default : return 0;
		}
	}
	
}
