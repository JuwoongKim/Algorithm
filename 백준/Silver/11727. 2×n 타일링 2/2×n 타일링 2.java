import java.util.*;
import java.util.stream.*;
import java.io.*;

// bottom up
class Main{
    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        

        int [] dp = new int [1000+1];
        dp[1] =1;
        dp[2] =3;

        for(int i =3; i<=N; i++){
            dp[i] = dp[i-1]+2*dp[i-2];
            dp[i] %= 10007;
        }          
        
        System.out.println(dp[N]);
    }
}