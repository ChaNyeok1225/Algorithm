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

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		List<Word> lst = new ArrayList<>();
		
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			
			if (s.length() >= M) {
				map.put(s, map.getOrDefault(s, 0)+1);
			}
		}
		
		for(Entry<String, Integer> entry : map.entrySet()) {
			lst.add(new Word(entry.getKey(), entry.getValue()));
		}
		
		Collections.sort(lst);
		
		for(int i = 0; i < lst.size(); i++) {
			bw.write(lst.get(i).word + "\n");
		}
		
		bw.flush();

		////////////////////////////////////////////////////
		br.close();
		bw.close();

	}

}
