![](/photo/icon.jpg)

# HanBang 한방 [아파트 매매 정보와 SNS를 한방에!]
> 주제 : 아파트 매매 정보를 함께 제공하는 SNS 커뮤니티 사이트 <br>
> 개발 기간 : 2021.11.18 ~ 2021.11.25

## 목차
0. 팀소개
1. 서비스 소개
2. 기술 스택
3. 아키텍처 및 ERD



## 0. 팀소개
> 팀명 : 띠모
<center><img src="/photo/profile.jpg" width="75%" height="75%"></center>

## 1. 서비스 소개 및 주요 기능
집은 살면서 오래 머무는 공간 중 하나입니다. <br>
집을 이쁘게 꾸미고 사진을 찍고 다른 사람들과 소통할뿐만 <br>
아니라 사진을 찍은 집의 정보도 알려주어 사용자들끼리 <br>
"집"이라는 주제로 소통하고 정보를 얻는 커뮤니티 사이트를 만들고 싶었습니다. 

### 1.1 메인 
- 좋아요 수를 기반으로 게시글 중 좋아요가 가장 많은 3개의 게시글을 메인화면에 보여줍니다.
- 게시글 중 좋아요가 가장 많은 3개의 게시글을 제외하고 좋아요가 많은 게시글 중 랜덤으로 보여줍니다.
- 추후에 알고리즘을 추가하여 사용자가 좋아할 것 같은 게시글을 보여줄 예정입니다.
<center><img src="/photo/main.JPG" width="50%" height="50%"></center>

### 1.2 글쓰기
- 사용자가 글을 쓰는 공간입니다.
- 사진과 제목, 내용, 다양한 카테고리 등을 포함하여 작성할 수 있습니다.
- 아파트 검색을 통해 사진을 촬영한 아파트의 정보를 연결할 수 있습니다.
<center><img src="/photo/write.JPG" width="50%" height="50%"></center>

### 1.3 사진 게시판
- 전체 사용자들이 올린 사진을 볼 수 있는 공간입니다.
- 카드를 클릭하면 해당 사진을 구체적으로 볼 수 있습니다.
<center><img src="/photo/board.JPG" width="50%" height="50%"></center>

### 1.4 사진
- 사용자가 올린 사진을 구체적으로 볼 수 있는 공간입니다.
- 제목, 내용, 카테고리 등을 한 눈에 볼 수 있습니다.
- 오른쪽에서 게시글 좋아요, 작성자 팔로우가 가능합니다.
- 좌측 하단에 아파트 버튼을 클릭하면 사용자가 등록한 아파트 정보를 보여주는 화면으로 이동합니다.
- 하단에서 댓글을 입력할 수 있습니다.
<center><img src="/photo/photodetail.JPG" width="50%" height="50%"></center>

### 1.5 팔로잉
- 팔로우한 사용자가 올린 사진들만 보여주는 공간입니다.
- 각 카드를 누르면 해당 게시글을 구체적으로 볼 수 있습니다.
<center><img src="/photo/following.JPG" width="50%" height="50%"></center>

### 1.6 아파트 정보 검색
- 아파트 정보를 검색하는 공간입니다.
- 시, 구, 동을 선택하고 검색 버튼을 누르면 해당하는 아파트가 지도위에 보여집니다.
- 마커를 클릭하면 해당 아파트의 구체적인 정보를 확인할 수 있습니다.
<center><img src="/photo/apartinfo.JPG" width="50%" height="50%"></center>

### 1.7 아파트 정보
- 아파트의 정보를 요약하여 보여줍니다.
- 입력된 데이터에 따라 동적으로 생성됩니다.
- 우측 상단에 별 이모티콘을 누르면 관심 지역으로 등록할 수 있습니다. 
- 사용자는 관심있는 아파트를 관심 지역으로 등록하여 별도로 관리할 수 있습니다.
<center><img src="/photo/apartdetail.JPG" width="50%" height="50%"></center>

### 1.8 마이페이지
- 사용자가 한 활동들을 관리하거나 설정할 수 있는 공간입니다.
- 내가 올린 사진, 내가 좋아요한 사진, 나의 관심지역을 테이블로 한 눈에 볼 수 있습니다.
- 설정을 누르면 닉네임, 비밀번호 수정이 가능하며 회원 탈퇴가 가능합니다.
<center><img src="/photo/mypage.JPG" width="50%" height="50%"></center>

## 2. 기술 스택
### 2.1 백엔드
- <img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white"/>
- <img alt="Spring" src="https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white"/>
- <img alt="MySQL" src="https://img.shields.io/badge/mysql-%2300f.svg?&style=for-the-badge&logo=mysql&logoColor=white"/>
### 2.2 프론트엔드
- <img alt="Vue.js" src="https://img.shields.io/badge/vuejs%20-%2335495e.svg?&style=for-the-badge&logo=vue.js&logoColor=%234FC08D"/>

- <img alt="Bootstrap" src="https://img.shields.io/badge/bootstrap%20-%23563D7C.svg?&style=for-the-badge&logo=bootstrap&logoColor=white"/>

- <img alt="HTML5" src="https://img.shields.io/badge/html5%20-%23E34F26.svg?&style=for-the-badge&logo=html5&logoColor=white"/> <img alt="CSS3" src="https://img.shields.io/badge/css3%20-%231572B6.svg?&style=for-the-badge&logo=css3&logoColor=white"/> <img alt="JavaScript" src="https://img.shields.io/badge/javascript%20-%23323330.svg?&style=for-the-badge&logo=javascript&logoColor=%23F7DF1E"/>

### 2.3 협업툴
- <img alt="GitLab" src="https://img.shields.io/badge/gitlab%20-%23181717.svg?&style=for-the-badge&logo=gitlab&logoColor=white"/>
- <img alt="Notion" src="https://img.shields.io/badge/Notion%20-%23181717.svg?&style=for-the-badge&logo=Notion&logoColor=white"/>


## 3. 아키텍처 및 ERD
- 아키텍처
<center><img src="/photo/architecture.JPG" width="75%" height="75%"></center>

- ERD
<center><img src="/photo/erd.JPG" width="75%" height="75%"></center>
