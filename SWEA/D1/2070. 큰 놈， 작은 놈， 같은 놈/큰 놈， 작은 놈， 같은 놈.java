
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
        
		for(int i =0; i<N; i++) {
			int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if (arr[0]>arr[1]) System.out.println(String.format("#%d %s",i+1, ">" ));
			else if(arr[0]<arr[1]) System.out.println(String.format("#%d %s",i+1, "<"));
			else System.out.println(String.format("#%d %s",i+1, "=" ));

		}	
	}	
}
