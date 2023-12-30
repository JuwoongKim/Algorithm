import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> nodeList = new ArrayList<>(); 
    static int[] numbers; 
    static int[] result; 
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        numbers = new int[N + 1]; 
        result = new int[N + 1];

        for (int i = 0; i <= N; i++) nodeList.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int se = Integer.parseInt(st.nextToken());
            if (se != -1) { 
                nodeList.get(se).add(i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            numbers[node] += value; 
        }

        for (int i = 1; i <= N; i++) {
            if (numbers[i] > 0) BFS(i, numbers[i]); 
        }

        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    public static void BFS(int node, int value) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            result[temp] += value; 
            List<Integer> list = nodeList.get(temp); 
            for (int A : list) queue.add(A);
        }
    }
}