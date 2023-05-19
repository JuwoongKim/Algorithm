import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			
			int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(arr);
			
			double sum = IntStream.range(0, arr.length).filter(idx -> idx!=0 && idx!= arr.length-1 ).mapToDouble(idx->arr[idx]).sum();
			double size = arr.length-2;
			
			System.out.printf("#%d %d%n",t,Math.round(sum/size));
		}	
	}	
}