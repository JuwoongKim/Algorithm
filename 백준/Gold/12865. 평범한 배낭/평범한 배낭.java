import java.util.*;
import java.util.stream.*;
import java.io.*;


class Book{
    int w;
    int v;

    public Book(int w, int v){
        this.w= w;
        this.v= v;
    }
}

public class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Book> bookList = new ArrayList<>();
        
        for(int i =0; i<=N;i++){
            if(i==0) bookList.add(new Book(0,0));
            else{
                int [] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                bookList.add(new Book(input[0],input[1]));
            }
        }

        int [][] dp = new int [N+1][K+1];
        
        for(int n=1; n<=N; n++){
            for(int k=1; k<=K; k++){
                if(k<bookList.get(n).w)  dp[n][k] = dp[n-1][k];
                else{
                    dp[n][k] = Math.max(dp[n-1][k], dp[n-1][k-bookList.get(n).w]+ bookList.get(n).v);
                } 
            }
        }

        // for(int i =0; i<=N; i++)
        //     System.out.println(Arrays.toString(dp[i]));

        System.out.println(dp[N][K]);
    }
}