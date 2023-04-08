import java.util.*;
import java.util.stream.*;
import java.io.*;

class Main{

    public static int [][] info;
    public static boolean[] visit;
    public static int answer;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        info = new int [N][9];
        for(int i =0; i<N; i++)
            info[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Stream.of(info).forEach(row-> System.out.println(Arrays.toString(row)));

        answer = 0;
        visit = new boolean [9];
        int [] od = new int [9]; 
        od[3] = 0;  visit[0] = true;        
        rec(0, od);        

        System.out.println(answer);
    }

    public static void rec(int idx, int [] od){

        if(idx==3) {
            rec(idx+1, od);  // 미리 정해진 순서 
            return;
        }
        if(idx==9){
            // 순서가 다 결정되면 작업시작
            //System.out.println(Arrays.toString(od));
            int score = getScore(od);
            answer = Math.max(answer, score);
            return;
        }

        for(int i=0; i<9; i++){
            if(visit[i]) continue;

            od[idx] =i; visit[i] =true;
            rec(idx+1, od);
            visit[i] =false;
        }

    }


    public static int getScore(int [] od){

        // 한 이닝이 끝나면 이전 기록은 무효
        int score =0;
        int [] sp =new int [1];

        int N = info.length;
        for(int in =0; in<N; in++){

            score += getInScore(in, od, sp);
        }
        
        return score;
    }

    public static int getInScore(int in, int[] od, int []sp){

        int inScore = 0;
        int oCnt=0;
        int [] fdInfo = new int [9];

        while(oCnt<3){

            int act = info[in][od[sp[0]]];  // 한 선수의 활동 

            switch(act){

                case 0 :
                    oCnt ++;
                    break;
                case 1 :
                    inScore += updatefd(1, od[sp[0]], fdInfo);
                    break;
                case 2 :
                    inScore += updatefd(2,  od[sp[0]], fdInfo);
                    break;
                case 3 :
                    inScore += updatefd(3,  od[sp[0]], fdInfo);
                    break;
                case 4 :
                    inScore += updatefd(4,  od[sp[0]], fdInfo);
                    break;
                }
            
            sp[0] = (sp[0]+1)%9;    // 다움선수 찾기 
        }
     
        return inScore;
    }

    public static int updatefd(int cnt, int spIdx, int [] fdInfo){

        int score = 0;

        // 필드에 있는 선수 기록 업데이트
        int N = fdInfo.length;
        for(int i =0; i<N; i++){
            if(fdInfo[i]==0) continue;
            fdInfo[i] = fdInfo[i] +cnt;
            if(fdInfo[i]>=4){
                fdInfo[i]=0;
                score ++;
            }
        }
        // 당사자 기록 업데이트
        fdInfo[spIdx] = cnt;
        if(fdInfo[spIdx]>=4){
            fdInfo[spIdx]=0;
            score ++;
        }

        return score;
    }

}