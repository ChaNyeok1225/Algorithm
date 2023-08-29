import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		char[] c = br.readLine().toCharArray();
		int[][] D = new int[c.length + 10][2];
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] != '0')
				D[i][0] = 1;
			
			if(i > 0) {
				if(c[i-1] == '1')
					D[i][1] = 1;
				else if (c[i-1] == '2' && c[i] < '7')
					D[i][1] = 1;
			}
		}
		
		if(D[0][0] == 0) {
			System.out.println(0);
			return;
		}
		for(int i = 2; i < c.length; i++) {
			if(D[i][0] != 0)
				D[i][0] = (D[i-1][0] + D[i-1][1])%1000000;
			if(D[i][1] != 0)
				D[i][1] = (D[i-2][0] + D[i-2][1])%1000000;	
		}
		
		System.out.println((D[c.length-1][0] + D[c.length-1][1])%1000000);
	}

}
