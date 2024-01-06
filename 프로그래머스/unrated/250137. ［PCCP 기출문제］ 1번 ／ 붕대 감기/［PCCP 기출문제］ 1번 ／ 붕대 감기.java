class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int base = health;
        int time = 1, load = 0, idx = 0;
        while(true) {
            
            if(attacks[idx][0] == time){
                health -= attacks[idx][1];
                load = 0;
                idx++;
                if(health <= 0)
                    return -1;
                if(idx == attacks.length)
                    break;
            }
            else {
                health += bandage[1];
                load++;
                if(load == bandage[0]) {
                    load = 0;
                    health += bandage[2];
                }
                if(health > base)
                    health = base;
            }
            
            time++;
        }
        
        
        return health;
    }
}