import java.io.*;
import java.util.*;

public class Main {
	
	static	ArrayList<Long> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for(int i = 0; i <= 9; i++)
			get(i, i);
		
		Collections.sort(list);
		
		int n = Integer.parseInt(br.readLine());
		
		
		if(n > list.size())
			System.out.println(-1);
		else
			System.out.println(list.get(n-1));
		
	}
	
	static void get(long cur, int prev) {
		list.add(cur);
		for(int i = prev - 1; i >= 0; i--) {
			get(cur*10+i, i);
		}
	}

}
