import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = {};
        
        long facto = getFacto(n-1);
        boolean [] visit = new boolean[n+1];
        int [] memo = new int [n];
        answer = func(n, facto, k , visit, 0, memo);
        
        return answer;
    }
    
    
    public static int [] func(int n, long facto, long k, boolean [] visit, int idx, int [] memo){
    
        // 종료조건 
        if(n ==1){
            
            for(int i=1 ; i<visit.length; i++){
                if(!visit[i]){
                    memo[idx] = i;
                    break;
                }
            }
            //System.out.println(Arrays.toString(memo));
            return memo;
        }
        
        
        // 번째수를 찾는다.
        int num=0;
        for(num =0; num<=n; num++){
            if(facto*num >= k){
                break;
            } 
        }
        
        // k값 갱신
        k -= facto*(num-1);
        
        // 사용하지 않은 번째 수를 찾는다
        for(int i =1; i<visit.length; i++){
            if(visit[i]) continue;
            num --;
            if(num==0){
                visit[i] = true;
                memo[idx] = i;
                break;
            }
        }
        
        //facto 갱신 
        facto = facto/(n-1);
        
        // 다음함수로 넘어감 
        return func(n-1, facto, k, visit, idx+1, memo);
        
    }
    
    
    
    public static long getFacto(int n){
        long value = 1;
        for(int i =n ; i>0; i--){
            value *=i;
        }
        return value;
    }
    
}