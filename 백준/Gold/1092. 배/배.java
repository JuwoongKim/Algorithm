import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main( String [] args) throws IOException{

        // 변수 선언
        int numOfKrain;
        List<Integer> krains;
        
        int numOfBox;
        List<Integer> boxs;

        // 입력값을 받아 변수값 할당 
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        
        numOfKrain = Integer.parseInt(br.readLine());
  
        krains= Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
      
        

        numOfBox = Integer.parseInt(br.readLine());

        boxs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()); 
        
        Collections.sort(krains, Collections.reverseOrder()); Collections.sort(boxs,  Collections.reverseOrder());


        // 작업 불가로 인한 종료조건 
        if(krains.get(0)<boxs.get(0)){
            System.out.println("-1");
            return;
        }

        int count =0;
        
        while(!boxs.isEmpty()){

            count ++;

            for(Integer krain : krains){

                if(boxs.size()==0)
                    break;
             
                for(int i = 0 ; i<boxs.size() ; i++ ){

                    if(krain>=boxs.get(i)){
                        boxs.remove(i);
                        break;
                    }
                }
            }        
        }
        System.out.println(count);
    }
}
