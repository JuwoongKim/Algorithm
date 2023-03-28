import java.util.*;

class Info{
    
    boolean isWanho;
    int x ;
    int y ;
    int total;
    int grade;
    
    public Info(boolean isWanho, int x, int y ){        
        this.isWanho = isWanho;
        this.x = x;
        this.y= y;
        this.total = x+y;
    }
    
    public void toStr(){
        System.out.println(x + " , " +y + " , " + total + " , " + grade + " , " + isWanho );
    }
    
}

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        
        int wanHoScore = scores[0][0] + scores[0][1];
        // 입력값을 클래스에 넣음 
        List<Info> infoList = getInfoList(scores); 
        
        // 내림차순, 오름차순 순으로 정렬 
        Collections.sort(infoList, new Comparator<Info>(){
     
            @Override
            public int compare(Info a, Info b){
                if(a.x!=b.x) return b.x-a.x;
                return a.y-b.y;
            }
            
        });
        
        int size = infoList.size();
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i< size; i++){
        
            Info temp = infoList.get(i);

            if(temp.y<max){
                if(temp.isWanho){
                    answer = -1;
                    break;
                }
                continue;
            }
            
            max = Math.max(max, temp.y);
            
            if(temp.x + temp.y >wanHoScore){
                answer ++;
            }
        }
        
        if(answer != -1)
            answer ++;
        
        return answer;
            
    }
    
    public static List<Info> getInfoList(int [][] score){
        
        List<Info> infoList = new ArrayList<>();
        int size = score.length;
        for(int i =0; i<size; i++){
            
            if(i ==0)
                infoList.add(new Info(true, score[i][0], score[i][1] ));
            else
                infoList.add(new Info(false, score[i][0], score[i][1] ));
        }
        
        return infoList;
    }
    
    
    
    
}