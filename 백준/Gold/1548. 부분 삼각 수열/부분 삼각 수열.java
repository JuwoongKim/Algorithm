import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Main {

    public static int answer = Integer.MIN_VALUE;

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];

        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        for(int  i =0 ; i<n-1; i++){
            for(int j = n-1; j>=0; j--){

                if(i+1>=j) break;

                if(arr[i]+arr[i+1]> arr[j]){
                    answer = Math.max(answer , j-i+1);
                    break;
                }
            }
        }

        if(answer == Integer.MIN_VALUE){

            if(n==1) answer =1;
            else if (n>=2) answer =2;
        }

        System.out.println(answer);
    }
}
