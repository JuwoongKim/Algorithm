import java.util.*;
import java.util.stream.*;
import java.io.*;

class Main{

    public static int [] pp;
    public static List<List<Integer>> gp;
    public static int answer;

    public static void main(String [] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        // pp 정보 입력 
        pp = new int [N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            pp[i] = Integer.parseInt(st.nextToken());

        // gp 정보 입력 
        gp = new ArrayList<>();
        for(int i=0; i<=N; i++)
            gp.add(new ArrayList<>());

        for(int i =1; i<=N; i++){
            st= new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j=0; j<size; j++)
                gp.get(i).add(Integer.parseInt(st.nextToken()));
        }

        // 비트마스크를 통해 서로 다른 두집합 생성 
        answer = Integer.MAX_VALUE;
        for(int i =0; i< 1<<N; i++){
            
            //System.out.println();
            boolean [] teamInfo = new boolean [N+1];
            
            for(int j=0; j<N; j++){
                if( (i & 1<<j) !=0){
                    teamInfo[j+1] = true;
                }
            }
            
            // 2개의 팀으로 분리
            List<List<Integer>> team = getSplitTeam(teamInfo);
            // System.out.print ("팀분리   :");
            // System.out.print(team.get(0));
            // System.out.print("    ");
            // System.out.print(team.get(1));
            // System.out.println();
            
            // 한쪽이 비어있으면 종료 
            if(team.get(0).size() ==0 || team.get(1).size() ==0) continue;
           // System.out.println ("팀 크기 조건 확인 ");

            // 팀1 인구수 계산, 안된다면 -1
            int num0 = getPopulation(team.get(0));
            if(num0==0) continue;
            //System.out.println("0팀 연결가능성 확인");

            // 팀2 인구수 계산, 안된다면 -1
            int num1 = getPopulation(team.get(1));
            if(num1==0) continue;
            //System.out.println("1팀 연결가능성 확인");

            // 팀의 인구수차 구하고 answer 값과 비교
            
            int margin = Math.abs(num1-num0);
            
            // System.out.println("인구수 비교 : " +num0 + "  "  +num1 + "  " + margin);
            // System.out.println();
            
            answer = Math.min(answer, margin);
           
        }
        if(answer == Integer.MAX_VALUE ) answer = -1;
        System.out.println(answer);

    }



    public static int getPopulation( List<Integer> team ){

        boolean [] canVisit = new boolean [gp.size()];
        for(int ele : team)
            canVisit[ele]=true;

        int num = 0;

        canVisit[team.get(0)] = false;
        dfs(team.get(0), canVisit);
        
        if(isSatisfied(canVisit)){            
            for(int ele : team)
            num += pp[ele];
        }

        return num;
    }

    public static void dfs(int node, boolean [] canVisit ){

        for( Integer adj : gp.get(node)){

            if(!canVisit[adj]) continue;
            canVisit[adj] =false;
            dfs(adj, canVisit);
        }
    }


    public static boolean isSatisfied (boolean [] canVisit){

        for(boolean ele : canVisit)
            if(ele) return false;
        
        return true;
    }




    public static List<List<Integer>> getSplitTeam(boolean [] teamInfo){

        List<List<Integer>> team = new ArrayList<>();
        team.add(new ArrayList<>());
        team.add(new ArrayList<>());

        int N = teamInfo.length;
        for(int i =1; i<N; i++){
            if(teamInfo[i]) team.get(0).add(i);
            else team.get(1).add(i);
        }

        return team;
    }

    


}