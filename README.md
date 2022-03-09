`Heritage_Backend`

# This is Backend API server Repository

## 구현 기능 (v1.0.1-beta)

* __CREATE__ : 필수 내용을 기입 후 글 쓰기 버튼을 통해 새 글 작성

* __GET__ : 전체 글 조회, 선택 글 조회, 좋아요 수 상위 3개 글 조회

* __UPDATE__ : 선택한 글의 수정 버튼을 클릭하여 내용 수정, 좋아요 버튼을 누를 때 해당 게시글의 좋아요 수 증가

* __DELETE__ : 선택한 글의 삭제 버튼을 클릭하여 게시글 삭제 

## Entity 다이어그램
<img src="https://user-images.githubusercontent.com/79829085/157431295-129056d5-d0a4-4716-867a-d237158810a3.png" alt="">

## Class 다이어그램
<img src="https://user-images.githubusercontent.com/79829085/157432006-fd175057-11d9-400c-8a16-1538ee8c4b4f.png" alt="">

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



