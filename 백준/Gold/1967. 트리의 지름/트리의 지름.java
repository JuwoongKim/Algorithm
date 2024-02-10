import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
	static ArrayList<ArrayList<Node>> tree = new ArrayList<ArrayList<Node>>();
	static boolean[] visited;
	static int answer =0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<=N;i++) {
			tree.add(new ArrayList<Node>());
		}
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			tree.get(start).add(new Node(dest, dist));
			tree.get(dest).add(new Node(start, dist));
		}
		
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			visited[i] = true;
			dfs(i,0);
		}
		System.out.println(answer);
		
	}
	
	static void dfs(int start, int weight) {
		
		for(int i=0;i<tree.get(start).size();i++) {
			if(visited[tree.get(start).get(i).index] == false) {
				visited[tree.get(start).get(i).index] = true;
				dfs(tree.get(start).get(i).index, tree.get(start).get(i).distance + weight);
			}
		}
		if(answer < weight) answer = weight;
	}
	
	static class Node{
		int index;
		int distance;
		Node(int index, int distance){
			this.index = index;
			this.distance = distance;
		}
	}
	
 
}