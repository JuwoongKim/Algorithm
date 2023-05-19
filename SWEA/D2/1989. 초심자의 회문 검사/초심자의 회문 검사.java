import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {	
			
			String str = br.readLine();
			
			int st=0;
			int ed = str.length()-1;
			
			boolean check = true;
			while(st<ed) {
				if(str.charAt(st)!=str.charAt(ed)) {
					check = false;
					break;
				}
				st ++;
				ed --;
			}
			
			if(check) System.out.printf("#%d %d%n", t, 1);
			else System.out.printf("#%d %d%n", t, 0);		
		}		
	}
	
}