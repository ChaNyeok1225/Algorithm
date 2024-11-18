

// 문제의 키워드
// - 문자열 중 "110"을 뽑아서 임의의 위치에 삽입
// - 위의 행동을 통해 만들 수 있는 사전 순 가장 작은 문자




// 접근법 분석
// - s의 길이 1,000,000
//     - N 또는 NlogN 풀이 가능
//     - 그리디로 판단
// - "110"의 경우, 두 개를 사용했을 때, "110110"이 가장 최적의 방법
// - 모든 "110"을 제거한 후 "110"보다 우선순위가 낮은 곳을 찾아 해당 위치에 모든 "110"을 삽입




import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        StringBuilder sb;
        
        int index, cnt, insert;
        char[] chars, arr = new char[1_000_001];
        for(int t = 0; t < s.length; t++) {
            index = cnt = insert = 0;
            chars = s[t].toCharArray();

            for(int i = 0; i < chars.length; i++) {
                arr[index] = chars[i];
                if(index > 1) {
                    if(arr[index - 2] == '1' && arr[index-1] == '1' && arr[index] == '0') {
                        cnt++;
                        index -= 3;
                    }
                }
                index++;
            }            
            
            
            for(int i = index - 1; i >= 0; i--) {
                if(arr[i] == '0') {
                    insert = i + 1;
                    break;
                }
            }
            
            sb = new StringBuilder();
            for(int i = 0; i < insert; i++) {
                sb.append(arr[i]);
            }
            for(int i = 0; i < cnt; i++) {
                sb.append("110");
            }
            for(int i = insert; i < index; i++) {
                sb.append(arr[i]);
            }
            
            answer[t] = sb.toString();
            
        }
        
        
        return answer;
    }
}