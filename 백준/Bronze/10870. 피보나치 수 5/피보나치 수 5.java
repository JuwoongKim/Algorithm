import java.util.*;
import java.util.stream.*;
import java.io.*;

// bottom up 

class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        

        int [] dp = new int [N+1];

        dp[0] =0;   
        
        if(N>=1)
            dp[1] =1;
        
        if(N>=2)
            for(int i =2; i<=N; i++)
                dp[i] = dp[i-1] + dp[i-2];
        
        System.out.println(dp[N]);

    }
}


