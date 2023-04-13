import java.util.*;

class Time {
    
    String time;
    String type;
    
    public Time (String time, String type){ 
        this.time = time;
        this.type = type;
    }
    
}


class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Time> timeList = new ArrayList<>();
        
        for(String [] row : book_time){            
            timeList.add(new Time(row[0],"S"));
            timeList.add(new Time(getAddTime(row[1]),"E"));
        }
        
        // 시간을 기준으로 정렬 
        Collections.sort(timeList, (o1,o2) -> {
            
            int bit = o1.time.compareTo(o2.time);
            
            if( bit ==0 && !o1.type.equals(o2.type) ){             
                if(o1.type.equals("S")) return 1;
                else return -1;
                
            }else {
                return bit;
            }    
                                               
                                               
                                               });
        
        answer = Integer.MIN_VALUE;
        int cnt =0;
        for(Time time : timeList){
            
            if(time.type.equals("S")) cnt ++;
            else cnt --; 
            answer = Math.max(answer, cnt);   
            
        }
        
        
        return answer;
    }
    
    
    public static String getAddTime(String time){
        
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int sumM = m+10;
        if(sumM>60){
            sumM -= 60;
            h++;
        }
        
        return String.format("%02d:%02d", h, sumM);
        
    }
    
    
}