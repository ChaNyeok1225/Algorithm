import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////구현부/////////////////
		
		// 1. 문자열 입력
		String s = br.readLine();
		
		// 2. 반복문 1부터 문자열의 사이즈까지
		// 3. 반복문 i의 크기만큼 슬라이싱하여 Set에 저장하는 메소드 실행
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			func(s, set, i);
		}
		
		// 4. Set의 사이즈 출력
		bw.write(String.valueOf(set.size()));
		
		bw.flush();
		//////////////////////////////////////
		
		br.close();
		bw.close();
		
	}
	
	
	public static void func(String s, Set<String> set, int len) {
		for(int i = 0; i < s.length()-len; i++) {
			set.add(s.substring(i, i+1+len));
		}
	}
	
	
}
