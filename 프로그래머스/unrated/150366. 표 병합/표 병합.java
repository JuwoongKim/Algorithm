import java.util.*;

class Solution {
    
    public static String [][] mapArr2;

    public static final int M_SIZE = 51;
    
    public String[] solution(String[] commands) {
        
        // 정답을 위한 자료구조 
        String[] answer = {};
        List<String> answerList = new ArrayList<>();
        
        //map 배열 초기화
        mapArr2 = new String[M_SIZE][M_SIZE];
        for(int i =0; i<M_SIZE; i++)
            for(int j=0; j<M_SIZE; j++)
                mapArr2[i][j] ="EMPTY";
        
        
        // 명령어 연산 순회 
        int cSize = commands.length;
        for(int i =0; i<cSize; i++){
        
            String [] inputArr = commands[i].split(" ");
            
            switch(inputArr[0]){
                    
                    
                case "UPDATE" : 
                    
                    if(inputArr.length==4){
                        int r = Integer.parseInt(inputArr[1]);
                        int c = Integer.parseInt(inputArr[2]);;
                        String value =  inputArr[3];
                        update1(r,c,value);
                    }                         
                    else{
                        String value1 = inputArr[1];
                        String value2 = inputArr[2];
                        update2(value1, value2);            
                    } 
                    break;
                    
                case "PRINT" : 
                    int r10 = Integer.parseInt(inputArr[1]);
                    int c10 = Integer.parseInt(inputArr[2]);
                    print(r10, c10 , answerList);
                    
                    break;
                    
                case "MERGE" : 
                    int r1 = Integer.parseInt(inputArr[1]);
                    int c1 = Integer.parseInt(inputArr[2]);
                    int r2 = Integer.parseInt(inputArr[3]);
                    int c2 = Integer.parseInt(inputArr[4]);
                    merge(r1,c1,r2,c2);
                    
                    break;
                    
                case "UNMERGE" : 
                    int r100 = Integer.parseInt(inputArr[1]);
                    int c100 = Integer.parseInt(inputArr[2]);
                    unmerge(r100,c100);
                    break; 
            }
            
        }
        
        // 테스트용 출력
        // for(String[] ele : mapArr2)
        //     System.out.println(Arrays.toString(ele));
        
        // 반환값 변환 
        answer = answerList.toArray( String [] :: new);
        
        //System.out.println(Arrays.toString(answer));
        
        // 리턴 
        return answer;
    }
    
    
    public static void update1(int r, int c, String value){
        
        int [] point = getRoot(r,c);
        mapArr2[point[0]][point[1]] = value;
    }
    
    public static void update2 (String value1, String value2){
        
        for(int i =1 ; i<M_SIZE; i++){
            for(int j=1; j<M_SIZE; j++){
                if(mapArr2[i][j].equals(value1))
                    mapArr2[i][j] = value2;
            }
        }
    }
    
    public static void print(int r, int c, List<String> answerList){
            
        int [] point = getRoot(r,c);
        answerList.add(mapArr2[point[0]][point[1]]);
    }
    
    public static void merge(int r1, int c1, int r2, int c2){
    
        if(r1==r2 && c1 ==c2) return; 
                
        int [] point1 = getRoot(r1,c1);
        int [] point2 = getRoot(r2,c2);
        String value1 = mapArr2[point1[0]][point1[1]];
        String value2 = mapArr2[point2[0]][point2[1]];
        
        if(point1[0]== point2[0] && point1[1]== point2[1]) return;
        
        if(!value1.equals("EMPTY")&& value2.equals("EMPTY")){
            mapArr2[point2[0]][point2[1]] = Integer.toString(point1[0]) + " , "+ Integer.toString(point1[1]);
            update2(Integer.toString(point2[0]) + " , "+ Integer.toString(point2[1]), mapArr2[point2[0]][point2[1]] );
            return; 
        }
        else if(value1.equals("EMPTY")&& !value2.equals("EMPTY")){
            mapArr2[point1[0]][point1[1]] = Integer.toString(point2[0]) + " , "+ Integer.toString(point2[1]);
            update2(Integer.toString(point1[0]) + " , "+ Integer.toString(point1[1]), mapArr2[point1[0]][point1[1]] );
            return;
        }
        //(!value1.equals("EMPTY")&& !value2.equals("EMPTY")) 
        else {
            mapArr2[point2[0]][point2[1]] = Integer.toString(point1[0]) + " , "+ Integer.toString(point1[1]);
            update2(Integer.toString(point2[0]) + " , "+ Integer.toString(point2[1]), mapArr2[point2[0]][point2[1]] );
            return;
        }
        
    }
    
    public static void unmerge(int r , int c){
        
        int fixR = r;
        int fixC = c;
        int [] point = getRoot(r,c);
        String value = mapArr2[point[0]][point[1]];
        
        mapArr2[point[0]][point[1]] = "EMPTY";
        update2(Integer.toString(point[0]) + " , "+ Integer.toString(point[1]),  mapArr2[point[0]][point[1]] );
        
        mapArr2[fixR][fixC] = value;
    
    }
    
    public static int [] getRoot(int r, int c ){
        
        int [] point = new int [2];
        String value = mapArr2[r][c];        
        
        if(value.contains(",")){
            String [] splitStr = value.split(" ");
            point[0] = Integer.parseInt(splitStr[0]);
            point[1] = Integer.parseInt(splitStr[2]);
        }else{
            point[0] = r;
            point[1] = c;
        }
      
        System.out.println(Arrays.toString(point));
        
        return point;
    }
    
    
    
    
    
  
    
    
    
}

/*

UPDATE 1 1 a
UPDATE 1 2 b
UPDATE 1 3 c
UPDATE 2 3 d
UPDATE d a 
PRINT 1 1 
PRINT 1 2 
PRINT 1 3 
PRINT 1 4 
MERGE 1 2 1 1 
MERGE 2 3 1 1 

*/


