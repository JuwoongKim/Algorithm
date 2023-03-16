import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main{

    public static int N;
    public static int k;
    public static int [] kArr;

    public static int answer=Integer.MIN_VALUE;

    public static void main(String args []) throws IOException{


        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        kArr =Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(kArr);
        
        dfs(0);
        System.out.println(answer);

    }

    public static void dfs( int num){

        if(num>N){
            return;
        }

        if(answer<=num) answer = num;

        for(int i =0; i<kArr.length; i++){

            int temp = num*10 + kArr[i];

            dfs(temp);
        }
    }
}