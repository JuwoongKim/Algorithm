import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			
			String [] arr = br.readLine().split(" "); 			

			StringBuilder sb1 = new StringBuilder("");
			while(sb1.length()<=150) {
				sb1.append(arr[0]);
			}
			
			StringBuilder sb2 = new StringBuilder("");
			while(sb2.length()<=150) {
				sb2.append(arr[1]);
			}
			
			if(sb1.toString().substring(0,101).equals(sb2.toString().substring(0,101))) System.out.printf("#%d %s%n", t,"yes");
			else  System.out.printf("#%d %s%n", t,"no");
			
		}	
	}	
}