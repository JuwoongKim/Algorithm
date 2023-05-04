import java.util.*;


class Position{
    
    int name;
    String type;
    int number;
    
    public Position(int name, String type, int number){
        this.name = name;
        this.type = type;
        this.number = number;
    }
    
    public void print(){
        System.out.println(name);
        System.out.println(type);
        System.out.println(number);
        System.out.println();
    }
}


class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 포지션으로 나누어 단위를 만듬 
        List<Position> pList = new ArrayList<>();
        int N = targets.length;
        for(int i =0; i<N; i++){
            pList.add(new Position(i, "S", targets[i][0]));
            pList.add(new Position(i, "E", targets[i][1]));
        }
        
        // 정렬시켜줌 
        Collections.sort(pList, (o1, o2) ->{
            if(o1.number == o2.number){
                return o1.type.compareTo(o2.type);
            }else{
                return o1.number-o2.number;
            }       
        });
        
        // 순회하면서 체크 
        boolean [] visit = new boolean [N];
        Stack<Position> st = new Stack<>();
        
        for(Position ele : pList){
            
            if(ele.type.equals("E")){
                if(!visit[ele.name]){
                    answer ++;
                    while(!st.isEmpty()){
                        Position temp = st.pop();
                        visit[temp.name]=true;
                    }
                }
                else continue;
            }else{
                st.push(ele);
            }
        }
        
        
        
        

        
        
        return answer;
    }
}