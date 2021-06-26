## About this Repo
[clean architecture](http://www.yes24.com/Product/Goods/77283734) 실습을 위한 저장소 입니다. [Notion Blog](https://www.notion.so/Clean-architecture-study-03b625e348d5446998313c8c22af964d)에 학습 내용을 정리 해 놓았습니다. 

## 💡 프로젝트 주제

- 똑똑해 보이는 고양이 사진 생성
- 고양이 사진 api와, 명언 가져오기 api를 통해 네트워크 통신
- 통신 이후에 이전 데이터 삭제 및 사진 / 명언을 로컬에 캐싱
- 유저가 앱을 키면, 고양이 사진과 밑에 명언이 적혀 있음
- SwipeRefreshing을 활용한 뷰 새로고침
- 기기를 흔들면, 고양이 사진과 명언이 적힌 텍스트가 스크린 캡처 / 저장 됨
- 인터넷 연결이 없는 경우 캐싱된 사진과 명언을 노출

## 💡 사용하고자 하는 기술

- MVVM with databinding
- Repository pattern ( Remote / Local )
- Dependency injection ( Koin )
- RxBinding / RxKotlin
- Retrofit using Rx
- Room for localDB

## 💡 1주차, 클린아키텍처 적용 전의 대략적인 프로젝트 의존성 MAP

![DefaultDiagram](https://user-images.githubusercontent.com/22047559/123498603-fda18d80-d66b-11eb-9c6a-cb120fe08c27.png)
