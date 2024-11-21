// 키워드

// - 점수를 깎아 정확히 0점으로 만들기
// - 0점보다 낮아지면 버스트 실격
// - 1 ~ 20 싱글, 더블, 트리플 각각의 배수, 그리고 50점 
// - 먼저 0점, 같은 라운드면 싱글이나 불 많이 던지기

// 접근법
// - 걍 bfs하면 될거같은데?


import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        
        int[] count = new int[target];
        int[] number = new int[target];
        Arrays.fill(count, -1);
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {target, 0, 0});
        
        int num;
        int[] cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            
            if(cur[0] == 0) {
                return new int[] {cur[1], count[0]};
            }
            
            num = cur[0] - 50;
            if(num >= 0) {
                if(number[num] == cur[1] + 1) 
                    count[num] = Math.max(count[num], cur[2] + 1);
                
                if(count[num] == -1) {
                    number[num] = cur[1] + 1;
                    count[num] = cur[2] + 1;
                    q.offer(new int[] {num, cur[1] + 1, count[num]});
                }
            }
            
            for(int i = 1; i < 4; i++) {
                for(int j = 1; j < 21; j++) {
                    num = cur[0] - (i * j);
                    if(num >= 0) {
                        if(number[num] == cur[1] + 1) 
                            count[num] = Math.max(count[num], cur[2] + (i == 1 ? 1 : 0));
                        
                        if(count[num] == -1) {
                            number[num] = cur[1] + 1;
                            count[num] = cur[2] + (i == 1 ? 1 : 0);
                            q.offer(new int[] {num, cur[1] + 1, count[num]});
                        }
                    } 
                }
            }
            
            
        }
        
        
        return answer;
    }
}