import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		///////////////////// 구현부//////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		int[] levels = new int[n];
		
		for(int i = 0; i < n; i++) {
			levels[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(levels);
		
		int cut = (int)Math.round( n * 0.15 );
		
		double aver = 0;
		
		for(int i = cut; i < n - cut; i++) {
			aver += levels[i];
		}
		
		aver = Math.round(aver/(n-2*cut));
		
		System.out.println((int)aver);
		
	}
	
}
