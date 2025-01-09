// 키워드
// -   부분 수열: 순서를 유지한 채, n개의 원소를 제거하여 얻을 수 있는 수열
// -   스타 수열
//     -   x의 길이는 2 이상의 짝수
//     -   길이가 2n일때 순서대로 2개씩 묶었을 때, 모두 같은 하나 이상의 같은 원소를 포함한다.
//     -   단, 집합 내의 원소는 서로 다르다
// -   가장 긴 스타 수열의 길이를 return

// 접근법
// -   주어지는 수열의 길이 a는 500,000
//     -   완전 탐색이 불가능
// -   그리디 알고리즘의 느낌이 난다
//     -   LIS 방식을 적용하여 하나의 원소 X를 교집합으로 하는 집합을 개수를 계속해서 저장
//     -   [5, 2, 3, 3, 5, 3] 에서 [5, 2]를 2와 5에 카운트와 인덱스를 저장하는 방식
//     -   될지 안될지는 모르겠음

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        
        int[] count = new int[len]; 
        int[] index = new int[len];
        for(int i = 0; i < len; i++)
            index[i] = -1;
        
        int num1, num2, idx;
        for(int i = 0; i < len - 1; i++) {
            num1 = a[i];
            num2 = a[i+1];
            
            if(num1 == num2)
                continue;
            
            if(index[num1] < i) {
                count[num1]++;
                index[num1] = i + 1;
            }
            if(index[num2] < i) {
                count[num2]++;
                index[num2] = i + 1;
            }
            
        }
        
        // for(int x = 0; x < len; x++) {
        //     System.out.println(x + " : " + count[x] + " & " + index[x]);
        // }
        
        for(int i = 0; i < len; i++) {
            answer = answer > count[i] ? answer : count[i];
        }
        
        return answer * 2;
    }
}