# javaproject_dart
전자공시시스템 - java 기반 어플리케이션 프로젝트

- 개요
: 전자공시시스템(DART) 상의 데이터를 일반인이 이해하기 쉽게 유용한 지표로 표현하는 프로그램

- 주요 기능
1. 검색 기능 : 회사명 및 기간 입력

2. 결과 : 해당 회사 및 기간에 대한 재무 정보 수치

3. 시각화 : 회사의 재무정보를 육만성(육각형) 모양으로 시각화


=====================================================================

< 진행 현황 >

2020.06.08 
[ 완료 ]
- 데이터 정리
- 서비스 레이아웃 초안 작성 중 

2020.06.09
[ 완료 ]
- 데이터 정리 (완료)
- DB 설계 초안 작성

2020.06.10 
[ 해야 할 일]  
1. 데이터 전처리 & 모델링
2. vo 생성
3. MVC 구현
4. GUI구현 ( 기능 ~ 버튼 )
5. SELECT SQL 
6. 파싱 - JAVA 

2020.06.13
[ To Do ]
- String으로 이루어진 VO를 숫자로 변환하기
- 변환된 숫자들을 바탕으로 계산식에 근거하여 계산하기
- 계산된 결과를 시각화하기


2020.06.15 [ To Do ]
- 2번째 화면에서 '기업상세 Stat' (분류, 항목, 값(value))를 보이게 하기
- 재무요약 클래스 만들기 (각 항목별 회사 총평 및 진단을 문장형태로 표현하기) + 텍스트를 누르면 아래에 수식이 뜨도록 (일종의 하이퍼링크)

- 고려사항: 
1) 부채비율이 애초에 null 값인 경우
--> 표현 방법 1. 해당 자리에 null을 대입 : 해당 회사의 부채비율은 null 이며..
--> 표현 방법 2. 부채비율이 포함된 문장 자체를 출력하지 않는다. 

2) 수요일 시연 때 exe 파일로 만들고, DB의 경우 원격으로 DB에 접속할 수 있도록 해야 하는지?

재무 요약 예시)
자산규모로 볼때 회사규모는 크지 않지만, 부채비율이 낮아 재무구조가 우량하고, 자본금 50억으로 이익잉여금을 1130억을 쌓을 정도로 유보율이 높은 기업이며, 약 1500억의 자산으로 2년 연속 100억 이상의 순이익을 내 ROA도 무난한 기업이다. 본업으로 인한 성과로 이익을 28%이상 성장시켰고, 그 외 활동으로도 성과를 증대시키고 있다. 전반적으로 우량한 기업이라고 할 수 있다.

관련 블로그 URL
https://analystree.tistory.com/entry/%EC%9E%AC%EB%AC%B4%EC%A0%9C%ED%91%9C-%EC%9A%94%EC%95%BD-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%A8


2020.06.16 [ To Do ]

- 
