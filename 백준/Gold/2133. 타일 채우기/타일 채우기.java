import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] D = new int[n+5];
		
		D[0] = 1;
		D[2] = 3;
		
		for(int i = 4; i < n+1; i+=2) {
			for(int j = 0; j < i-2; j += 2) 
				D[i] += D[j] * 2;
			D[i] += D[i-2] * 3;
		}
		
		System.out.println(D[n]);
	}

}