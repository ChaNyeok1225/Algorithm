import java.util.*;

class Solution {
    
    class Node {
        int cnt;
        Node[] next;
        
        Node() {
            cnt = 0;
            next = new Node [26];
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        
        HashMap<Integer, Node> fmap = new HashMap<>();
        HashMap<Integer, Node> bmap = new HashMap<>();
        
        Node node;
        char[] chars;
        int len;
        
        for(String word : words) {
            chars = word.toCharArray();
            len = chars.length;
            
            node = fmap.get(len);
            if(node == null) {
                node = new Node();
                fmap.put(len, node);
            }
            node.cnt++;
            for(int i = 0; i < chars.length; i++) {
                if(node.next[chars[i] - 'a'] == null)
                    node.next[chars[i] - 'a'] = new Node();
                node = node.next[chars[i] - 'a'];
                node.cnt++;
            }
            
            node = bmap.get(len);
            if(node == null) {
                node = new Node();
                bmap.put(len, node);
            }
            node.cnt++;
            
            for(int i = chars.length - 1; i >= 0; i--) {
                if(node.next[chars[i] - 'a'] == null)
                    node.next[chars[i] - 'a'] = new Node();
                node = node.next[chars[i] - 'a'];
                node.cnt++;
            }
        }
        
        
        
        
        int st, step, cnt, idx = 0;
        for(String query : queries) {
            chars = query.toCharArray();
            len = chars.length;
            st = 0; step = 1; cnt = 0;
            if(chars[0] == '?') {
                st = len - 1; step = -1;
                node = bmap.get(len);
            } else {
                node = fmap.get(len);
            }

            while(node != null) {
                if(chars[st] == '?') {
                    cnt = node.cnt;
                    break;
                }
                if(node.next[chars[st] - 'a'] == null)
                    break;
                node = node.next[chars[st] - 'a'];
                st += step;
            }
            
            answer[idx++] = cnt;             
        }
        
        
        return answer;
    }

}