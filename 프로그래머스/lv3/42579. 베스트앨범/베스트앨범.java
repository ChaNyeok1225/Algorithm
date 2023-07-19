import java.io.*;
import java.util.*;

class Song implements Comparable<Song> {
	int play;
	int idx;
	
	public Song(int play, int idx) {
		super();
		this.play = play;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "[play=" + play + ", idx=" + idx + "]";
	}

	@Override
	public int compareTo(Song o) {
		if(this.play != o.play)
			return o.play - this.play;
		else
			return this.idx - o.idx;
	}
}

class Solution {

    public int[] solution(String[] genres, int[] plays) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		///////////////////////구현부/////////////////////
		
		List<Integer> tmp = new ArrayList<>();
		
		HashMap<String, Integer> cntmap = new HashMap<>();
		HashMap<String, List<Song>> songs = new HashMap<>();
		
		for(int i = 0; i < genres.length; i++) {
			cntmap.put(genres[i], cntmap.getOrDefault(genres[i], 0) + plays[i]);
			if(!songs.containsKey(genres[i]))
				songs.put(genres[i], new ArrayList<Song>());
			
			songs.get(genres[i]).add(new Song(plays[i], i));
		}
		
		List<String> lst = new ArrayList<>(cntmap.keySet());
		
		lst.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return cntmap.get(o2) - cntmap.get(o1);
			}
		});
		
		for(String s : songs.keySet())
			Collections.sort(songs.get(s));
		
		for(int i = 0; i < lst.size(); i++) {
			
			for(int j = 0; j < 2 && j < songs.get(lst.get(i)).size(); j++) {
				tmp.add(songs.get(lst.get(i)).get(j).idx);
			}
		}
		
		int[] answer = new int[tmp.size()];
		for(int i = 0; i < tmp.size(); i++)
			answer[i] = tmp.get(i);
		
		return answer;
    }

}
