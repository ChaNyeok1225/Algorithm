class Solution
{
    public int solution(int n, int a, int b)
    {

        a--;b--;
        int cnt = 0;
        while(a != b) {
            a /= 2;
            b /= 2;
            cnt++;
        }

        return cnt;
    }
}