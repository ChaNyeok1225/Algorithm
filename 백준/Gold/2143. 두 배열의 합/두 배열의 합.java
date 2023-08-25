import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> hmA = new HashMap<>();
		HashMap<Integer, Integer> hmB = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			hmA.put(A[i], hmA.getOrDefault(A[i], 0)+1);
		}
		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			hmB.put(B[i], hmB.getOrDefault(B[i], 0)+1);
		}
		for(int i = 0; i < n-1; i++) {
			int vA = A[i];
			for(int j = i + 1; j < n; j++) {
				vA += A[j];
				hmA.put(vA, hmA.getOrDefault(vA, 0)+1);
			}
		}
		for(int i = 0; i < m-1; i++) {
			int vB = B[i];
			for(int j = i + 1; j < m; j++) {
				vB += B[j];
				hmB.put(vB, hmB.getOrDefault(vB, 0)+1);
			}
		}
		
		long cnt=0;
		for(int x : hmA.keySet()) {
			if(hmB.containsKey(T-x))
				cnt += (long)hmA.get(x) * (long)hmB.get(T-x);
		}
		System.out.println(cnt);
	}
}