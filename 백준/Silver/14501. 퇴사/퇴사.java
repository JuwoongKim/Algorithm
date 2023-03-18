import java.util.*;
import java.util.stream.*;
import java.io.*;

class Day{

    int person;
    int money;

    public Day(int person, int money){
        this.person = person;
        this.money = money;
    }
}

public class Main {
    

    public static int answer = Integer.MIN_VALUE;

    public static void main (String [] args) throws IOException {


        BufferedReader br = new BufferedReader( new InputStreamReader (System.in));
  
        int n = Integer.parseInt(br.readLine());

        List<Day> dayList = new ArrayList<>();

        for(int i =0 ; i<n ; i++){

            int [] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dayList.add(new Day(input[0], input[1]));

        }

        dfs( new ArrayList<>(), dayList);
        System.out.println(answer);
    }


    public static void dfs(  List<Integer> memo , List<Day> dayList){

        int startIdx =  (memo.size()==0) ? 0 : (memo.get(memo.size()-1) + dayList.get(memo.get(memo.size()-1)).person);

      
        if( startIdx >= dayList.size()){

            int result = 0 ;

            for(int i =0 ; i<memo.size()-1 ; i++){
                result += dayList.get(memo.get(i)).money;
            }

            if(startIdx == dayList.size()) result +=  dayList.get(memo.get(memo.size()-1)).money;
            
            answer = Math.max(answer, result);
            return;
        }

        for(int i = startIdx ; i<dayList.size() ; i ++ ){

            memo.add(i);
            dfs (memo, dayList);
            memo.remove(memo.size()-1);
        } 
    }

}
