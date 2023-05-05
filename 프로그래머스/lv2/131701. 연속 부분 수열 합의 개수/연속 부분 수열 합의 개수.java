import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        int N = elements.length;
        for(int i=1; i<=N; i++){
            for(int j=0; j<N; j++){
                int sum =0;
                for(int k=j; k<j+i; k++){
                    sum+= elements[k%N];
                }
                set.add(sum);
            }
        }
        
        answer = set.size();
        
        return answer;
    }
}