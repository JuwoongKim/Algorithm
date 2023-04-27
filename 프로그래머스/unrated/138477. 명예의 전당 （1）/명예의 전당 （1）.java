import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        int N = score.length;
        int [] answer = new int [N];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i =0; i<N; i++){
            pq.offer(score[i]);
            if(i>=k) pq.poll();  
            answer[i] = pq.peek();
        }
        
        
        return answer;
    }
}