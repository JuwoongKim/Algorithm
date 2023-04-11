import java.util.*;
import java.util.stream.*;


class Task{
    
    String name;
    String sTime;
    String pTime;
    
    public Task(String name, String sTime, String pTime ){
        this.name= name;
        this.sTime= sTime;
        this.pTime= pTime;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        
        //리스트 생성 
        List<Task> taskList = getTaskList(plans);
        
        //시작시간 기준 정렬 
        Collections.sort(taskList, (o1,o2)-> o1.sTime.compareTo(o2.sTime));

        //동작 
        Stack<Task> st = new Stack<>();
        String cTime ="";
        
        for(Task task : taskList){
            
            //앞의 과제가 있다면        
            while(st.size()!=0){
                String dTime = addTime(cTime, st.peek().pTime);    

                if(dTime.compareTo(task.sTime)<=0){
                    // 과제를 미리 수행할 수 있다면 
                    cTime = new String(dTime);
                    answerList.add(st.pop().name);
                    continue;
                }

                // 과제를 미리할 수 없다면 
                String mTime = subtractTime(task.sTime, cTime);
                st.peek().pTime = subtractTime(st.peek().pTime, mTime);
                break;
            }
            
            
            cTime = new String(task.sTime);
            st.add(task);
        }
        
        //새로 시작할 과제가 없을때 남은 작업 마무리 
        while(st.size()!=0){
            answerList.add(st.pop().name);
        }
        
        answer = answerList.toArray( new String [answerList.size()] );
        return answer;
    }
    
    public static List<Task> getTaskList(String[][] plans){
        
        List<Task> taskList = new ArrayList<>();
        
        for(String [] plan : plans)
            taskList.add(new Task(plan[0],plan[1],plan[2]));
        
        return taskList;
    };
        
    
    public static String addTime(String time1, String time2){
        
        StringTokenizer st = new StringTokenizer(time1, ":");
        
        int H1 = Integer.parseInt(st.nextToken());
        int M1 = Integer.parseInt(st.nextToken());
        int M2 = Integer.parseInt(time2);
        
        int Msum = M1+ M2;
        
        while(Msum>60){
            Msum -= 60;
            H1 ++;
        }
        
        //System.out.println(String.format("%02d:%02d",H1,Msum));
        return  String.format("%02d:%02d",H1,Msum);
    }

    public static String subtractTime(String time1, String time2){
        
        //입력값을 모두 분단위로 바꾼다.
        String M1 = (time1.contains(":")) ? transToMin(time1) : time1;
        String M2 = (time2.contains(":")) ? transToMin(time2) : time2;
        
        // 분단위 계산한다
        int mSum = Integer.parseInt(M1) - Integer.parseInt(M2);    
        return Integer.toString(mSum);
    
    }
    
    public static String transToMin(String time){
        
        StringTokenizer st = new StringTokenizer(time, ":");
        int H1 = Integer.parseInt(st.nextToken());
        int M1 = Integer.parseInt(st.nextToken());
        
        int mSum = H1*60 + M1;
        return Integer.toString(mSum);
    }
    
    
}