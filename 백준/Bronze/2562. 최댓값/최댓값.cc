#include <iostream>
using namespace std;

int main() {

	int X, Num, Max;
	Max = 0;

	for (int i = 0; i < 9; i++) {
		cin >> X;
		if (X > Max) {
			Max = X;
			Num = i + 1;
		}
	}
	cout << Max << "\n";
	cout << Num << "\n";

	return 0;
}