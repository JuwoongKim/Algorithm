import java.util.*;
import java.util.stream.*;
import java.io.*;



public class Main{

    public static Map<Integer, List<Integer>> conMap = new HashMap<>();
    public static int answer =0;

    public static int MAX_LEVEL =3;

    public static void main(String args []) throws IOException{


        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken());

        
        for(int i =1; i<=n; i++)
            conMap.put(i, new ArrayList<>());

        for(int i =0; i<m ; i++){

            int [] inputArr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(inputArr);
            conMap.get(inputArr[0]).add(inputArr[1]);
        }

        compute(1,n-2, new ArrayList<>(), 1);
        System.out.println(answer);
    }


    public static void compute (int start, int end, List<Integer> list, int level ){

        if(level == MAX_LEVEL+1){
            answer++;
            return;
        }

        // 장애막 계산 
        Set<Integer> filterSet = new HashSet<>();

        for(int ele : list){
            for(int subEle : conMap.get(ele))
                filterSet.add(subEle);
        }   


        for(int i = start ; i<=end ; i ++){

            if(filterSet.contains(i)) continue;
            
            list.add(i);
            compute(i+1, end+1, list, level+1);
            list.remove(list.size()-1);

        }

    }

}