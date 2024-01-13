import java.util.*; 
// 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
// N : 전체 스테이지 개수 N, 
// 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
// 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열

class Solution {
    static class Data implements Comparable<Data>{
        double rate; 
        int num; 
        
        public Data(double rate, int num){
            this.rate = rate;
            this.num = num; 
        }
        
        @Override
        public String toString(){
            return "rate : " + rate + " num : " + num; 
        }
        
        @Override
        public int compareTo(Data data) {
            if(this.rate == data.rate){
                return this.num - data.num; 
            }
            return Double.compare(data.rate, this.rate);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int person = stages.length; // 사람 수
        
        int[] pass = new int[N+2];
        int[] now = new int[N+2]; 
        
        // 사람별 어디있는지.. 
        for(int i : stages){
            // System.out.println("i :"+ i); 
            now[i]++; 
            
            for(int j = i-1; j > 0; j--){
                // System.out.println("j :"+ j); 
                pass[j]++; 
            }
            // System.out.println("pass : " + Arrays.toString(pass));
            // System.out.println("nows : " + Arrays.toString(now)); 
        }
        
    
        // 실패율을 저장할 자료구조
        PriorityQueue<Data> pq = new PriorityQueue<>(); 
        
        // TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i=1; i<N+1; i++){
            
            double rate; 
            if(pass[i] + now[i] == 0){ // 다 통과한 경우
                rate = 0; 
            }else{
                rate = (double) now[i] / (double) (now[i] + pass[i]); // 계산?   
            }
            
            pq.add(new Data(rate, i)); 
        }
        
        int[] answer = new int[pq.size()];
        int size = pq.size();
        for(int i=0; i<size; i++){
            answer[i] = pq.poll().num; 
        }
        
        return answer;
    }
}