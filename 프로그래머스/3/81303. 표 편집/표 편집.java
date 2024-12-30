import java.util.*;

// 키워드
// -   표의 선택, 삭제, 복구 명령어 구현
// -   복구 명령어를 여러 번 가능

// 접근법
// -   더블 링크드 리스트 또는 배열로 구현
// -   [n][2] [0] : 이전 [1] : 다음
// -   삭제된 노드는 스택에 삽입하고 복구에 활용


class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        
        int[][] nodes = new int[n+1][2];
        boolean[] deleteFlag = new boolean[n];
        for(int i = 0; i < n; i++) {
            nodes[i][0] = i - 1;
            nodes[i][1] = i + 1;
        }
        nodes[n-1][1] = -1;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int cursor = k;
        int ins = 0, prev, next, z;
        for(String cm : cmd) {
            String[] s = cm.split(" ");
            switch(s[0]) {
            
            case "U" :
                    ins = Integer.parseInt(s[1]);
                    for(int i = 0; i < ins; i++) {
                        if(nodes[cursor][0] == -1)
                            break;
                        cursor = nodes[cursor][0];
                    }
                    break;
            
            case "D" :
                    ins = Integer.parseInt(s[1]);
                    for(int i = 0; i < ins; i++) {
                        if(nodes[cursor][1] == -1)
                            break;
                        cursor = nodes[cursor][1];
                    }
                    break;
            
            case "C" :
                    stack.offerLast(cursor);
                    deleteFlag[cursor] = true;
                    
                    prev = nodes[cursor][0];
                    next = nodes[cursor][1];
                    if(prev != -1) {
                        nodes[prev][1] = next;
                        cursor = prev;
                    }
                    if(next != -1) {
                        nodes[next][0] = prev;
                        cursor = next;
                    }
                    break;
            
            case "Z" :
                    z = stack.pollLast();
                    deleteFlag[z] = false;
                    
                    prev = nodes[z][0];
                    next = nodes[z][1];
                    
                    if(prev != -1) {
                        nodes[prev][1] = z;
                    }
                    if(next != -1) {
                        nodes[next][0] = z;
                    }
                    break;
            }
        }

        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(deleteFlag[i])
                sb.append('X');
            else
                sb.append('O');
        }
      
        
        return sb.toString();
    }
}