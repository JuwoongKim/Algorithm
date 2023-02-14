import java.util.*;
import java.io.*;


public class Main {
    
    
    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer [] arr =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);

        Integer prefix_sum =  Arrays.stream(arr).mapToInt(Integer::intValue).sum();
         
        long result =0;

        for(int i =0; i<arr.length-1 ; i++){

            prefix_sum = prefix_sum -arr[i];
            result += arr[i]*prefix_sum;
        }

        System.out.println(result);

    }

}