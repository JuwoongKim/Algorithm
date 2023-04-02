import java.util.*;
import java.io.*;
import java.util.stream.*;




class Main{

    public static int answer = Integer.MIN_VALUE;

    public static void main(String [] args )throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        int N = Integer.parseInt(br.readLine());

        String [] input = br.readLine().split("");
        boolean  [] visit = new boolean [N/2]; //  우선순위 괄호 위치    i번쨰  = intput[2*i] + input[2i+2] 를 의미함 

        rec(0, visit,  input);

        System.out.println(answer);

    }

   public static void rec (int level, boolean [] visit, String [] input){

        // 종료조건 
        if(level == visit.length ){

            

            List<Integer> idxList =new ArrayList<>();

            //괄호위치 인덱스 연산  
            for(int i =0; i<visit.length ; i++)
                 if(visit[i]) idxList.add(2*i+1);

            
                 // 괄효를 포함한 연산 
            int result = getResult( idxList, visit, input);

            answer = Math.max(answer, result);

            return;  
        }


        if(level !=0  && !visit[level-1]){
            visit[level] =  true;
            rec(level+1, visit,  input);
        }

        if(level ==0){
            visit[level] =  true;
            rec(level+1, visit,  input);
        }


        visit[level] = false;
        rec(level+1, visit,  input);


   }


   public static int  getResult(  List<Integer> idxList, boolean [] visit, String [] input){


        Deque<String> deq = new ArrayDeque<>();
 
        for(int i =0; i< input.length; i++){

            // 인덱스가 우선순위 괄호를 가리킨다면
            if(idxList.contains(i)){
                
                String operator = input[i];
                String operand1 = deq.pollLast();
                String operand2 = input[++i];
                    
               deq.offer(compute( operand1 , operator ,operand2));                 
            }else{

                deq.offer(input[i]);
            }

        }
        
        while(deq.size()!=1){

            String operand1 = deq.poll();
            String operator = deq.poll();
            String operand2 = deq.poll();
            deq.offerFirst(compute(operand1, operator, operand2));
        }


        return Integer.parseInt(deq.poll());
   }



   public static String compute (String opperand1 , String operator, String opperand2){

        int result = 0;
        int o1 = Integer.parseInt(opperand1);
        int o2 = Integer.parseInt(opperand2);

        switch(operator){

            case "*" :
                result =  o1*o2;
                break;
            
            case "+" :
                result =  o1+o2;
                break;                

            case "-" :
                result =  o1-o2;
                break;
        }


        return Integer.toString(result);
   } 


}


