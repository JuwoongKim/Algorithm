import java.util.*;
import java.util.stream.*;
import java.io.*;


class Point{
	int r ;
	int c ;
	String v;
	public Point(int r , int c , String v) {
		this.r = r;
		this.c =c;
		this.v =v;
	}
}


class Solution
{
	
	public static int num;
	public static boolean check = false;
	
	 public static void main(String args[]) throws Exception
	 {
		 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for(int t=1; t<=T; t++) {
			 
			String str = br.readLine();
			num= Integer.parseInt(str);
			
			String[] arr = str.split("");
			boolean [] visit = new  boolean[arr.length];
			String [] memo = new  String[arr.length];

			
			dfs(0,visit,arr,memo);
			 
			 
			 if(check) System.out.printf("#%d possible%n", t);
			 else System.out.printf("#%d impossible%n", t);
			
			//check 초기화 
			check =false;
		 }
	 }
	 
	 
	 public static void dfs(int idx, boolean [] visit, String [] arr, String [] memo) {
		 
		 
		 if(idx == arr.length) {
			 String temp = Arrays.stream(memo).collect(Collectors.joining());
			 int tempnum = Integer.parseInt(temp);
			 if(tempnum%num==0&&tempnum!=num ) check = true;
			 return;
		 }
		 
		 for(int i =0; i<arr.length; i++) {
			 if(visit[i]) continue;		 
			 visit[i] = true;
			 memo[idx] = arr[i];
			 dfs( idx+1, visit, arr,memo);
			 visit[i] =false;
			 if(check) return;
		 }	 
	 }	 
}
