# [D4] 화면 캡쳐 - 16003 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AYYAGjgqPgcDFARc) 

### 성능 요약

메모리: 23,352 KB, 시간: 158 ms, 코드길이: 1,307 Bytes



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do


### 개인 정리 

처음에는 숫자크기만큼 데이터를 생성하면서 저장하려고 했다. 대신 저장하면서 정렬이 가능한 우선순위 큐 자료구조를 사용해서 값을 받고 출력하도록했다.
그러나 시간초과에러가 발생함 

접근법이 잘못되었음을 생각햇고, 규칙을 정리하고보니 재귀을 통한 DFS로 풀 수 있었다.

