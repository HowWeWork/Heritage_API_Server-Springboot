> Heritage_Backend_강시혁

# This is Backend API server Repository

## 구현 기능 (v1.0.1-beta)

* __CREATE__ : 필수 내용을 기입 후 글 쓰기 버튼을 통해 새 글 작성

* __GET__ : 전체 글 조회, 선택 글 조회, 좋아요 수 상위 3개 글 조회

* __UPDATE__ : 선택한 글의 수정 버튼을 클릭하여 내용 수정, 좋아요 버튼을 누를 때 해당 게시글의 좋아요 수 증가

* __DELETE__ : 선택한 글의 삭제 버튼을 클릭하여 게시글 삭제 

## Entity & 클래스 다이어그램

> 기능 구현 전, 구체적인 설계가 중요하다고 생각했습니다. <br>
> Entity 와 기능은 적지만, 문서화 연습을 목표로 진행했습니다.

<img src="https://user-images.githubusercontent.com/79829085/157431295-129056d5-d0a4-4716-867a-d237158810a3.png" alt="" style = "width:540px">

<img src="https://user-images.githubusercontent.com/79829085/157432006-fd175057-11d9-400c-8a16-1538ee8c4b4f.png" alt="" style = "width:540px">

## API 문서 작성

`활용 툴 : Postman, Notion`

> 클라이언트 개발자와 진행하는 협업 프로젝트가 처음이었습니다. <br>
> 통신 방법에 대해서 알아본 결과 API 에 대해서 학습하게 되었습니다. <br>
> 이 과정에서 '서버의 역할'과 '통신 정보를 어떻게 전달하면 좋은지'에 대해서 고민했습니다. <br>

<img src="https://user-images.githubusercontent.com/79829085/224729922-2a079174-343f-454b-9712-072bdd023014.png" alt="" style = "width:410px">
<img src="https://user-images.githubusercontent.com/79829085/224729995-238748b7-3586-4f95-9670-0d542ae99439.png" alt="" style = "width:410px">

## 협업을 위한 팀 페이지 구축

`활용 툴 : Github, Notion`

<img width="430px" alt="image" src="https://user-images.githubusercontent.com/79829085/224731329-73369a3e-46fa-40f7-8ea3-31aaa10788df.png">

## 팀원들에게 HTTP API , Spring MVC 동작 원리 설명

> 저는 동료와 함께 성장하는 것을 좋아합니다. <br>
> 서로의 분야(프론트엔드, 백엔드, IOS)에 대한 지식을 서로 공유하면서 역량 향상과 기술적인 소통의 간극을 줄였습니다.

<img width="380px" alt="image" src="https://user-images.githubusercontent.com/79829085/224732959-3fb9182b-e8ec-44fe-8f0d-4b377c5a25fe.jpeg">
<img width="380px" alt="image" src="https://user-images.githubusercontent.com/79829085/224732422-72ce6ae7-ae56-47ab-966c-31b50215ca6b.png">


## 추가 버전 계획
| version | 상세 내용 |
|:---:|:---:|
|v1.2.1-beta | user,admin 기능 추가 , 개인 상태 관리 및 개인 게시글 관리, 서비스 관리|
|v1.3.1-release | 웹, IOS 모든 버그 수정 후 배포|
|v1.3.2 | kakao, facebook, instagram 등 타 플랫폼에 공유할 수 있는 기능 생성|

## 활용 기술 스택

### Backend

 * Jdk 11
 * spring 2.6.4
 * gradle
 * lombok
 * rest
 * junit5
 * Spring data JPA
 * H2database



