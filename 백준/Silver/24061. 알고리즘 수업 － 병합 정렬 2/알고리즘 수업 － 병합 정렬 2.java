import java.io.*;
import java.util.*;

public class Main {
	
	static int cnt, k,ans[];
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[n];
		int[] tmp = new int[n];
		ans = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< n; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		
		merge_sort(nums, tmp, 0, n-1);
		
		if(flag)
			for(int i = 0; i < n; i++)
				sb.append(ans[i]+" ");
		else
			sb.append(-1);
		
		System.out.println(sb);
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

		while (l <= mid) {
			tmp[t++] = arr[l++];
		}
		while (r <= right) {
			tmp[t++] = arr[r++];
		}

		l = left;
		t = 0;
		while (l <= right) {
			cnt++;
			arr[l++] = tmp[t++];
			if(k==cnt) {
				flag = true;
				for(int i=0; i <arr.length; i++)
					ans[i] = arr[i];
			}
		}
	}
	

}