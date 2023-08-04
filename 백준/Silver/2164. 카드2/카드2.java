import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		while(cnt < n) cnt *= 2;
		
		System.out.println(2*n-cnt);
		
		////////////////////////////////////////////////////
		br.close();

	}

}
