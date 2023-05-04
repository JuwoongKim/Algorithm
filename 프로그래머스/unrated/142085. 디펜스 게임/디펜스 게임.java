import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);

        int N = enemy.length;
        for(int i =0; i<N; i++, answer ++){
            	
			if(n<enemy[i]){
                if(k==0)break;
                
                n -= enemy[i];
                k--;
                pq.offer(enemy[i]);
                int temp = pq.poll();
                n+= temp;
                // System.out.println(i);
                // System.out.println(temp);
                // System.out.println(n);
                // System.out.println();
                continue;
            }
            n -= enemy[i];
            pq.offer(enemy[i]);
        }

        
        return answer;
    }
}