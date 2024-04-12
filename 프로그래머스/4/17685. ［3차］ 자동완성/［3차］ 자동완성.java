class Solution {
    
    static class Node {
        Node[] nodes = new Node[26];
        int cnt;
    }
    
    public int solution(String[] words) {
        int answer = 0;
        int len = words.length;
        
        Node root = new Node();
        
        for(int i = 0; i < len; i++) {
            char[] str = words[i].toCharArray();
            
            Node tmp = root;
            for(int j = 0; j < str.length; j++) {
                tmp.cnt++;
                if(tmp.nodes[str[j] - 'a'] == null)
                    tmp.nodes[str[j] -'a'] = new Node();
                tmp = tmp.nodes[str[j]-'a'];
            }
            tmp.cnt++;
        }
        
        for(int i = 0; i < len; i++) {
            char[] str = words[i].toCharArray();
            int cnt = 0;
            Node tmp = root;
            for(int j = 0; j < str.length; j++) {
                cnt++;
                tmp = tmp.nodes[str[j]-'a'];
                if(tmp.cnt == 1)
                    break;
            }
            answer += cnt;
        }
        
        
        return answer;
    }
}