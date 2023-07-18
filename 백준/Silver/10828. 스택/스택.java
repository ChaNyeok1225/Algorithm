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

		int N = Integer.parseInt(br.readLine());
		
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String inst = st.nextToken();
			
			switch (inst) {
			
			case "push":
				stack.add(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop":
				if(stack.isEmpty())
					bw.write("-1\n");
				else 
					bw.write(stack.pop() + "\n");
				break;
			
			case "size":
				bw.write(stack.size() + "\n");
				break;
			
			case "empty":
				if(stack.isEmpty())
					bw.write("1\n");
				else 
					bw.write("0\n");
				break;
			
			case "top":
				if(stack.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stack.peek()+"\n");
				break;

			default:
				break;
			}
		}
		
		
		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
