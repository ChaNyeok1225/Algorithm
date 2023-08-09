import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());

		MinHeap mp = new MinHeap(n);
		
		while(n -- > 0) {
			int ins = Integer.parseInt(br.readLine());
			
			if(ins == 0)
				sb.append(mp.poll() + "\n");
			else 
				mp.add(ins);
		}
		System.out.print(sb);
		
	}

}

class MinHeap {
	int[] obj;
	int lastIndex = 0;
	final int SIZE;

	public MinHeap(int size) {
		SIZE = size;
		obj = new int[SIZE + 1];
	}

	public boolean add(int data) {
		if (lastIndex == SIZE)
			return false;

		obj[++lastIndex] = data;

		int cur = lastIndex;
		int idx = lastIndex / 2;
		while (idx > 0) {

			if (obj[idx] > obj[cur]) {
				swap(idx,cur);
			} else
				break;
			cur = idx;
			idx = cur / 2;
		}

		return true;
	}

	public Integer poll() {
		if (isEmpty())
			return 0;

		int ret = obj[1];

		int idx = 1;
		obj[idx] = obj[lastIndex--];

		while (true) {

			if (idx * 2 + 1 <= lastIndex) {
				if(obj[idx] > Math.min(obj[idx*2], obj[idx*2+1])) {
					if(obj[2*idx] < obj[2*idx+1]) {
						swap(idx, 2*idx);
						idx = 2*idx;
					}
					else {
						swap(idx, 2*idx+1);
						idx = 2*idx+1;
					}
				} else 
					break;
			} else if (idx * 2 <= lastIndex && obj[idx] > obj[idx * 2]) {
				swap(idx,2*idx);
				idx = idx * 2;
			} else
				break;

		}

		return ret;
	}
	
	private void swap(int i1, int i2) {
		int tmp = obj[i1];
		obj[i1] = obj[i2];
		obj[i2] = tmp;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public boolean isEmpty() {
		return lastIndex == 0;

	}

	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		for (int i = 1; i <= lastIndex; i++)
			stb.append(obj[i] + " ");

		return stb.toString();
	}

}