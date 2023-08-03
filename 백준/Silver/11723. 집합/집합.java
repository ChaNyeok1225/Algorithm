import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		int bit = 0;
		
		
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());

			switch (st.nextToken()) {

			case "add":
				bit |= 1 << Integer.parseInt(st.nextToken())-1;
				break;

			case "remove":
				bit &= ~(1 << Integer.parseInt(st.nextToken())-1);
				break;

			case "check":
				if ((bit & 1 << Integer.parseInt(st.nextToken())-1) != 0)
					sb.append("1\n");
				else {
					sb.append("0\n");
				}
				
				break;

			case "toggle":
				bit ^= 1 << Integer.parseInt(st.nextToken())-1; 
				break;

			case "all":
				bit |= 0b1111_1111_1111_1111_1111;
				break;

			case "empty":
				bit &= 0;
				break;
			}

		}

		System.out.println(sb);
		
	}

}
