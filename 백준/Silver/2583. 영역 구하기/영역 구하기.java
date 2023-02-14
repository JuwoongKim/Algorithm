import java.util.*;
import java.util.stream.Stream;
import java.io.*;


public class Main {
    
    static boolean[][] map;

    public static void main(String [] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Integer [] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]:: new);
        Integer m = nums[0]; Integer n = nums[1]; Integer k = nums[2];

        map = new boolean [m][n];
   
        // map 값 대입 
        for(int i =0 ; i<k ;i ++){

            Integer [] pointList = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]:: new);

            for(int y = pointList[1] ; y <=pointList[3]-1; y++){
                for(int x = pointList[0] ; x <=pointList[2]-1; x++){
                    map[y][x] = true;
                }
            }

        }

        // 탐색 
        int count =0;
        List<Integer> sizeList = new ArrayList<>();

        // 전체 순회 
        for(int i =0;i<m ; i++){
            for(int j =0; j<n;j++){

                if(!map[i][j]){
                    count ++;
                    int size = getSize(i,j);
                    sizeList.add(size);
                }

            }
        }

        // 결과 출력 
        System.out.println(count);

        Collections.sort(sizeList);
        for(int size : sizeList){
            System.out.print(size + " ");
        }

    }

    // BFS를 통한 크기조사 
    public static int getSize(int i, int j){

        int [] x = {1,0,-1,0};
        int [] y = {0,1,0,-1};    

        int resultSize =0;
        
        Queue<Info> q = new LinkedList<>();

        //맨처음 방문처리 꼭꼭 하기  
        map[i][j] = true;
        q.offer(new Info(i,j));

        while(!q.isEmpty()){

            Info temp = q.poll();
            resultSize ++;

            for(int idx =0; idx<4; idx++){
                int tempY = temp.y+y[idx];
                int tempX = temp.x+x[idx];

                if(tempY>=0 && tempY<map.length && tempX>=0 && tempX <map[0].length){

                    if(!map[tempY][tempX]){
                        //방문처리 
                        map[tempY][tempX] = true;
                        //큐 대입 
                        q.offer(new Info(tempY, tempX));
                    }
                }
            }
        }
        return resultSize;
    }


}

class Info{

    int y;
    int x; 

    public Info(int y, int x ){
        this.y = y;
        this.x= x;
    }
}
