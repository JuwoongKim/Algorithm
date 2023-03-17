import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main{

    
    public static int MAX_LEVEL = 9; 
    public static int answer = Integer.MAX_VALUE;
    

    public static void main (String [] args)throws IOException{

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        
        String [] [] arr = new String [3][3] ;


        for(int i =0; i <n ; i++){

            // 표 초기화 ... 안해도 됨 
            answer= Integer.MAX_VALUE;

            // 표에 값대입 
            for (int r =0 ; r<3 ; r++ ){
                arr[r] = br.readLine().split(" "); 
            }

            dfs(0,arr,new ArrayList<>());

            if(answer == Integer.MAX_VALUE ) answer = -1;
            System.out.println(answer);

        }

    }

    public static void dfs(int level, String[][] arr, List<Integer> list){

         if(isSame(arr)){
            answer = Math.min(answer, level);
            return;
        }

        if(level==MAX_LEVEL) return;

        for(int i =1 ; i<=8; i++){

            if(list.contains(i)) continue;

            list.add(i);
            changeArr(i, arr);
            dfs(level+1, arr, list);
            list.remove(list.size()-1);
            changeArr(i, arr);

        }

    }


    public static boolean isSame ( String [][] arr) {

        boolean isSame = true;

        String first = arr[0][0];

        for(int r =0; r<3; r ++){
            for(int c =0; c<3 ; c++){
                if(!first.equals(arr[r][c])) isSame=false;
            }
        }

        return isSame;
    }



    public static void changeArr(int mode, String[][] arr){

        switch(mode){


            case 1 : //세로1
                    for(int r = 0; r<3; r ++){

                        if(arr[r][0].equals("T")) arr[r][0] ="H";
                        else arr[r][0] ="T";
                    }
                    break;

            case 2 : //세로2
                for(int r = 0; r<3; r ++){

                    if(arr[r][1].equals("T")) arr[r][1] ="H";
                    else arr[r][1] ="T";
                }
                break;

            case 3 : //세로3
                for(int r = 0; r<3; r ++){

                    if(arr[r][2].equals("T")) arr[r][2] ="H";
                    else arr[r][2] ="T";
                }
                break;


            case 4 : //가로1
                for(int c = 0; c<3; c ++){

                    if(arr[0][c].equals("T")) arr[0][c] ="H";
                    else arr[0][c] ="T";
                }
                break;


            case 5 : //가로2
                for(int c = 0; c<3; c ++){

                    if(arr[1][c].equals("T")) arr[1][c] ="H";
                    else arr[1][c] ="T";
                }
                break;

            case 6 : //가로3
                for(int c = 0; c<3; c ++){

                    if(arr[2][c].equals("T")) arr[2][c] ="H";
                    else arr[2][c] ="T";
                }
                break;


            case 7 : //대각선1
                for(int t = 0; t<3; t ++){

                    if(arr[t][t].equals("T")) arr[t][t] ="H";
                    else arr[t][t] ="T";
                }
                break;

            case 8 : //대각선2
                for(int t = 0; t<3; t ++){

                    if(arr[t][2-t].equals("T")) arr[t][2-t] ="H";
                    else arr[t][2-t] ="T";
                }
                break;
        }
    }
}
