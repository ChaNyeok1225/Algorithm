import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static boolean[] clockNums = new boolean[10000];
	
	
	public static void main(String[] args) throws IOException {
		
		int n = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <4; i++)
			n = n * 10 + Integer.parseInt(st.nextToken());
		
		int cn = setClockNum(n);
		
		dfs(0,0);
		
		int idx = 0;
		for(int i = 1111; i < 10000; i++) {
			if(clockNums[i])
				idx++;
			if(i==cn)
				break;
		}
		System.out.println(idx);
		
	}
	
	static void dfs(int cnt, int num) {
		if(cnt == 4) {
			int cn = setClockNum(num);
			clockNums[cn] = true;
			return;
		}
		
		for(int i =1 ; i <10; i++)
			dfs(cnt+1, num*10 + i);
		
		
	}

	private static int setClockNum(int num) {

		int min = num;
		
		for(int i = 0; i < 3; i++) {
			num = (num % 1000 * 10) + (num / 1000);
			if(num < min)
				min = num;
		}
		
		return min;
	}
	
}
