import java.io.*;
import java.util.*;

//start	2023. 12. 18  17 : 33
//end 	2023. 12. 18  18 : 10
public class Main {

	static int tmp, n, k, ans;
	static boolean[] vis;
	static int[] words;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 단어 수
		k = Integer.parseInt(st.nextToken()); // 선택할 알파벳 수
		k -= 5; // anti-tica 중 항상 나오는 a, n, t, i, c 제거

		vis = new boolean[26];
		tmp |= (1 << ('a' - 'a')); // 비트 마스킹
		tmp |= (1 << ('n' - 'a'));
		tmp |= (1 << ('t' - 'a'));
		tmp |= (1 << ('i' - 'a'));
		tmp |= (1 << ('c' - 'a'));
		vis['a' - 'a'] = vis['n' - 'a'] = vis['t' - 'a'] 
				= vis['i' - 'a'] = vis['c' - 'a'] = true;
		
		words = new int[n];
		
		// 각 단어에 대해서 사용하는 알파벳 비트마스킹 저장
		for (int i = 0; i < n; i++) { 
			int value = tmp;

			char[] word = br.readLine().toCharArray();
			// anta 와 tica 부분은 확정이니 그 외의 부분만 저장
			for (int j = 4; j < word.length - 4; j++) 
				value |= (1 << (word[j] - 'a'));
			words[i] = value;
		}

		select(0, 0); // 집합 (처음에 생각없이 순열로 해서 틀림)
		
		System.out.println(ans);
	}

	static void select(int cnt, int idx) {
		if (cnt == k) { // k를 골랏다면 비트 마스킹을 통해 답 확인
			int read = 0;
			for (int i = 0; i < n; i++) 
				// & 연산에서 word와 같은 값이 나오면 말할 수 있는 것
				if ((tmp & words[i]) == words[i])
					read++;
			
			ans = ans > read ? ans : read;
			return;
		}

		for (int i = idx; i < 26; i++) { // 집합
			if (vis[i]) // a, n, t, i, c 제외
				continue;
			tmp ^= (1 << i); // 0 일테니 1로 만드는 xor
			select(cnt + 1, i + 1);
			tmp ^= (1 << i); // 1일테니 0으로 만드는 xor
		}

	}

}