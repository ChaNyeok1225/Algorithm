import java.util.*;
import java.util.Map.Entry;
import java.io.*;

class Top {
	int height;
	int idx;

	public Top(int height, int idx) {
		super();
		this.height = height;
		this.idx = idx;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		int n = Integer.parseInt(br.readLine());

		Stack<Top> stack = new Stack<>();
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!(stack.isEmpty()) && stack.peek().height <= height) {
				Top top = stack.pop();

				if (!(stack.isEmpty()))
					arr[top.idx - 1] = stack.peek().idx;
				else
					arr[top.idx - 1] = 0;

			}

			stack.add(new Top(height, i + 1));
		}

		while (!(stack.isEmpty())) {
			Top top = stack.pop();

			if (!(stack.isEmpty()))
				arr[top.idx - 1] = stack.peek().idx;
			else
				arr[top.idx - 1] = 0;
		}

		for (int num : arr)
			sb.append(num + " ");

		System.out.println(sb);

		////////////////////////////////////////////////////
		br.close();
	}

}
