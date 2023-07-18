import java.util.*;
import java.io.*;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String s = br.readLine();
			cnt = 0;
			
			int isP = isPalindrome(s);
			
			sb.append(isP + " " + cnt + "\n");
		}
		
		System.out.println(sb);
		
		////////////////////////////////////////////////////
		br.close();
	}
	
    public static int recursion(String s, int l, int r) {
    	cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

}
