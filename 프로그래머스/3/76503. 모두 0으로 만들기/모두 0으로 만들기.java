// 문제 키워드
// - 가중치가 부여된 트리
// - 모든 점의 가중치를 0으로
// - 연결된 두 점을 골라서 한 쪽은 증가, 한 쪽은 감소
// - 가능하다면 최소 횟수 리턴, 불가능하다면 -1 리턴
// - 항상 트리 형태. 즉, 사이클 없음

// 접근법 
// - 트리 정점 개수는 최대 300,000
//     - n^2 안 됨
// - 가능한지 판별: 제로섬

// - 최소 이동 횟수: 가장 가까운 연산부터 차례대로
// - 각 리프 노드부터 루트로 올라오면서 만나면 되지 않을까?
//     - DFS 또는 위상정렬로 리프노드 판단 후 BFS로 구현


class Node {
    int index;
    Node next = null;
    
    Node(int index) {
        this.index = index;
    }
}

class Queue {
    private int size = 0;
    private Node head;
    private Node tail;
    
    int size() {
        return size;
    }
    
    boolean isEmpty() {
        return size == 0;
    }
    
    int poll() {
        if(size == 0)
            return -1;
        size--;
        int ret = head.index;
        head = head.next;
        return ret;
    }
    
    void offer(int idx) {
        size++;
        if(size == 1) {
            head = tail = new Node(idx);
            return;
        }
        tail.next = new Node(idx);
        tail = tail.next;
        return;
    }
    
}


class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        int n = a.length;
        
        
        // 가능한지 판별
        long sum = 0;
        for(int i = 0; i < n; i++)
            sum += a[i];
        if(sum != 0)
            return -1;
        
        // 가능한 경우
        long[] w = new long[n];
        
        int[] indegree = new int[n];
        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            w[i] = a[i];
            nodes[i] = new Node(i);
        }
        
        int n1, n2;
        Node tmp;
        for(int i = 0; i < n - 1; i++) {
            n1 = edges[i][0];
            n2 = edges[i][1];
            indegree[n1]++;
            tmp = new Node(n2);
            tmp.next = nodes[n1].next;
            nodes[n1].next = tmp;
            
            indegree[n2]++;
            tmp = new Node(n1);
            tmp.next = nodes[n2].next;
            nodes[n2].next = tmp;
        }
        
        // 위상정렬 BFS        
        Queue q = new Queue();
        for(int i = 0; i < n; i++) {
            if(indegree[i] != 1)
                continue;
            q.offer(i);
        }
        
        int cur, idx, sel = 0;
        while(!q.isEmpty()) {
            cur = q.poll();
            
            tmp = nodes[cur].next;
            while(tmp != null) {
                idx = tmp.index;
                
                indegree[idx]--;
                tmp = tmp.next;
                if(indegree[idx] < 1) {
                    continue;
                }
                else if(indegree[idx] >= 1) {
                    if(indegree[idx] == 1)
                        q.offer(idx);
                    answer += w[cur] < 0 ? -w[cur] : w[cur];
                    w[idx] += w[cur];
                    sel = idx;
                }
            }
        }
        answer += w[sel] < 0 ? -w[sel] : w[sel]; 
        
        return answer;
    }
}