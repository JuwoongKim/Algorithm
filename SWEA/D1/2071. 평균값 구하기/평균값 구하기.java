
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
        
        
		for(int i =0; i<N; i++) {
			int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			double sum = (double)Arrays.stream(arr).sum();
			double n = (double)arr.length;
			System.out.println(String.format("#%d %d",i+1, (int)Math.round(sum/n)));
			
		}	
	}	
}
