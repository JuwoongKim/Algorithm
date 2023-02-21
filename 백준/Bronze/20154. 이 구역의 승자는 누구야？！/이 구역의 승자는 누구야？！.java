import java.util.*;
import java.util.stream.Stream;
import java.io.*;


public class Main{


    public static int [] num = {3,2,1,2,3,3,3,3,1,1,3,1,3,3,1,2,2,2,1,2,1,1,2,2,2,1};

    public static void main(String [] args) throws IOException {


        // 알파벳 횟수정보 입력
        Map<String,Integer> map = new HashMap<>();

        char c = 'A'; 
        for(int i =0; i <26; i++){

            map.put(String.valueOf(c),num[i]);
            c++;
        }

        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] strArr = br.readLine().split("");

        Queue <Integer> q = new LinkedList<>();
        

        // 큐에 대입 
        for( String ele : strArr){
            q.offer(map.get(ele));
        }

        // 연산 
        Integer result = 0;
        List<Integer> numList = new ArrayList<>();
        while(true){

            while(!q.isEmpty()){

                int first , second =0;
                
                first = q.poll();                
                if(!q.isEmpty()) second = q.poll();
                
                int sum =  first + second;
                if(sum>=10) sum = sum%10;
                
                numList.add(sum);
            }

            if(numList.size()==1){
                result =  numList.get(0);
                break;
            }else{
                for(Integer ele : numList)
                    q.offer(ele);

                numList.clear();
            }
            
        }

        if( result %2==0){
            System.out.println("You're the winner?");
        }else{
            System.out.println("I'm a winner!");
        }
   
    }
}