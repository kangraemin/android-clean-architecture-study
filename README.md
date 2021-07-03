# About this Repo
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

# 1주차, 클린아키텍처 적용 전 프로젝트 구축 및 프로젝트 의존성 MAP

> 💡 추상화된 컴포넌트는 옅은 테두리, 옅은 글자색으로 표기하였습니다.

![image](https://user-images.githubusercontent.com/22047559/123503908-f0e36080-d690-11eb-9f76-023173675aaf.png)

- MVVM을 사용한 구조로, Model에서 데이터에 관련된 대부분의 작업들을 해주고 있습니다.

# 2주차, Actor / UseCase / 클린아키텍처를 적용 할 의존성 Map

## 💡 Actor / UseCase Map

![image](https://user-images.githubusercontent.com/22047559/123506470-53dbf400-d69f-11eb-947d-d614704ffc10.png)

- 현재 프로젝트의 Actor로써, 데이터 제공자 ( 동물 이미지 데이터 / 명언 데이터 )와 실제 데이터를 보는 유저를 구분 하였습니다.

## 💡 Layer Map

![image](https://user-images.githubusercontent.com/22047559/123503962-3b64dd00-d691-11eb-8470-73098163ee0f.png)

- 클린 아키텍처를 적용하기 위해, 크게 레이어를 세가지로 나누어 보았습니다.
- Presentation Layer
   - 실제 뷰를 보여주기 위한 컴포넌트들을 모아놓은 레이어 입니다.
   - 뷰에서 발생한 이벤트를 Domain Layer에 전달하고, Domain Layer로부터 데이터를 받아 뷰를 보여주는 역할을 진행합니다.
- Domain Layer
   - 유즈케이스를 정의 해 놓은 컴포넌트들을 모아놓은 레이어 입니다.
   - Data Layer에 있는 Gateway를 통해 Data Layer와 소통하고, Input / Output Interactor를 통해 Presentation Layer와 소통합니다.
   - Presentation Layer로 부터 발생한 이벤트를 Data Layer에 전달하고, Data Layer로부터 데이터를 받아 Presentation Layer로 전달하는 역할을 진행합니다.
- Data Layer
   - 엔터티, 실제 비즈니스 로직들을 처리하는 컴포넌트를 모아놓은 레이어 입니다.
   - 실제 데이터를 가져오거나, 저장하는 역할을 진행합니다.
   - Gateway를 통해 Presentation Layer와 소통합니다.

## 💡 Dependency Map

### Presentation Layer

#### 책을 기준으로 구성 해 본 Presentaion Layer

![image](https://user-images.githubusercontent.com/22047559/123503977-52a3ca80-d691-11eb-8ec5-e066d2756b71.png)

- View
   - 실제로 유저가 뷰를 보여주는 부분입니다.
   - 뷰에서 일어난 이벤트를 Request 형태로 Controller에 전달하는 역할을 진행합니다.
   - 뷰모델을 관찰하고 있다가, 뷰모델의 데이터가 변경되면 뷰를 변경해주는 역할을 진행합니다.
- Request ( Data Model )
   - 뷰에서 일어난 이벤트를 Controller로 전달 해 줄때필요한 데이터 형태를 서술해놓은 단순한 데이터 클래스 입니다.
   - View에서 이 데이터 클래스를 참조하고 있습니다.
- Controller
   - 뷰에서 일어난 이벤트를 Domain Layer로 전달해주는 역할을 진행합니다.
   - 필요시 Request 형태로 받은 이벤트를, Domain Layer에 알맞는 형태인 RequestModel의 형태로 변환해주는 역할도 진행합니다.
   - 간단한 if / else 문 정도는 있어도 되나, 중요한 로직은 entity, data layer쪽에 있어야 하기 때문에 여기서 처리하면 안됩니다.
- Presenter
   - Domain Layer에서 전달받은 데이터를 화면에 표현할 수 있는 포맷인 ViewModel의 값으로 셋팅해주는 역할을 진행합니다.
   - 필요시 Domain Layer에서 전달받은 ResponseModel 형태의 데이터를 ViewModel 형태로 변환하는 작업도 진행합니다.
   - UseCase Output Port를 구체화합니다.
- ViewModel
   - Presenter로 부터 전달받은 데이터를 담고있는 데이터를 모아놓은 클래스입니다.

#### 실제로 구현 한 Presentation Layer 

![image](https://user-images.githubusercontent.com/22047559/124347709-f0167580-dc20-11eb-8190-5e8f1b79de33.png)

- View
   - 위와 동일합니다. 
- ViewModel
   - 편의성을 위해 Request, ViewModel, Controller, Presenter, ViewModel 개념을 하나로 합쳐서 구현합니다.  
   - AAC ViewModel을 사용하였습니다. 

### 💡 Domain Layer

#### 책을 기준으로 구성 해 본 Domain Layer

![image](https://user-images.githubusercontent.com/22047559/124348372-88fac000-dc24-11eb-865d-40ceb8875b8f.png)

- Request Model
   - Presentation Layer에서 데이터 / 이벤트가 넘어 올 때, 필요한 데이터 형식을 적어놓은 데이터 클래스 입니다.
- UseCase Input Port
   - Presentation Layer에서 데이터 / 이벤트를 Domain Layer로 넘길 때, 필요한 변수, 함수들을 적어놓은 추상화된 컴포넌트입니다.
   - UseCase Interactor Impl에서 이를 구체화합니다.
- UseCase Interactor Impl ( UseCase Input Port Impl )
   - Controller로 부터 데이터를 받고, 받은 데이터를 통해 Data Layer와 소통하여 결과값을 받고, 받은 결과값을 UseCase Output Port로 넘기는 역할을 합니다.
   - UseCase Input Port를 구체화 합니다.
- UseCase Output Port
   - UseCase Interactor Impl로 부터 데이터를 받았을 때 Presentation Layer에서 필요한 변수, 함수들을 적어놓은 추상화된 컴포넌트 입니다.
   - Presentation Layer의 Presenter가 이를 컴포넌트를 구체화 합니다.
- Response Model
   - Domain Layer에서 Presentation Layer로 데이터 / 이벤트가 넘길때, 필요한 데이터 형식을 적어놓은 데이터 클래스 입니다.

#### 실제로 구현 한 Domain Layer 

![image](https://user-images.githubusercontent.com/22047559/124347727-ff95be80-dc20-11eb-9a76-86141deca5f1.png)

- Request / Response Model
   - 위와 동일합니다.
- UseCase Interactor
   - UseCase Input Port / UseCase Output Port 개념을 합쳐서 구현하나, 실제 데이터를 전달하는 것이 아닌, Sinlge observable source를 전달합니다. 
- UseCase Interactor Impl
   - 역할은 위와 동일하나, DataLayer로부터 실제 데이터를 전달하는 것이 아닌, Sinlge observable source를 전달합니다. 

### 💡 Data Layer

#### 책을 기준으로 구성 해 본 Domain Layer / 실제로 구현 한 Data Layer 

![image](https://user-images.githubusercontent.com/22047559/124348387-a760bb80-dc24-11eb-86be-91c8febbb6c6.png)

- Local / Remote DataSource
   - Local / Remote에서 데이터를 가져오기 위한 변수, 함수를 적어놓은 추상화된 컴포넌트입니다. 
   - 이를 구체화한 클래스를 Database ( repository )에서 사용합니다.   
- DataGateways
   - Domain Layer와 소통하기 위한 변수, 함수를 적어놓은 추상화된 컴포넌트입니다. 
- Entity
   - 실제 서비스에서 사용되고 있는, 필요한 데이터를 담아놓은 데이터 클래스 입니다.

### 💡 Entire Project Dependency map

#### 책을 기준으로 구성 해 본 Entire Project Dependency map

![image](https://user-images.githubusercontent.com/22047559/124348398-b21b5080-dc24-11eb-99e2-0937606394c6.png)

#### 실제로 구현 한 Entire Project Dependency map

![image](https://user-images.githubusercontent.com/22047559/124347718-f73d8380-dc20-11eb-98ed-5bcc32d43353.png)
