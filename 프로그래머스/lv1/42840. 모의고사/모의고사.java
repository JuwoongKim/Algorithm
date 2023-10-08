import java.util.*;

class Solution {
    
    int[] one = {1, 2, 3, 4, 5};
    int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    List<Integer> countList = new ArrayList<>(){{
        add(0);
        add(0);
        add(0);
    }};
    
    
    public int[] solution(int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if(one[i%one.length]==answers[i]){
                countList.set(0, countList.get(0)+1);
            }
            if(two[i%two.length]==answers[i]){
                countList.set(1, countList.get(1)+1);
            }
            if(three[i%three.length]==answers[i]){
                countList.set(2, countList.get(2)+1);
            }
        }

        ArrayList<Integer> answerList = new ArrayList<>();
        int max = countList.get(0);

        for(int i =0 ; i<countList.size(); i++){
            if(i==0){
                answerList.add(1);
                continue;
            }
            if(countList.get(i)> max){
                answerList = new ArrayList<>();
                answerList.add(i+1);
                max = countList.get(i);
                continue;
            }
            if(countList.get(i)==max){
                answerList.add(i+1);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i =0; i<answer.length; i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}