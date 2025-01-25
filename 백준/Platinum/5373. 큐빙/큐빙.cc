#include <iostream>

using namespace std;

char cube[6][9];
char color[] = { 'g', 'w', 'r', 'y', 'o', 'b' };

const int sideU[4] = { 0,2,5,4 };
const int seqU[4][3] = { {0,1,2}, {0,1,2}, {0,1,2}, {8,7,6} };
const int sideD[4] = { 0,4,5,2 };
const int seqD[4][3] = { {6,7,8}, {2,1,0}, {6,7,8}, {6,7,8} };
const int sideF[4] = { 0,3,5,1 };
const int seqF[4][3] = { {2,5,8}, {0,1,2}, {6,3,0}, {8,7,6} };
const int sideB[4] = { 0,1,5,3 };
const int seqB[4][3] = { {0,3,6}, {2,1,0}, {8,5,2}, {6,7,8} };
const int sideL[4] = { 1,4,3,2 };
const int seqL[4][3] = { {0,3,6}, {0,3,6}, {0,3,6}, {0,3,6} };
const int sideR[4] = { 1,2,3,4 };
const int seqR[4][3] = { {2,5,8}, {2,5,8}, {2,5,8}, {2,5,8} };

void init() {
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 9; j++) {
			fill(cube[i], cube[i] + 9, color[i]);
		}
	}
}

void printUpSide() {
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			cout << cube[1][i * 3 + j];
		} cout << "\n";
	}
}

void rotSide(int side, int dir) {
	char tmpSide[9];
	for (int i = 0; i < 9; i++)
		tmpSide[i] = cube[side][i];

	if (dir == 1) {
		cube[side][0] = tmpSide[6]; cube[side][1] = tmpSide[3]; cube[side][2] = tmpSide[0];
		cube[side][3] = tmpSide[7]; cube[side][4] = tmpSide[4]; cube[side][5] = tmpSide[1];
		cube[side][6] = tmpSide[8]; cube[side][7] = tmpSide[5]; cube[side][8] = tmpSide[2];
	}
	else {
		cube[side][0] = tmpSide[2]; cube[side][1] = tmpSide[5]; cube[side][2] = tmpSide[8];
		cube[side][3] = tmpSide[1]; cube[side][4] = tmpSide[4]; cube[side][5] = tmpSide[7];
		cube[side][6] = tmpSide[0]; cube[side][7] = tmpSide[3]; cube[side][8] = tmpSide[6];
	}
}


void rot(int dir, const int (&side)[4], const int (&seq)[4][3]) {
	char tmp[3];
	for (int i = 0; i < 3; i++) {
		tmp[i] = cube[side[0]][seq[0][i]];
	}

	int i;
	for (i = 0; i != 3 * dir; i += dir) {
		for (int j = 0; j < 3; j++) {
			cube[side[i & 3]][seq[i & 3][j]] = cube[side[(i + dir) & 3]][seq[(i + dir) & 3][j]];
		}
	}

	for (int j = 0; j < 3; j++) {
		cube[side[i & 3]][seq[i & 3][j]] = tmp[j];
	}
}


void rotateCube(string str) {
	char ins = str[0];
	int dir = str[1] == '+' ? 1 : -1;

	switch (ins) {
	case 'U':
		rot(dir, sideU, seqU);
		rotSide(1, dir);
		break;
	case 'D':
		rot(dir, sideD, seqD);
		rotSide(3, dir);
		break;
	case 'F':
		rot(dir, sideF, seqF);
		rotSide(2, dir);
		break;
	case 'B':
		rot(dir, sideB, seqB);
		rotSide(4, dir);
		break;
	case 'L':
		rot(dir, sideL, seqL);
		rotSide(0, dir);
		break;
	case 'R':
		rot(dir, sideR, seqR);
		rotSide(5, dir);
		break;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(nullptr); cout.tie(nullptr);

	int T, N;
	string ins;

	cin >> T;
	while (T-- > 0) {
		init();
		cin >> N;

		while (N-- > 0) {
			cin >> ins;
			rotateCube(ins);
		}printUpSide();
	}

}