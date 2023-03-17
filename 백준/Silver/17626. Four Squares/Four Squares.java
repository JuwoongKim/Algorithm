import java.util.*;
import java.io.*;

public class Main {

    public static void main(String [] arg) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        T.solution(N);
    }

    public void solution(int N){

        int [] dp = new int [N+1];

        dp[1] =1;
        int min;
        for(int i=2; i<=N; i++){
            min = Integer.MAX_VALUE;
            for(int j =1; j*j<=i; j++){
                min = Integer.min(min, dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[N]);
    }
}
