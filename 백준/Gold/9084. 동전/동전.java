import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());


        for(int i =0; i<N ; i++){

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
         
            st = new StringTokenizer(br.readLine());
            int [] arr = new int [n+1];
            for(int j =1; j<=n; j++)
                arr[j] = Integer.parseInt(st.nextToken());            

            st = new StringTokenizer(br.readLine());
            int t  = Integer.parseInt(st.nextToken());
            
            int [][] dp = new int [n+1][t+1];
            for(int j=0;  j<=n; j++)
                dp[j][0]=1;
            getResult(dp, arr , t);

            System.out.println(dp[n][t]);
        }

    }

    public static void getResult(int [][] dp, int [] arr, int target ){

        int N = dp.length;
        int T = dp[0].length;

        for(int n =1; n<N; n++){
            for(int t =1; t<T; t++){
                if(t<arr[n]) dp[n][t] = dp[n-1][t];
                else dp[n][t] =  dp[n-1][t] + dp[n][t-arr[n]];
            }
        }
    }
}
