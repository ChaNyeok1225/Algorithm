import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		int[] D = new int[n + 1];
		
		D[0] = 1;
		D[1] = 1;
		for(int i = 2; i < n + 1; i++) {
			D[i] = (D[i-1] + D[i-2]) % 15746;
		}
		
		System.out.println(D[n]);
		////////////////////////////////////////////////////
		br.close();

	}

}

