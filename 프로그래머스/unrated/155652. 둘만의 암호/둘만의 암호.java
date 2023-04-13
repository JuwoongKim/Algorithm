import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // skip을 set형태의 filer로 만들기 
        Set<String> filter = new HashSet<>(Arrays.asList(skip.split("")));

        // 알파벳 인덱스 만들기 
        List<String> abc = new ArrayList<>();
        char ch = 'a';
        for(int i =0; i<26; i++)
            abc.add(String.valueOf(ch++));  

        StringBuilder sb = new StringBuilder();
        for(String ele : s.split("")){
            
            String temp = getMoveEle(ele, index, abc, filter);
            sb.append(temp);
        }        
        
        answer= sb.toString();
        return answer;
    }
    
    public static String getMoveEle(String ele, int index, List<String> abc, Set<String> filter){
        
        //시작 인덱스를 구한다.
        int sIdx = abc.indexOf(ele);
        
        for(int i =0; i<index; i++){ 
            sIdx = (sIdx+1)%26;
            while(filter.contains(abc.get(sIdx))){
                sIdx = (sIdx+1)%26;
            }
        }
        
        return abc.get(sIdx);        
    };
    
}