import java.util.*;
import java.util.stream.*;
import java.io.*;


class Book{

    public int price;
    public String name;

    public Book (String price, String name){
        this.price = Integer.parseInt(price);
        this.name = name;
    }

}


public class Main {
    

    public static String [] str;

    public static int answer = Integer.MAX_VALUE;

    public static void main (String [] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

        String str = br.readLine();

        int n = Integer.parseInt(br.readLine());

        int [] priceArr = new int [n];
        String [] nameArr = new String [n];

        for(int i =0; i<n ; i++){

            String [] input = br.readLine().split(" ");

            priceArr[i] = Integer.parseInt(input[0]);
            nameArr[i] = input[1];

        }


        // 비트마스킹 집합 순회 
    
        List<Integer> idxList = new ArrayList<>();

        for(int i =0; i < (1<<n) ; i++ ){

            for(int j =0; j<n; j++){
                if((i&1<<j)!=0){
                    idxList.add(j);
                }
            }

            if(idxList.isEmpty()) continue;

            // 결과 연산
            if(isSatisfied(nameArr, idxList, str)){

                int priceSum= idxList.stream().map(idx ->priceArr[idx]).mapToInt(price->price).sum();
                
                answer = Math.min(answer, priceSum);
            }            
            // idxList 초기화 
            idxList.clear();
        }

        if(answer == Integer.MAX_VALUE) answer = -1;
        
        System.out.println(answer);
    }

    public static boolean isSatisfied( String [] nameArr,  List<Integer> idxList, String str ){

        boolean isSatisfied = true;

        // 문자열 등록 
        StringBuilder sb = new StringBuilder("");

        for(int idx : idxList){
            sb.append(nameArr[idx]);
        }

        for(String ele : str.split("")){

            if(! sb.toString().contains(ele)){
                isSatisfied = false;
                break;
            }

            int firstIdx = sb.indexOf(ele);
            sb.deleteCharAt(firstIdx);
        }

        return isSatisfied;
    }

}
