import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		int res = 0;
		for(int i = k - x; i <= k + x; i++) {
			if(a <= i && i <= b)
				res++;
		}
		
		if(res == 0)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(res);
		
	}

}
