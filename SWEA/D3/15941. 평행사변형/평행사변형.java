import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			int N = Integer.parseInt(br.readLine());			

			int answer = (int)Math.pow(N, 2);
		
			System.out.printf("#%d %d%n", t,answer);
		}	
	}
	
	public static boolean isSatisfied(int num) {
		
		int bd = (int)Math.sqrt(num);
		
		for(int i =2; i<=bd; i++) {
			if(num%i==0) {
				return true;
			}
		}
		return false;
	}
}
