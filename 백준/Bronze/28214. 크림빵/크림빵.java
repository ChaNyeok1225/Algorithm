import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		int sell = 0;
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int less = 0;
			for(int j = 0; j < k; j++) {
				if(Integer.parseInt(st.nextToken()) == 0)
					less++;
				
			}
			if(less < p)
				sell++;
		}
		
		System.out.println(sell);
	}
	
}
