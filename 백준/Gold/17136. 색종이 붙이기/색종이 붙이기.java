import java.util.*;
import java.io.*;
import java.util.stream.*;



class Main{

    public static int answer = Integer.MAX_VALUE;
    public static final int SIZE = 10;
    public static final int MODE_CNT = 5;

    public static int ddd=0;
    
    public static void main(String [] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // map 에 입력값 대입
        int [][] map = new int [SIZE][SIZE];
        for(int i =0; i<SIZE; i++)
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        

        // 색종이 사용횟수를 위한 자료구조 
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i =0; i<MODE_CNT; i++ ){
            countMap.put(i,0);
        }

        rec(countMap,map);

        if(answer ==  Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
        
    }


    public static void rec (Map<Integer, Integer> countMap , int [][] map) {

        // System.out.println(countMap);
        // Stream.of(map).forEach(arr -> System.out.println(Arrays.toString(arr)));
        // System.out.println();



        // 조건 만족하면 종료 
        if(isSatisfied(map)){

            int tempAnswer = getAnswer(countMap);
            answer = Math.min(answer, tempAnswer);
            return;
        }

        //그래프를 순회함 
        boolean check = false;
        for(int r=0; r<SIZE; r++){
            for(int c=0; c<SIZE; c++){

                if(map[r][c]==0) continue;

                // 1이라면
                check=true;
                for(int i =0; i<5; i++){
                   
                    // i 크기 색종이가 5번 이상 사용했을겅우 제외 
                    if(countMap.get(i)==5) continue;
                   
                    // i 크기 색종이가 정확히 1을 커버 못할 경우 제외 
                    if(!isPassible(i,r, c,  map)) continue;

                    //System.out.println(r + "  "+ c);

                    // 되면 조건을 만족한뒤 재귀를 쓰자  ( 카운트 추가, map 복사) 
                    countMap.put(i, countMap.get(i)+1);
                    int [][] updateMap = getUpdateMap(i,r, c,map);
                    
                    rec( countMap, updateMap );
                    
                    // 원래대로
                    countMap.put(i, countMap.get(i)-1);   
                
                }

                if(check) break;
            }
            if(check) break;
        }


    }


    public static boolean isSatisfied(int [][]map){


        for(int [] r : map)
            for(int c : r)
                if(c==1) return false;
        

        return true;
    }


    public static int  getAnswer(Map<Integer, Integer> countMap){

        int sum =0;

        for(int value : countMap.values())
            sum+=value;

        return sum;
    }



    public static boolean isPassible(int i, int startR, int startC,  int [][]map){

        int endR = startR+i; int endC = startC+i;

        //범위를 벗어나는지 
        if(endR>=map.length || endC >= map[0].length ) return false;

        // 해당 범위에  0이 포함되는지
        for(int r = startR; r<=endR; r++){
            for(int c = startC; c<=endC; c++){
                if(map[r][c]==0) return false;
            }
        }

        return true;

    }

    public static int [][] getUpdateMap(int i, int startR, int startC, int [][] map){

        int [][] copyMap = new int [map.length][map[0].length];

        // 단순 복사 
        for(int r=0; r<copyMap.length; r++)
            for(int c =0 ; c<copyMap[0].length; c++)
                copyMap[r][c] = map[r][c];

        
        // 복사후 작업 업데이터 
        int endR = startR+i; int endC = startC+i;
        for(int r = startR; r<=endR; r++){
            for(int c = startC; c<=endC; c++){
                copyMap[r][c]=0;
            }
        }

        return copyMap;
    }


}   