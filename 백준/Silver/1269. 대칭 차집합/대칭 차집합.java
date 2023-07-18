import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		///////////////구현부/////////////////
		
		// 1. A와 B 집합 원소 개수 입력 받기
		st = new StringTokenizer(br.readLine());
		int Asize = Integer.parseInt(st.nextToken());
		int Bsize = Integer.parseInt(st.nextToken());
		
		// 2. Set A에  A 집합 집어 넣기
		Set<Integer> Aset = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Asize; i++)
			Aset.add(Integer.parseInt(st.nextToken()));
		
		// 3. Set A에 집어넣으면서 A에 있으면 remove, 아니면 A put
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < Bsize; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			if(Aset.contains(n))
				Aset.remove(n);
			else
				Aset.add(n);
		}
		
		
		// 4. Set A의 size를 출력
		bw.write(String.valueOf(Aset.size()));
		
		bw.flush();
		//////////////////////////////////////
		
		br.close();
		bw.close();
		
	}
	
}
