import java.util.*;
import java.util.stream.*;
import java.io.*;


class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        long [][] dp = new long [K+1][N+1];

        for(int r =1; r<=K; r++){
            for(int c =0; c<=N; c++){
                if(r==1) dp[r][c] = 1;
                else{
                    for(int i=0; i<=c; i++)
                        dp[r][c] += dp[r-1][i];
                        dp[r][c] %= 1000000000;
                }
            }
        }

        // for(int i=0;i<dp.length; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
       
        System.out.println(dp[K][N]);
    }
}
