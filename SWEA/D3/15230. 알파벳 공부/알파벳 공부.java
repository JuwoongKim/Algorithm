import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "abcdefghijklmnopqrstuvwxyz";
		
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			
			String temp = br.readLine();
			
			int cnt = 0;
			for(int i =0 ; i<temp.length(); i++ ) {	
				if(temp.charAt(i) != str.charAt(i)) {
					break;
				}
				cnt ++;
			}
			System.out.printf("#%d %d%n",t, cnt);	
		}	
	}	
}