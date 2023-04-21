import java.util.*;
import java.util.stream.*;
import java.io.*;

// top down

class Main{

    public static int [] dp;

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        

        // N에서 1로 만드는 연산의 최소 갯수  
        dp = new int [N+1];
        int answer = func(N);

        System.out.println(answer);
    }

    public static int func(int N){

        if(N==1){
            dp[N] =0;
            return dp[N]; 
        }

        dp[N] = func(N-1)+1;        
        if(N%2==0)
            dp[N] = Math.min(dp[N], func(N/2)+1);
        if(N%3==0)
            dp[N] = Math.min(dp[N], func(N/3)+1);            
        return dp[N];
    };


}


