import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] map;
	static boolean[] visit;
	static int[][] dp;
	
	static void dfs(int tmp) {
		visit[tmp] = true;
		dp[tmp][0] = 0; 
		dp[tmp][1] = 1;
		
		for(int next: map[tmp]) { 
			
			if(visit[next]) continue;
			
			dfs(next);
			dp[tmp][0] += dp[next][1];
			dp[tmp][1] += Math.min(dp[next][0], dp[next][1]);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][2];
		map = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++)
			map[i] = new ArrayList<>();
		
		StringTokenizer st;
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			map[s].add(e);
			map[e].add(s);
		}
		
		visit = new boolean[N+1];
		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
}