import java.util.*;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/////////// 구현부/////////////////////////////

		ArrayList<String> str = new ArrayList<>();
		List<Integer> cnt = new ArrayList<>();

		int idx = 0;
		while (sc.hasNext()) {
			str.add("".join(" ", sc.nextLine()));
			cnt.add(str.get(idx++).length());
		}

		int max = Collections.max(cnt);

		for (int i = 0; i < max; i++) {
			for (int j = 0; j < str.size(); j++) {
				if (str.get(j).length() > i) {
					System.out.print(str.get(j).charAt(i));
				}
			}
		}

		/////////////////////////////////////////////
	}
}
