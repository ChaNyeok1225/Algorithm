import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] val = new int[n];
		for(int i = 0; i < n; i++)
			val[i] = Integer.parseInt(br.readLine());
		
		int[] D = new int[k+1];
		D[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = val[i]; j < k + 1; j++)
				D[j] += D[j-val[i]];
		}
		
		System.out.println(D[k]);
	}
}
