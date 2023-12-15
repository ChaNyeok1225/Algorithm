import java.io.*;
import java.util.*;

//start = 2023. 12. 15  12 : 21
//end = 2023. 12. 15  12 : 52
public class Main {

	// 현재 물통에 들어있는 물들의 중복을 피하기위해서 만든 class
	// eqauls와 hashCode를 override해서 set의 중복검사 실행
	static class Data {
		int water[] = new int[3];

		public Data(int a, int b, int c) {
			super();
			this.water[0] = a;
			this.water[1] = b;
			this.water[2] = c;
		}

		public int hashCode() {
			return 1;
		}

		public boolean equals(Object obj) {
			Data o = (Data) obj;
			if (this.water[0] == o.water[0] && this.water[1] == o.water[1] && this.water[2] == o.water[2])
				return true;
			return false;
		}
	}

	static Set<Data> set = new HashSet<>(); // 물통의 상태를 담을 set 변수
	static int max[]; // 물통의 용량을 담을 배열

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		max = new int[3]; // 물통의 최대 용량
		max[0] = Integer.parseInt(st.nextToken());
		max[1] = Integer.parseInt(st.nextToken());
		max[2] = Integer.parseInt(st.nextToken());

		Data data = new Data(0, 0, max[2]); // 시작 용량
		set.add(data);

		dfs(new int[] { 0, 0, max[2] });
		
		// 세번쨰 물통을 중복되지 않게 받고 오름차순으로 정렬하기 위해서 사용하는 TreeSet
		TreeSet<Integer> ts = new TreeSet<>(); 
		
		// set에 저장된 값을 꺼내서 첫번째 물통 용량이 0일때 세번째 물통의 값 저장 
		for(Data d : set) {
			if(d.water[0] == 0)
				ts.add(d.water[2]);
		}
		
		// 출력
		for(int v : ts)
			sb.append(v).append(" ");
		
		System.out.println(sb);
	}

	static void dfs(int[] water) {
		
		// 첫번째부터 세번째 물통까지 탐색
		for (int i = 0; i < 3; i++) {
			int w = water[i];

			// 현재 물통의 용량이 0 이면 다음으로
			if (w == 0)
				continue;
			
			// 0이 아니면 다른 물통 탐색
			for (int j = 0; j < 3; j++) {
				
				// 자신이거나 이미 꽉 차 있다면 다음으로 
				if (i == j || water[j] == max[j])
					continue;
				
				// 배열 복사 후 물 이동
				int[] tmp = water.clone();
				Data data;
				if(tmp[i] > max[j] - tmp[j]) {
					tmp[i] = tmp[i] - (max[j] - tmp[j]);
					tmp[j] = max[j];
				} else {
					tmp[j] = tmp[j] + tmp[i];
					tmp[i] = 0;
				}
				
				// Data 클래스에 담아서 현재 set에 담겨져 있다면 이미 검사했던 방법이니 메소드를 호출하지 않음
				data = new Data(tmp[0], tmp[1], tmp[2]);
				if(!set.contains(data)) {
					set.add(data);
					dfs(tmp);
				}
			}
		}
	}

}