import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////////// 구현부  /////////////////////

		int T = Integer.parseInt(br.readLine());
		
		bw.write(String.valueOf(T * (T-1)));
		
		bw.flush();
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}


}
