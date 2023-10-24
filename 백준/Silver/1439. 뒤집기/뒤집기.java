import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		char[] c = br.readLine().toCharArray();
		
		boolean zflag = true;
		boolean oflag = true;
		int zanswer = 0;
		int oanswer = 0;
		
		
		for(int i = 0; i < c.length; i++) {
			if(c[i] == '0') {
				if(oflag) oanswer++;
				zflag=true;
				oflag=false;
			}
			
			if(c[i] == '1') {
				if(zflag) zanswer++;
				zflag=false;
				oflag=true;
			}
		}
		
		int ans = zanswer < oanswer ? zanswer : oanswer;
		System.out.println(ans);
	}
	
}