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

		while (true) {
			String s = br.readLine();
			if (s.equals("."))
				break;
			
			if(s.charAt(s.length()-1) != '.') {
				bw.write("no\n");
				continue;
			}

			Stack<Character> stack = new Stack<>();
			int idx;
			loop: for (idx = 0; idx < s.length()-1; idx++) {
				char c = s.charAt(idx);

				switch (c) {

				case '(' : case '[':
					stack.add(c);
					break;
					
				case ')' :
					if(!stack.isEmpty() && stack.peek() == '(')
						stack.pop();
					else
						break loop;
					break;
					
				case ']' :
					if(!stack.isEmpty() && stack.peek() == '[')
						stack.pop();
					else
						break loop;
					break;
				} 
			}
			
			if(stack.isEmpty() && idx == s.length()-1)
				bw.write("yes\n");
			else
				bw.write("no\n");
			
		}

		bw.flush();
		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
