import java.util.*;
import java.io.*;

public class Main {

	static int cnt = 0;
	static int k;
	static int result = -1;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		////////////////////// 구현부/////////////////////////

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] tmp = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		merge_sort(arr, tmp, 0, n-1);
		System.out.println(result);
//		System.out.println(Arrays.toString(arr));
		////////////////////////////////////////////////////
		br.close();
	}

	static void merge_sort(int[] arr, int[] tmp, int left, int right) {
		if (left < right) {

			int mid = (left + right) / 2;

			merge_sort(arr, tmp, left, mid);
			merge_sort(arr, tmp, mid + 1, right);
			merge(arr, tmp, left, mid, right);
		}

	}

	static void merge(int[] arr, int[] tmp, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int t = 0;

		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r])
				tmp[t++] = arr[l++];
			else
				tmp[t++] = arr[r++];
		}

		while (l <= mid)
			tmp[t++] = arr[l++];
		while (r <= right)
			tmp[t++] = arr[r++];

		l = left;
		t = 0;
		while (l <= right) {
			cnt++;
			if (cnt == k)
				result = tmp[t];
			else if (cnt > k)
				return;
			arr[l++] = tmp[t++];
		}
	}

}
