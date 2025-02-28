#include <vector>
using namespace std;

int solution(vector<int> players, int m, int k) {
    int answer = 0;
    
    int q[50] = {};
    
    int curMax = m;
    int curServer = 0;
    for(int t = 0; t < 24; t++) {
        int curPlayer = players[t];
        curServer += q[t];
        curMax += q[t] * m;
        
        if(curMax <= curPlayer) {
            int needs = curPlayer / m;
            int add = needs - curServer;
            q[t + k] = -add;
            answer += add;
            curServer = needs;
            curMax = (needs + 1) * m;
        }
        
    }
    
    return answer;
}