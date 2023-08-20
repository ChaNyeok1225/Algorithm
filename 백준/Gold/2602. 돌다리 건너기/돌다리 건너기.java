import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		String magicStr = br.readLine();
		
		String[] bridge = new String[2];
		
		bridge[0] = br.readLine();
		bridge[1] = br.readLine();
		
		int ml = magicStr.length();
		int bl = bridge[0].length();
		
		int[][][] D = new int[2][ml][bl];
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < bl; j++) {
				if(bridge[i].charAt(j) == magicStr.charAt(0))
					D[i][0][j] = 1;
			}
		}
		
		for(int i = 1; i < ml; i++) {
			for(int j = 1; j < bl; j++) {
				if(bridge[0].charAt(j) == magicStr.charAt(i)) {
					
					for(int k = 0; k < j; k++) {
						if(bridge[1].charAt(k) == magicStr.charAt(i-1))
							D[0][i][j] += D[1][i-1][k];
						
					}
				}
				if(bridge[1].charAt(j) == magicStr.charAt(i)) {
					
					for(int k = 0; k < j; k++) {
						if(bridge[0].charAt(k) == magicStr.charAt(i-1))
							D[1][i][j] += D[0][i-1][k];
					}
					
				}
			}
		}
		
		int res = 0;
		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < bl; j++) {
				res += D[i][ml-1][j];
			}
			
		}
		
		System.out.println(res);
	}

}
