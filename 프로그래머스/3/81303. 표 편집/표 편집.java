import java.util.*;

class Solution {
    
    class Node {
        int index;
        boolean isDeleted = false;
        Node prev, next;
        
        Node(int index) {
            this.index = index;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        
        Node head,tail;
        
        head = tail = new Node(-1);
        
        for(int i = 0; i < n; i++) {
            Node newNode = new Node(i);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            nodes[i] = newNode;
        }
        
        Node cur = nodes[k];
        Node del;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        
        StringTokenizer st;
        String inst;
        int op;
        for(int i = 0; i < cmd.length; i++) {
            st = new StringTokenizer(cmd[i]);
            inst = st.nextToken();
            
            switch(inst) {
                case "U" :
                    op = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < op; j++) 
                        cur = cur.prev;
                    break;
                    
                case "D" :
                    op = Integer.parseInt(st.nextToken());
                    for(int j = 0; j < op; j++)
                        cur = cur.next;
                    break;
                    
                case "C" :
                    cur.isDeleted = true;
                    stack.offer(cur);
                    
                    cur.prev.next = cur.next;
                    if(cur.next == null)
                        cur = cur.prev;
                    else {
                        cur.next.prev = cur.prev;
                        cur = cur.next;
                    }
                    break;
                    
                case "Z" :
                    del = stack.pollLast();
                    del.isDeleted = false;
                    del.prev.next = del;
                    if(del.next != null)
                        del.next.prev = del;
                    break;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) { 
            if(nodes[i].isDeleted)
                sb.append("X");
            else
                sb.append("O");
        }
        
        return sb.toString();
    }
}