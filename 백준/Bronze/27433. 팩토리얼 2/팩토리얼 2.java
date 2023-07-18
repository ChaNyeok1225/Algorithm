import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		long res = 1;
		
		for(int i = 1; i <= n; i++)
			res *= i;
		
		System.out.println(res);

		////////////////////////////////////////////////////
		br.close();

	}

}
