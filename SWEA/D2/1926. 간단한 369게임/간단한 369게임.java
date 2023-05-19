
import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

	public static void main (String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
        
		StringBuilder sb = new StringBuilder("");
		for(int i =1; i<=N; i++) {
		
			String str = String.valueOf(i);
			
			if(str.contains("3")||str.contains("6")||str.contains("9")) {
				
				for(char ch : str.toCharArray()) {
					if(ch=='3' || ch=='6' || ch=='9')
						sb.append("-");
				}
			}else {
				sb.append(i);
			}
			sb.append(" ");	
		}		
		System.out.println(sb.toString());
	}	
}
