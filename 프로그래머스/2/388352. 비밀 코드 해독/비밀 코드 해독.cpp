#include <string>
#include <vector>

using namespace std;

int answer = 0;
int N;
int sel[31] = {};
vector<vector<int>> Q;
vector<int> ANS;

bool CheckAnswer() {
    int count;
    for(int i = 0; i < Q.size(); ++i) {
        count = 0;
        for(int k = 0; k < 5; k++) {
            if(sel[Q[i][k]])
                ++count;
        }
        
        if(count != ANS[i])
            return false;
    }
    
    return true;
}

void Comb(int count, int number) {
    if(count == 5) {
        if(CheckAnswer())
            answer++;
        return;
    }
    
    for(int i = number; i <= N; i++) {
        sel[i] = true;
        Comb(count + 1, i + 1);
        sel[i] = false;
    }
    
}

int solution(int n, vector<vector<int>> q, vector<int> ans) {
    N = n;
    Q = q;
    ANS = ans;
    
    Comb(0, 1);
    
    return answer;
}