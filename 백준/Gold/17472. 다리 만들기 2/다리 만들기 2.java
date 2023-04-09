import java.util.*;
import java.util.stream.*;
import java.io.*;



class Edge{

    int s;
    int e;
    int l;

    public Edge( int s, int e, int l){
        this.s=s;
        this.e=e;
        this.l=l;
    }
}



public class Main{

    public static int [][]map;
    public static boolean [][]visit;
    public static int [] dr = {0, 1, 0, -1};
    public static int [] dc = {1, 0, -1, 0};

    public static void main(String [] args )throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer (br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //map에 대한 정보를 입력함 
        map = new int [N][M];
        for(int i =0; i<N; i++)
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //순회하며 섬을 구별하고 갯수를 센다.
        visit = new boolean [N][M];
        int num = checkMap();

        // 테스트 
        //System.out.println(num);   Stream.of(map).forEach(row-> System.out.println(Arrays.toString(row))); System.out.println();

        // 가로 세로를 하며 가능한 간선 정보를 모두 모은다.
        List<Edge> edgeList=  getEdgeList();



        // 길이가 작은 숫자부터 정렬 
        Collections.sort(edgeList, (o1,o2)->o1.l-o2.l);

        // for(Edge ele : edgeList)
        //     System.out.println(ele.s + "   " + ele.e + "   " + ele.l + "   " );

        // 유니온 파인드 자료구조를 통해 작은 노드부터 
        int [] uf = new int [num+1];
        for(int i=1; i<=num; i++)
            uf[i] = i;

        // 유니온 파인드 자료구조를 사용해서 최솟값을 구하자 
        int answer = 0;
        for(Edge ele : edgeList){

            if(uf[ele.s] == uf[ele.e]) continue;

            answer += ele.l;

            if(ele.s>=ele.e) {
                int value = uf[ele.s];
                for(int i=1; i<=num; i++)
                    if(uf[i]== value) uf[i] = uf[ele.e];            
            }
            else{
                int value = uf[ele.e];
                for(int i=1; i<=num; i++)
                    if(uf[i]== value) uf[i] = uf[ele.s];    
            }  

            // System.out.println(ele.s + "   " + ele.e + "   " + ele.l + "   " );
            // System.out.println(Arrays.toString(uf));
            // System.out.println();

        }

        // 모든 섬을 연결하느 것이 불가능 하다면 .. -1 
        
        int v = uf[1]; 
        for(int i=2; i<=num; i++){
            if(uf[i]==v) continue;
            answer = -1;
            break;
        }
            
        System.out.println(answer);
    }



    public static List<Edge> getEdgeList(){

        int N = map.length; int M = map[0].length;

        List<Edge> edgeList = new ArrayList<Edge>();

        boolean start;  

        // 가로를 탐색한다
        for(int r =0; r<N; r++){
            start = false;
            int s = -1; int e = -1; int l =0;
            for(int c =0; c<M; c++){
                
                // 시작 
                if(map[r][c]!=0 && !start){
                    s = map[r][c]; start= true;
                    continue;
                }

                // 빈칸 
                if(map[r][c]==0 && start){
                    l++;
                    continue;
                }

                // 끝
                if(map[r][c]!=0 && start){
                    e = map[r][c];
                    if(l>=2) edgeList.add(new Edge(s, e, l));
                    l=0;
                    s=e;
                }
            }
        }


        // 세로를 탐색한다.
        for(int c =0; c<M; c++){
            start = false;
            int s = -1; int e = -1; int l =0;
            for(int r =0; r<N; r++){
                
                // 시작 
                if(map[r][c]!=0 && !start){
                    s = map[r][c]; start= true;
                    continue;
                }

                // 빈칸 
                if(map[r][c]==0 && start){
                    l++;
                    continue;
                }

                // 끝
                if(map[r][c]!=0 && start){
                    e = map[r][c];
                    if(l>=2) edgeList.add(new Edge(s, e, l));
                    l=0;
                    s=e;
                }
                
            }
        }


        return edgeList;
    }


    public static int checkMap (){

        int N = map.length;
        int M = map[0].length;
        int num =0;

        for(int r =0; r<N; r++){
            for(int c = 0; c<M; c++){
                if(map[r][c]==1 && !visit[r][c]){
                    num ++;
                    dfs(r,c,num);
                }
            }
        }

        return num;
    }

    public static void dfs (int r, int c, int num){

        int N = map.length; int M = map[0].length;

        visit[r][c] = true;
        map[r][c] = num;

        for(int i=0;i<4;i++){

            int nr = r + dr[i];
            int nc = c + dc[i];

            // map 조건 확인 
            if(nr>=N || nr<0 || nc>=M || nc<0 || map[nr][nc]==0) continue;

            // visit 조건 확인 
            if(visit[nr][nc]) continue;

            dfs(nr,nc,num);

        }

    }

}