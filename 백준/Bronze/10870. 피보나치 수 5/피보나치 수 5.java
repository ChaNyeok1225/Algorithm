import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(n));
		
		////////////////////////////////////////////////////
		br.close();
	}
	
	static int fibo(int n) {
		if(n < 2)
			return n;
		
		return fibo(n-1) + fibo(n-2);
	}

}
