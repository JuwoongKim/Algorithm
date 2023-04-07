import java.util.*;
import java.util.stream.*;
import java.io.*;



class Main{

    public static int [][]  map; 
    public static int [][] inputInfo;
    public static boolean [] visit; 
    public static int answer;

    public static void main(String [] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int [N][M];

        // map 정보 입력 
        for(int i =0; i< N; i++)
            map[i]= Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // input 정보 입력 
        inputInfo = new int [K][3];
        for(int i =0; i<K; i++)
            inputInfo[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        
        // info 순서에 대한 rec   
        visit = new boolean[K];
        answer = Integer.MAX_VALUE;
        int [] memo = new int [K];
        rec(0, memo);

        System.out.println(answer);

    }


    public static void rec(int level, int [] memo){


        if(level== memo.length){

            int [][] tempMap = getCopyMap();
            int [][] tempInputInfo = getCoptInputInfo();

            for(int idx : memo){
                int [] input = tempInputInfo[idx];
                compute(input, tempMap);
            }
   
            int tempAnswer = getAnswer(tempMap);
//            System.out.println(tempAnswer);
            
            answer = Math.min(answer, tempAnswer);

            return;
        }


        for(int i =0; i<inputInfo.length; i++){
            
            if(visit[i]) continue;
            
            memo[level] = i;
            visit[i] = true;
            rec(level+1, memo);
            visit[i] = false;
        }



    }



    public static void compute(int [] input, int [][] map){
        
        // 연산 종료 조건
        if(input[2]==0) return;

        int r1 = input[0]-input[2]-1; int c1 = input[1]-input[2]-1;
        int r2 = input[0]+input[2]-1; int c2 = input[1]+input[2]-1;

        
        int start = map[r1][c1];
            
        //좌
        for(int r =r1; r<r2; r++)
            map[r][c1] = map[r+1][c1];

        //하
        for(int c = c1; c<c2; c++)
            map[r2][c] = map[r2][c+1];

        //우
        for(int r = r2; r>r1; r--)
            map[r][c2] = map[r-1][c2];

        //상
        for(int c = c2; c>c1; c-- )
            map[r1][c] = map[r1][c-1];
        
        //마지막 대입 
        map[r1][c1+1] = start;


        // System.out.println (r1 + " " + c1 + " " + r2 + " " + c2);
        // Stream.of(map).forEach(arr-> System.out.println(Arrays.toString(arr)));
        // System.out.println();
        
        
        // 죄표 갱신 후 재귀
        input[2] --; 
        compute(input, map);

    }

    public static int getAnswer(int [][] map){

        int sum = Integer.MAX_VALUE;

        for(int r =0; r< map.length; r++){
            int tempSum =0;
            for(int c = 0; c< map[0].length; c ++)
                tempSum += map[r][c];
            sum = Math.min(sum, tempSum);
        }

        return sum;

    }

    public static int [][] getCopyMap(){

        int N= map.length;
        int M = map[0].length;

        int [][] tempMap  = new int [N][M];

        for(int r=0; r<N; r++)
            for(int c =0; c<M; c++)
                tempMap[r][c] = map[r][c];
     
        return tempMap;
    }

    public static int [][] getCoptInputInfo(){

        int N= inputInfo.length;
        int M = inputInfo[0].length;

        int [][] tempInputInfo  = new int [N][M];

        for(int r=0; r<N; r++)
            for(int c =0; c<M; c++)
                tempInputInfo[r][c] = inputInfo[r][c];
     
        return tempInputInfo;

    }

}