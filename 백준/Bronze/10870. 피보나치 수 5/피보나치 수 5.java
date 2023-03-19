import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main { 


    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
        
        int n = Integer.parseInt(br.readLine());

        int [] memo = new int [n+1];

        if(n==0){
            memo[0] = 0;
            System.out.println(memo[n]);
            return;
        }

        memo[0] = 0; memo[1] =1;

        if(n !=0 && n != 1){
            for(int i=2; i<=n ; i++){
                memo[i]= memo[i-1] + memo[i-2];
            }
        }
        System.out.println(memo[n]);

    }   
}
