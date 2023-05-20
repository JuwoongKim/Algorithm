import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	

			long N = Long.parseLong(br.readLine());
			
			long n = (long)Math.sqrt(N);
			long min = Long.MAX_VALUE;
			
			for(long i=1; i<=n; i++) {
				if(N%i==0) {
					long j = N/i;
					long temp = (i-1) + (j-1);
					min = Math.min(min, temp);
				}
			}
			
			System.out.printf("#%d %d%n", t, min);
		}	
	}	
}
