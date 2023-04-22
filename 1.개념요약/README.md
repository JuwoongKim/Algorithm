
# 리마인드 


### [Int, 문자열]

- 문자열을 Int 형으로 

    - String.ofValue(Int 변수)

- Int 를 문자열로

    - Integer.toParse("문자열")


### [배열, 리스트]

- 배열을 리스트로 

    -   String[] arr = { "A", "B", "C" }; 
    
        List<String> list = Arrays.asList(arr);


- 리스트를 배열로 

    - toArray()
        - Object[] arr = list.toArray();  //object만 반환가능


    - toArray(T[] a)
        - String arr[] = list.toArray(new String[0]);


</br>


</br>

</br>

### [스트림]


- 스트림생성 

    - 배열을 스트림으로 

        Stream<String> stream = Arrays.stream(배열명);

        or

        Stream<String> stream = Stream.of(배열명); 
        
    - 컬랙션을 스트림으로 

        List<String> list = Arrays.asList("123","456","789");
        
        Stream<String> stream = list.stream();


    - 지정된 값을 스트림으로

        Stream<String> stream = Stream.of("123","456","789");


</br>

</br>


- 중간 연산 


    - 요소 변환 
        - map 
        - mapToDouble
        - mapToInt
        - mapToLong

        - flatMap
        - flatMapToDouble
        - flatMapToInt
        - flatMapToLong
    
    - 중복 제거 
        - distinct

    - 스킵
        - skip  

    - 잘라내기
        - linmit

    - 정렬 
        - sorted

    - 특정요소 
        - peek

    -  기본 타입에 특화된 스트림을 일반 스트림으로 변환
        - boxed

</br>

</br>

- 최종 연산 

    - 배열과 컬랙션으로 변환 
        - toList()
        - toSet()
        - toMap()
        - toCollection()
        - toArray()

    - 요소의 출력  
        - forEach()
    - 요소의 소모 : reduce()
    - 요소의 검색 : findFirst(), findAny()
    - 요소의 검사 : anyMatch(), allMatch(), noneMatch()
    - 요소의 통계 : count(), min(), max()
    - 요소의 연산 : sum(), average()
    - 요소의 수집 : collect()






</br>


</br>

</br>

### [API 보는법]
