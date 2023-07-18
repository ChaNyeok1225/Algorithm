import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Word implements Comparable<Word> {
	String word;
	int freq;

	public Word(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(Word o) {

		if (this.freq != o.freq) {
			return o.freq - this.freq;
		} else if (this.word.length() != o.word.length()) {
			return o.word.length() - this.word.length();
		} else {
			return this.word.compareTo(o.word);
		}
	}

}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			Stack<Character> stack = new Stack<>();

			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				stack.add(s.charAt(i));
			}

			int cnt = 0;
			while (!stack.isEmpty()) {
				char c = stack.pop();
				
				if(c == ')') {
					cnt++;
				}
				else {
					cnt--;
				}
				
				if(cnt < 0)
					break;
			}
			
			if(stack.isEmpty() && cnt == 0)
				bw.write("YES\n");
			else
				bw.write("NO\n");
			
		}
		
		bw.flush();
		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
