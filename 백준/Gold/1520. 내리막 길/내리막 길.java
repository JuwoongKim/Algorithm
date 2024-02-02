import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int[][] dp;
	private static int[] l = {-1,1,0,0};
	private static int[] r = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}	
		}
		
		dp = new int[N][M];
		PriorityQueue<Node> qu = new PriorityQueue<Node>();
		
		qu.add(new Node(0,0,arr[0][0]));
		dp[0][0] = 1;
		
		while (!qu.isEmpty()) {
			Node newNode = qu.poll();
			int cx = newNode.getX();
			int cy = newNode.getY();
			int cval = newNode.getVal();
			
			for (int i = 0; i < 4; i++) {
				int nx = cx + l[i];
				int ny = cy + r[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					int nval = arr[nx][ny];
					if (cval > nval) {
						
						if (dp[nx][ny] == 0) {
							qu.add(new Node(nx, ny, nval));
							dp[nx][ny] += dp[cx][cy]; 
						} else {
							dp[nx][ny] += dp[cx][cy];
						}
					}
				}
			}
		}
		
		System.out.println(dp[N-1][M-1]);
	}
	
}

class Node implements Comparable<Node> {
	private int x;
	private int y;
	private int val;
	
	Node(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}

	public int compareTo(Node node) {
		if (this.val < node.val) {
			return 1;
		} else if (this.val > node.val) {
			return -1;
		} else {
			return 0;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVal() {
		return val;
	}
}