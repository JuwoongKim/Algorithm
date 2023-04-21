import java.util.*;
import java.util.stream.*;
import java.io.*;

// bottom up

class Main{


    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        

        // N에서 1로 만드는 연산의 최소 갯수  
        int [] dp = new int [N+1];
        
        for(int i =2; i<N+1; i++){
            dp[i] =dp[i-1] +1;
            if(i%2==0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i%3==0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);            
        }

        System.out.println(dp[N]);

    }

}
