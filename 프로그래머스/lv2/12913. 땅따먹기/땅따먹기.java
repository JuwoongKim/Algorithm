
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int R = land.length;
        int C = land[0].length;

        int [][] dp = new int [R][C];

        dp[0] = land[0];
        
        for(int r =1; r<R; r++){
            for(int c =0; c<C; c++){
                int temp =0;
                for(int sc=0; sc<C; sc++){
                    if(sc==c) continue;
                    temp = Math.max(temp, dp[r-1][sc]);
                }
                dp[r][c] = temp+land[r][c];
            }
        }
        
        
        for(int c=0; c<C; c++){
            answer = Math.max(answer, dp[R-1][c]);
        }
            

        return answer;
    }
}