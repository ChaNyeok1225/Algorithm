import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int i = 1; i < n + 1; i++)
			deque.add(i);
		
		while (deque.size() != 1) {
			deque.pollFirst();
			deque.add(deque.pollFirst());
		}	
		
		System.out.println(deque.peekFirst());
		
		
		////////////////////////////////////////////////////
		br.close();

	}

}
