import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;



class Info{

    int row;
    int col;
    int dept;

    public Info (int row, int col, int dept){
        this.row = row;
        this.col = col;
        this.dept = dept;
    }
}


public class Main{

    public static void main(String [] args) throws IOException{


        // 입력값 받기  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());        
        int m = Integer.parseInt(st.nextToken());

        String[][] map = new String[n][m];

        for(int row =0; row<n; row ++){
            st = new StringTokenizer(br.readLine(),"");
            map[row] = st.nextToken().split(""); 
        }


        int [] row ={ 0, 1, 0, -1};
        int [] col ={ 1, 0 ,-1, 0}; 

        // 연산 수행 

        Deque<Info> q = new ArrayDeque<>();
        q.addLast(new Info(0,0,1));

        while(!q.isEmpty()){
            boolean isAnswer = false;
            Info temp = (Info)q.poll();

            for(int i=0 ; i<4; i++){

                int predictRow = temp.row + row[i];
                int predictCol = temp.col + col[i]; 


                // 검증1 (map의 범위를 넘어간다면)
                if(predictRow<0 || predictRow==n || predictCol<0 || predictCol==m ){
                    continue;
                }

                // 검증2 (다음범위의 값이 0이라면 = 이동할 수 없는 부분이라면)
                if(map[predictRow][predictCol].equals("0")){
                    continue;
                }

                // 그게 아니라면 추가 
                q.addLast( new Info(predictRow,predictCol, temp.dept+1));
                
                // 방문표시도 추가 
                map[predictRow][predictCol]="0";

                // 정답인지 확인 
                if( predictRow+1 == n  && predictCol +1 == m ){
                    isAnswer = true;
                    break;
                } 
            }

            if(isAnswer){
                System.out.println(q.getLast().dept);
                break;
            }
        }

    }
}