import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int Y = 0, M = 0;
		for (int i = 0; i < n; i++) {
			Y += ((arr[i] / 30) + 1) * 10;
			M += ((arr[i] / 60) + 1) * 15;
		}
		
		if(Y == M) 
			System.out.println("Y M " + Y);
		else if(Y > M)
			System.out.println("M " + M);
		else
			System.out.println("Y " + Y);

	}

}
