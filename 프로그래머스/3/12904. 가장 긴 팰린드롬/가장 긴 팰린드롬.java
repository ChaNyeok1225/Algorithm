class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        char[] str = s.toCharArray();
        int n = s.length();
        int l, r, cnt;
        for(int i = 0; i < n; i++) {
            l = i;
            r = i + 1;
            cnt = 0;
            
            while(true) {
                if(l < 0 || r >= n)
                    break;
                
                if(str[l] != str[r])
                    break;
                cnt += 2;
                answer = answer > cnt ? answer : cnt;       
                l--;
                r++;
            }
            
            l = i - 1;
            r = i + 1;
            cnt = 1;
            
            while(true) {
                 if(l < 0 || r >= n)
                    break;
                
                if(str[l] != str[r])
                    break;
                cnt += 2;
                answer = answer > cnt ? answer : cnt;       
                l--;
                r++;
            }
        }

        return answer;
    }
}