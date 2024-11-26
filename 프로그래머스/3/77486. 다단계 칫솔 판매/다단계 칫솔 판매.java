// > 문제 키워드

// - 트리 구조
// - 10%를 추천인에게 배분
// - 각 판매원의 이득을 리턴

// > 접근법

// - 단순한 트리 탐색
// - 자식에서 부모로 올라가는 구조로 구성



import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int m = seller.length;
        
        int[] answer = new int[n];
        HashMap<String, Integer> index = new HashMap<>();
        
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            index.put(enroll[i], i);
            nodes[i] = new Node();
        }
        
        String str;
        for(int i = 0; i < n; i++) {
            if("-".equals(referral[i]))
                continue;
            nodes[i].next = nodes[index.get(referral[i])];
        }
        
        Node cur;
        int nextAmount;
        for(int i = 0; i < m; i++) {
            cur = nodes[index.get(seller[i])];
            amount[i] *= 100;
            while(cur != null && amount[i] > 0) {
                nextAmount = amount[i] * 10 / 100;
                if(nextAmount > 0) {
                    cur.total += amount[i] - nextAmount;
                } else {
                    cur.total += amount[i];
                }
                amount[i] = nextAmount;
                cur = cur.next;
            }            
        }
        
        for(int i = 0; i < n; i++)
            answer[i] = nodes[i].total;
        
        return answer;
    }
}

class Node {
    int total = 0;
    Node next;
}