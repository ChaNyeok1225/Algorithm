import java.util.*;

class Solution {
    
    class Node {
        Integer idx;
        Node next;
        Node prev;
        
        Node (Integer i) {
            idx = i;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        StringTokenizer st;
        
        Node root = new Node(null);
        Node cursor = root;
        Stack<Node> deletedRows = new Stack<>();
        
        Node tmp = root;
        for(int i = 0; i < n+1; i++) {
            Node newNode = new Node(i);
            
            if(i == k)
                cursor = newNode;
            
            tmp.next = newNode;
            newNode.prev = tmp;
            tmp = newNode;
        }
        
        String inst;
        int op;
        for(String command : cmd) {
            st = new StringTokenizer(command);
        
            inst = st.nextToken();
            
            switch(inst) {
                case "D" :
                    op = Integer.parseInt(st.nextToken());       
                    for(int i = 0; i < op; i++)
                        cursor = cursor.next;
                    break;
                    
                case "U" :
                    op = Integer.parseInt(st.nextToken());        
                    for(int i = 0; i < op; i++)
                        cursor = cursor.prev;
                    break;
                    
                case "C" :
                    deletedRows.push(cursor);
                    
                    cursor.prev.next = cursor.next;
                    cursor.next.prev = cursor.prev;
                    if(cursor.next.idx == n)
                        cursor = cursor.prev;
                    else 
                        cursor = cursor.next;
                    break;
                    
                case "Z" :
                    Node deletedNode = deletedRows.pop();
                    
                    deletedNode.prev.next = deletedNode;
                    deletedNode.next.prev = deletedNode;
                    break;
            }
            
        }
        
        StringBuilder sb = new StringBuilder();
        tmp = root.next;
        
        for(int i = 0; i < n; i++) {
            if(tmp.idx == i) {
                sb.append("O");
                tmp = tmp.next;
            } else {
                sb.append("X");
            }
        }
        
        return sb.toString();
    }
}