import java.util.*;
import java.io.*;


class Node{

    int t;
    int s;

    public Node(int t, int s){    
        this.t = t;
        this.s = s;
    }

}


public class Main{

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int [][] dp = new int [N][T+1];

        List<Node> nodeList =new ArrayList<>();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int t  = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(t,s));
        }


        for(int n=0; n<N; n++){
            for(int t=1; t<=T; t++){   
                if(nodeList.get(n).t>t){
                    if(n!=0) dp[n][t]=dp[n-1][t];
                }else{
                    if(n!=0) dp[n][t] = Math.max( dp[n-1][t] , dp[n-1][t-nodeList.get(n).t] + nodeList.get(n).s);
                    else dp[n][t] = nodeList.get(n).s; 
                }
            }
        }

        System.out.println(dp[N-1][T]);
    }

}
