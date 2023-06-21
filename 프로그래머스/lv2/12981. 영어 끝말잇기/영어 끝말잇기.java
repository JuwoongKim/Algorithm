import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        int num=0;
        int order=0;

        Set<String> set = new HashSet<>();
        for(int i =0; i<words.length; i ++){
            if(i==0){
                set.add(words[i]);
                continue;
            }
            
            if(set.contains(words[i]) || (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) ){
                num = i%n + 1; 
                order = i/n +1;
                break;
            }
            set.add(words[i]);
        }
        
        answer = new int [] {num, order};

        return answer;
    }
}