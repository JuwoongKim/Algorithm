import java.util.*;
import java.io.*;
import java.util.stream.*;



class Main{

    public static int [][] map;
    public static int answer;
    public static int N;
    public static int M;
    public static int D;
    
    public static void main(String [] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        answer=Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // map 입력값 받기 
        map = new int [N+1][M];
        for(int i =0; i<N; i++){
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 궁수 위치 뽑아서 시뮬레이션 실행 
        for(int g1 =0; g1<M-2; g1++){
            for(int g2 =g1+1; g2<M-1; g2++){
                for(int g3 = g2+1; g3<M; g3++){
                    
                    int [][] tempMap = copyMap();
                    int tempAnswer = play(g1, g2, g3, tempMap);
                    answer = Math.max(answer, tempAnswer);
                }
            }
        }


        System.out.println(answer);
    
    }


    public static int play(int g1, int g2, int g3, int [][] copyMap){


        //  System.out.println("start");
        //  System.out.println("gsPoint  :  " + g1 + " " + g2 + " " + g3);

        int answer = 0;
        int gsRow = copyMap.length-1;

        do{
            //  Stream.of(copyMap).forEach(arr-> System.out.println(Arrays.toString(arr)));
            //  System.out.println();


            // 1. 궁수당 죽을 수 있는 적 선택
            int [][] gsPointArr = new int [][] {{gsRow, g1},{gsRow,g2},{gsRow, g3}};
            int [][] targetPointArr = new int [][]{{-1,-1},{1,-1},{1,-1}};
            
            for(int i =0; i<gsPointArr.length; i++){
                targetPointArr[i] = getTargetPoint(gsPointArr[i], copyMap);
            }

            //Stream.of(targetPointArr).forEach(arr-> System.out.println(Arrays.toString(arr)));


            // 2. 적 삭제 + 적삭제당 점수 ++;
            int point =0; 
            for(int i =0; i<targetPointArr.length; i++){
                int r = targetPointArr[i][0];
                int c = targetPointArr[i][1];

                if(r==-1) continue;
                if(copyMap[r][c]!=1) continue;
                copyMap[r][c]=0;
                point ++;
            }
            // System.out.println("cntpoint : " + point);
            answer = answer+point;


            // 3. 적 이동 
            move(copyMap);

            // System.out.println();
            // System.out.println();
            // System.out.println();

        }while(!isEnd(copyMap));

        // System.out.println("answer : " + answer);
        // System.out.println("end");

        // 임시용 
        return answer;
    }





    public static int [] getTargetPoint(int[] gsPoint, int [][] copyMap ){

        int [] targetPoint = new int [] {-1,-1};
        int targetD =Integer.MAX_VALUE;

        int N = copyMap.length;
        int M = copyMap[0].length;
        for(int r=0; r<N-1; r++){
            for(int c =0; c<M; c++){
                if(copyMap[r][c]==0) continue;

                int tempD = Math.abs(gsPoint[0]-r) + Math.abs(gsPoint[1]-c);
                if(tempD>D) continue;

                if(targetD>tempD){
                    targetD = tempD;
                    targetPoint[0] = r;
                    targetPoint[1] = c;
                }
                
                if(targetD==tempD){
                    if(c < targetPoint[1]){
                        targetPoint[0] = r;
                        targetPoint[1] = c;
                    }
                }

            }
        }

        return targetPoint;
    }





    public static void move(int [][] map){      // 처음에 전역번수 n m 을 써서 오류가남... 함수내애서 다처리할것

        int N = map.length;
        int M = map[0].length;


        for(int r = N-2; r>=0; r--){
            for(int c = M-1; c>=0; c--){

                if(map[r][c]==0) continue;

                map[r][c]=0;
                if( r+1 != N-1) map[r+1][c] =1;
            }
        }

    }

    public static boolean isEnd(int [][]map){

        int N = map.length;
        int M = map[0].length;

        for(int r = N-2; r>=0; r--)
            for(int c = M-1; c>=0; c--)
                if(map[r][c]!=0) return false;
            
        return true;   

    }





    public static int[][] copyMap(){

        int [][] copyMap = new int [N+1][M];

        for(int i =0; i<N+1; i++){
            for(int j=0; j<M; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        // Stream.of(map).forEach(arr-> System.out.println(Arrays.toString(arr)));
        // System.out.println();
        // Stream.of(copyMap).forEach(arr-> System.out.println(Arrays.toString(arr)));

         return copyMap;
    }



}