import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int [] route;
    public static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        Main T =new Main();
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        route = new int [M];

        T.DFS(0);
        System.out.println(sb);
    }

    public void DFS(int level){

        if(level ==M){
            for(int ele : route)
                sb.append(ele + " ");
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N ; i++) {

            if (level>0 && i<route[level-1]) continue;

            route[level] = i;
            DFS(level+1);
        }

    }
}