import java.util.*;
import java.util.Map.Entry;
import java.io.*;


class Word implements Comparable<Word>{
	String word;
	int freq;
	
	public Word(String word, int freq) {
		super();
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(Word o) {
		
		if(this.freq != o.freq) {
			return o.freq - this.freq;
		} 
		else if (this.word.length() != o.word.length()) {
			 return o.word.length() - this.word.length();
		}
		else {
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

		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				stack.pop();
			}
			else
				stack.add(num);
		}
		
		bw.write(stack.stream().mapToInt(i->i).sum() + "");
		
		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
