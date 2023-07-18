import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/////////////// 구현부/////////////////

		// 1. 입력 받기
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> lst = new ArrayList<>();
		for(int i = 0; i < N; i++)
			lst.add(Integer.parseInt(br.readLine()));
		
		// 2. 가로수간 간격 조사하여 리스트에 넣기 
		List<Integer> betw = new ArrayList<>();
		for(int i = 0; i < lst.size()-1; i++) {
			betw.add(lst.get(i+1) - lst.get(i));
		}
		
		
		// 3. 값이 하나가 남을때까지 gcd 메소드 실행
		while(betw.size() > 1) {
			betw.add(func(betw.get(0), betw.get(1)));
			betw.remove(0);
			betw.remove(0);			
		}
		int gcd = betw.get(0);
		// 4. 첫번째 인덱스부터 최대 공약수 만큼 값 증가하고 카운트 출력
		
		
		
		bw.write(String.valueOf((lst.get(N-1) - lst.get(0))/gcd - (N-1)));
		
		bw.flush();
		///////////////////////////////////////////////
		bw.close();
		br.close();
	}

	static int func(int a, int b) {
		int tmp;
		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}

		return a;
	}

}
