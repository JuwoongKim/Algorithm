import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int V, M;
	
	public static int[] parent;

	public static class Node implements Comparable<Node>{
		int posA;
		int posB;
		int cost;
		
		public Node(int a, int b, int c) {
			posA=a;
			posB=b;
			cost=c;
		}
		
		@Override
		public int compareTo(Node other) {
			if(this.cost < other.cost) {
				return -1;
			}else {
				return 1;
			}
		}
	}
	
	public static int findParent(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b){
		int pa = findParent(a);
		int pb = findParent(b);
		
		if(pa < pb)
			parent[pb] = pa;
		else {
			parent[pa] = pb;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			q.add(new Node(a,b,cost));
		}
		
		parent = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		int result = 0;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			int a = node.posA;
			int b = node.posB;
			int cost = node.cost;
			
			if(findParent(a) != findParent(b)) {
				unionParent(a,b);
				result += cost;
			}
		}
		
		System.out.println(result);
		
	}
}