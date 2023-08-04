import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int n;
	static int min = 4;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {

		n = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i*i <= n; i++) 
			list.add(i*i);
		
		func(list.size()-1,0,0);
		
		System.out.println(min);
		
	}

	static void func(int idx, int cnt, int sum) {
		if(cnt >= min || sum > n) {
			return;
		}
		if(sum == n) {
			if(min > cnt)
				min = cnt;
			return;
		}
		
		for(int i = idx; i >= 0; i--) {
			func(i, cnt+1, sum + list.get(i));
		}
		
	}
	
}
