import java.util.*;
import java.util.stream.*;
import java.io.*;

// bottom up
class Main{
    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        
        
        int [] ele = new int [N+1];
        for(int i =1; i<=N; i++)
            ele[i] = Integer.parseInt(br.readLine());
        
        int [][] dp = new int [2][301];
        

        // dp[0] 이전방문 없이 방문힌 최댓값 
        // dp[1] 이전방문 있이 방문한 최댓값
        dp[0][1] = ele[1]; 
        dp[1][1] = ele[1];

        for(int i=2; i<=N; i++){
            dp[1][i] = Math.max ( dp[0][i-1], dp[1][i-2]) + ele[i];
            dp[0][i] = Math.max( dp[0][i-2], dp[1][i-2]) + ele[i];
        }

        // System.out.println(Arrays.toString(ele));
        // System.out.println(Arrays.toString(dp[0]));
        // System.out.println(Arrays.toString(dp[1]));

        System.out.println( dp[1][N]);
    }
}
