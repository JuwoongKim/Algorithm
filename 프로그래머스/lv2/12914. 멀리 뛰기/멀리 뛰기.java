class Solution {
    public long solution(int n) {
        long answer = 0;
        
        int [] dp = new int [2001];
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        
        if(n<5) return dp[n];
        
        for(int i =5; i<=n; i++){
            
            dp[i] = ( dp[i-1] + dp[i-2] )%1234567;
        }
        
        answer = dp[n];
        
        return answer;
    }
}