class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int [2]; 
     
        int N = sequence.length;
        int lIdx =0; int rIdx = N;
        int sum=0;
        for(int lt=0, rt=0; lt<N; lt++){
            
            while(sum<k&& rt<N){
                sum += sequence[rt++];
            }
             

            if(sum==k){
                int range = rt-lt;

                if(range< rIdx-lIdx){
                    rIdx =rt;
                    lIdx =lt;
                }
            }
            
            sum -=sequence[lt];
        }
        
        answer[0] = lIdx;
        answer[1] = rIdx-1;
        
        
        
        return answer;
    }
}