import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////
		
		int n = Integer.parseInt(br.readLine());
		
		// 큐 생성
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		// 큐 초기화
		for(int i = 1; i < n + 1; i++)
			deque.add(i);
		
		// 카드가 한 장 남을 때까지 순환
		while (deque.size() != 1) {
			deque.pollFirst();
			deque.add(deque.pollFirst());
		}	
		
		// 출력
		System.out.println(deque.peekFirst());
		
		////////////////////////////////////////////////////
		br.close();

	}

}
