#include <stdio.h>

constexpr int SIZE = 50005;

struct MinHeap {
	int arr[SIZE];
	int len = 0;

	bool comp(int a, int b) { // top 이 가져야할 조건
		return a < b;
	}

	void push(int val) {
		int c = (++len);
		int p = c >> 1;

		while (p > 0) {
			if (comp(arr[p], val))
				break;
			arr[c] = arr[p];
			c = p;
			p >>= 1;
		}
		arr[c] = val;
	}

	void pop() {
		int val = arr[len--];
		int p = 1;
		while (true) {
			int c = p << 1;
			if (c > len) break;

			if (c + 1 <= len && comp(arr[c + 1], arr[c])) {
				c++;
			}

			if (comp(val, arr[c]))
				break;
			arr[p] = arr[c];
			p = c;
		}
		arr[p] = val;
	}

	int top() {
		return arr[1];
	}
};
struct MaxHeap {
	int arr[SIZE];
	int len = 0;

	bool comp(int a, int b) { // top 이 가져야할 조건
		return a > b;
	}

	void push(int val) {
		int c = (++len);
		int p = c >> 1;

		while (p > 0) {
			if (comp(arr[p], val))
				break;
			arr[c] = arr[p];
			c = p;
			p >>= 1;
		}
		arr[c] = val;
	}

	void pop() {
		int val = arr[len--];
		int p = 1;
		while (true) {
			int c = p << 1;
			if (c > len) break;

			if (c + 1 <= len && comp(arr[c + 1], arr[c])) {
				c++;
			}

			if (comp(val, arr[c]))
				break;
			arr[p] = arr[c];
			p = c;
		}
		arr[p] = val;
	}

	int top() {
		return arr[1];
	}
};

int N;
MinHeap minh;
MaxHeap maxh;

int main() {

	scanf("%d", &N);

	while (N--) {
		int val;
		scanf("%d", &val);
		
		if (maxh.len == minh.len) {
			maxh.push(val);
		}
		else {
			minh.push(val);
		}

		if (maxh.len > 0 && minh.len > 0) {
			int a = maxh.top();
			int b = minh.top();
			if (a > b) {
				maxh.pop(); minh.pop();
				maxh.push(b); minh.push(a);
			}
		}
		
		printf("%d\n", maxh.top());
	}

	return 0;
}