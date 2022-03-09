`Heritage_Backend`

This is Backend API server Repository

# 헤리티지(Heritage)

<p>
<img width="330px;" src="https://user-images.githubusercontent.com/79829085/154243769-3abb95c8-370f-46ea-ac12-4b791f9c09f1.png" alt="" align="left" >
<h3> `헤리티지(Heritage)'인 이유</h3>
<p> 부르디외의 문화자본론에 의하면, 사회적 위치는 경제자본 뿐 아니라 문화 자본에 따라 결정되며, 이에 따라 생활양식이 달라진다고 하였다. 문화소비는 사회집단의 표식처럼 기능하므로 상층 계급간의 상호면식, 교류 및 결속이 수월해지면서 이들 집단의 자본의 우위가 더욱 다져지게 된다.<br><br>우리 팀은, (문화자본론에서 말하는 문화 소비의 개념에 의거하여) 다양한 계층의  수평적 문화 소통의 가상 공간을 만들고자 한다. 이로 인해 특정 계급의 위계적 문화(혹은 고급/ 대중 문화)가 아닌 모두가 향유하고 소통하는 모두의 수평적 문화의 장을 만들고자 한다.<br>프로젝트의 이름은 cultural heritage에서 따와 ‘헤리티지’라고 지었다.</p>

***

## 1. 프로젝트 마감 기한

  * `2022. 03. 17 (업프로젝트 최종 공유회)`
<br>

## 2. 서비스 목적

  * 문화 공유 게시판

<br>

## 3. 개발 배경

  현재 알고리즘 추천이 난무하면서 다양한 문화를 경험하기가 어려움.<br>
  따라서 자신에게 인상 깊었던 문화를 한줄 감상평(생각)으로 사람들에게 공유하고 추천할 수 있도록 플랫폼 개발
  
  <br>

## 4. 개발 목표

  * 게시판의 핵심 기능을 구현하여 CRUD 원리 이해

  * 웹 프론트엔드. 백엔드, IOS 통합 서비스 개발 경험 및 협업 과정 이해

  * Github, Figma, google drive, notion 등 협업, 버전 관리 툴 사용

  * 각자의 기술 스택 능력 향상

  * 고객의 니즈에 맞게 UI,UX,기능 등 개발

<br>

## 5. 우리 서비스의 차별점

* 서로가 공유한 문화 감상평에 '좋아요 기능' 생성

* 이 좋아요 기능을 통해서 인기 문화 콘텐츠를 사람들에게 공유

<br>

## 6. 기능 상세

### 1) 현재 버전의 구현 기능 (v1.0.1-beta)

* __CREATE__ : 필수 내용을 기입 후 글 쓰기 버튼을 통해 새 글 작성

* __GET__ : 메인 페이지 입장 및 create, update, delete 등을 수행한 후 DB에 저장된 글들을 출력

* __UPDATE__ : 선택한 글의 수정 버튼을 클릭하여 내용 수정, 좋아요 버튼을 누를 때 해당 게시글의 좋아요 수 증가

* __DELETE__ : 선택한 글의 삭제 버튼을 클릭하여 게시글 삭제 

### 2) 추가 버전 계획
| version | 상세 내용 |
|:---:|:---:|
|v1.2.1-beta | user,admin 기능 추가 , 개인 상태 관리 및 개인 게시글 관리, 서비스 관리|
|v1.3.1-release | 웹, IOS 모든 버그 수정 후 배포|
|v1.3.2 | kakao, facebook, instagram 등 타 플랫폼에 공유할 수 있는 기능 생성|

<br>

## 7. 프로젝트 WBS

<img src="https://user-images.githubusercontent.com/79829085/154426994-13e88df4-bcae-456e-98a9-259e3277a100.png" alt="">
<br>

## 8. Flow chart

<img src="https://user-images.githubusercontent.com/79829085/154250328-9adf8e9b-bf8c-4870-8c0c-0f7cc55f347a.png" alt="">

## 9. 백엔드 추가 자료 (추가 예정)

### 1) 도메인 클래스 다이어 그램 (백엔드)

`프론트는 웹 UI 넣을 것`, `IOS는 앱 UI넣을 것`

### 2) ERD

<br>

## 8. 활용 기술 스택

### Front
 * HTML5
 * CSS3
 * JavaScript

### Backend
 * Jdk 11.0.12
 * spring 2.6.3 
 * graddle
 * rest
 * junit5
 * Spring data JPA
 * H2database
 * MySQL(추후)

### IOS
 * Swift
 * Xcode

### 기타
 * 버전 관리 : git, github
 * UI 설계 : figma
 * 협업 툴 :  notion, google drive, github


