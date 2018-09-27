<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.playListBean" %>

<!doctype html>
<html>


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/forms/validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 20 Mar 2017 21:33:56 GMT -->
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Academy</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <!-- Canonical SEO -->
    <link rel="canonical" href="//www.creative-tim.com/product/material-dashboard-pro" />
    <!--  Social tags      -->
    <meta name="keywords" content="material dashboard, bootstrap material admin, bootstrap material dashboard, material design admin, material design, creative tim, html dashboard, html css dashboard, web dashboard, freebie, free bootstrap dashboard, css3 dashboard, bootstrap admin, bootstrap dashboard, frontend, responsive bootstrap dashboard, premiu material design admin">
    <meta name="description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
    <!-- Schema.org markup for Google+ -->
    <meta itemprop="name" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template">
    <meta itemprop="description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
    <meta itemprop="image" content="s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
    <!-- Twitter Card data -->
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@creativetim">
    <meta name="twitter:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template">
    <meta name="twitter:description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
    <meta name="twitter:creator" content="@creativetim">
    <meta name="twitter:image" content="s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
    <!-- Open Graph data -->
    <meta property="fb:app_id" content="655968634437471">
    <meta property="og:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template" />
    <meta property="og:type" content="article" />
    <meta property="og:url" content="http://www.creative-tim.com/product/material-dashboard-pro" />
    <meta property="og:image" content="s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg" />
    <meta property="og:description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design." />
    <meta property="og:site_name" content="Creative Tim" />
    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="assets/css/material-dashboard.css" rel="stylesheet" />
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/google-roboto-300-700.css" rel="stylesheet" />


<script language="JavaScript">
//강의 등록시 select태그 내에서 option 선택시 input 입력 창에 자동 적용 되도록 하는 메소드

function checkcategory(){
    if (ModifyPlayList.category_select.value == '1') {
    	ModifyPlayList.category.readOnly = false;
    	ModifyPlayList.category.value = '${playList_num_Info.category}';
    	ModifyPlayList.category.focus();
    }
    else {
    	ModifyPlayList.category.readOnly = true;
    	ModifyPlayList.category.value = ModifyPlayList.category_select.value;
    }
}
function checklecture_level(){
    if (ModifyPlayList.lecture_level_select.value == '1') {
    	ModifyPlayList.lecture_level.readOnly = false;
    	ModifyPlayList.lecture_level.value = '${playList_num_Info.lecture_level}';
    	ModifyPlayList.lecture_level.focus();
    }
    else {
    	ModifyPlayList.lecture_level.readOnly = true;
    	ModifyPlayList.lecture_level.value = ModifyPlayList.lecture_level_select.value;
    }
}
</script>    
    
</head>

<body>
    <div class="wrapper">
        <div class="sidebar" data-active-color="rose" data-background-color="black" data-image="assets/img/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
        Tip 2: you can also add an image using data-image tag
        Tip 3: you can change the color of the sidebar with data-background-color="white | black"
    -->
            <!-- 로고 클릭시 메인화면으로 이동한다. -->
            <div class="logo">
                <a href="./MainAction.ac" class="simple-text">
                    Academy
                </a>
            </div>
            <div class="logo logo-mini">
                <a href="./MainAction.ac" class="simple-text">
                    Semi
                </a>
            </div>
            <div class="sidebar-wrapper">
                <div class="user">
                <!-- 로그인 상태확인을 위해 if문을 사용, admin, 일반로그인, 비 로그인상태에 따라 서로 다른 메뉴가 나타나게 한다. -->
                <%if(session.getAttribute("id")!=null) {
                	if(session.getAttribute("id").equals("admin")){%>
                	<!-- admin일 경우 -->
                		<div class="photo">
                        	<img src="assets/img/faces/frodo.jpg" />
                    	</div>
                		<div class="info">
                        <a data-toggle="collapse" href="#LoginMenu" class="collapsed">
                            	관리자 <%=session.getAttribute("id") %> 님
                            <b class="caret"></b>
                        </a>
                        <div class="collapse" id="LoginMenu">
                            <ul class="nav">
                                <li>
                                    <a href="AdminInfo.se?id=<%=session.getAttribute("id")%>">회원 목록 보기</a>
                                </li>
                                
                                <li>
                                    <a href="MemberLogout.se">로그아웃</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                	<%}else{ %>
                	<!-- 일반 로그인인 경우 -->
                    <div class="photo">
                        <img src="assets/img/faces/ryan.jpg" />
                    </div>
                    <div class="info">
                        <a data-toggle="collapse" href="#LoginMenu" class="collapsed">
                            	<%=session.getAttribute("id") %> 님
                            <b class="caret"></b>
                        </a>
                        <div class="collapse" id="LoginMenu">
                            <ul class="nav">
                                <li>
                                    <a href="MemberInfo.se?id=<%=session.getAttribute("id")%>">내 프로필 보기</a>
                                </li>
                                <li>
                                    <a href="ChapterCompleteListAction.ac?id=<%=session.getAttribute("id")%>">수강완료 목록보기</a>
                                </li>
                                <li>
                                    <a href="MemberLogout.se">로그아웃</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <%} %>
                 <%}else{ %>
                 <!-- 비 로그인인 경우 -->
                 	<div class="photo">
                        <img src="assets/img/faces/apeach.jpg" />
                    </div>
                    <div class="info">
                        <a data-toggle="collapse" href="#LoginMenu" class="collapsed">
                            	로그인 후 이용 가능 합니다.
                            <b class="caret"></b>
                        </a>
                        <div class="collapse" id="LoginMenu">
                            <ul class="nav">
                                <li>
                                    <a href="MemberJoinForm.se">회원가입</a>
                                </li>
                                <li>
                                    <a href="MemberLoginForm.se">로그인</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                 <%} %>
                 <!-- 로그인상태 end -->
                 
                </div>
                <!-- 메뉴화면 -->
                <ul class="nav">
                    <li >
                    	<!-- 메인으로 이동 -->
                        <a href="./MainAction.ac">
                            <i class="material-icons">dashboard</i>
                            <p>메인화면</p>
                        </a>
                    </li>
                    <li>
                        <a data-toggle="collapse" href="#pagesExamples">
                            <i class="material-icons">image</i>
                            <p>게시판
                                <b class="caret"></b>
                            </p>
                        </a>
                        
                         <!-- 자유게시판으로 이동 -->
                        <div class="collapse" id="pagesExamples">
                            <ul class="nav">
                                <li>
                               
                                    <a href="boardList.bo">자유게시판</a>
                                </li>
                                
                            </ul>
                        </div>
                    </li>
                    <!-- 강의 추가 게시판이므로 메뉴내의 강의 목록 메뉴를 활성화 표시 한다. -->
                    <li class="active">
                        <a data-toggle="collapse" href="#LectureList">
                            <i class="material-icons">apps</i>
                            <p>강의 목록
                                <b class="caret"></b>
                            </p>
                        </a>
                        <div class="collapse in" id="LectureList">
                            <ul class="nav">
                                <li class="active">
                                    <a href="playList.ac">전체강의</a>
                                </li>
                                <!-- request 영역으로 전달 받은 카테고리 리스트를 출력한다. -->
                                <c:forEach var = "catelist" items = "${categoryList }">
								<li>
									<a href="playList.ac?category=${catelist.category }&id=<%=session.getAttribute("id") %>">${catelist.category }</a>
								</li>
								</c:forEach>
								<!-- 강의 등록 메뉴는 admin 로그인일 경우에만 나타나게 한다. -->
								<%if(session.getAttribute("id")!=null){
									if(session.getAttribute("id").equals("admin")){ %>
                                	<li class="active">
                                		<!-- 강의 등록을 위해 AddPlayListForm.ac로 이동한다. -->
                                    	<a href="AddPlayListForm.ac">강의등록</a>
                                	</li>
                               		<%}
									} %>
                            </ul>
                        </div>
                    </li>
                    <!--로그인 상태에 따라 회원정보관리의 세부 메뉴가 다르게 나타나게 한다.  -->
                    <!-- admin 로그인인경우 -->
                    <%if(session.getAttribute("id")!=null) {
                    	
                    	if(session.getAttribute("id").equals("admin")){%>
                    		<li>
                        	<a data-toggle="collapse" href="#MyPage">
                            	<i class="material-icons">content_paste</i>
                            	<p>회원정보관리
                                	<b class="caret"></b>
                            	</p>
                        	</a>
                        	<div class="collapse" id="MyPage">
                            	<ul class="nav">
                                	<li>
                                		<!-- 회원 목록 보기 과정을  위해  AdminInfo.se로 이동한다.-->
                                    	<a href="AdminInfo.se?id=<%=session.getAttribute("id")%>">회원 목록 보기</a>
                                	</li>
                                	<li>
                                    	<a href="#">강의 수정 삭제</a>
                                	</li>
                                </ul>
                        	</div>
                    		</li>
                    
                    	<%}else{ %>
                    	<!-- 일반로그인인 경우 -->
                    	<li>
                        	<a data-toggle="collapse" href="#MyPage">
                            	<i class="material-icons">content_paste</i>
                            	<p>회원정보관리
                                	<b class="caret"></b>
                            	</p>
                        	</a>
                        	<div class="collapse" id="MyPage">
                            	<ul class="nav">
                                	<li>
                                		<!-- id 정보를 MemberInfo.se에 전달 하여 내 프로필 보기위한 과정을 진행한다. -->
                                    	<a href="MemberInfo.se?id=<%=session.getAttribute("id")%>">내 프로필 보기</a>
                                	</li>
                                	<li>
                                		<!-- id 정보를 MemberAlterForm.se에 전달 하여 내 프로필 수정을 위한 과정을 진행한다. -->
                                    	<a href="MemberAlterForm.se?id=<%=session.getAttribute("id")%>">내 프로필 수정</a>
                                	</li>
                                	<li>
                                		<!-- id 정보를 ChapterCompleteListAction.ac에 전달 하여 수강완료 목록 보기 위한 과정을 진행한다.-->
                                    	<a href="ChapterCompleteListAction.ac?id=<%=session.getAttribute("id")%>">수강완료 목록 보기</a>
                                	</li>
                            	</ul>
                        	</div>
                    	</li>
                    	<%} %>
                    <%}else{ %>
                    <!-- 비 로그인인 경우 -->
                    <li>
                    	<!-- 회원가입 폼을 불러 오기 위해 MemberJoinForm.se로 이동한다.-->
                        <a href="MemberJoinForm.se">
                            <i class="material-icons">person</i>
                            <p>회원가입</p>
                        </a>
                    </li>
                    <li>
                    	<!-- 로그인 폼을 불러 오기 위해 MemberLoginForm.se로 이동한다.-->
                        <a href="MemberLoginForm.se">
                            <i class="material-icons">person</i>
                            <p>로그인</p>
                        </a>
                    </li>
                    <%} %>
                </ul>
            </div>
        </div>
        <div class="main-panel" >
            <nav class="navbar navbar-transparent navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-minimize">
                        <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                            <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                            <i class="material-icons visible-on-sidebar-mini">view_list</i>
                        </button>
                    </div>
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="./MainAction.ac"> Academy </a>
                    </div>
                    <div class="collapse navbar-collapse">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                            <!-- 우측 상단 미니 아이콘으로 메인화면 이동 기능을 한다.  -->
                                <a href="./MainAction.ac" class="dropdown-toggle" >
                                    <i class="material-icons">dashboard</i>
                                    <p class="hidden-lg hidden-md">메인화면</p>
                                </a>
                            </li>
                            <%if(session.getAttribute("id")!=null){ 
                            
                            	if(session.getAttribute("id").equals("admin")) {%>
                            	<!-- admin 로그인인 경우 -->
                            		<li>
                                		<a href="AdminInfo.se?id=<%=session.getAttribute("id")%>" class="dropdown-toggle" >
                                    		<i class="material-icons">content_paste</i>
                                    		<p class="hidden-lg hidden-md">회원 목록 보기</p>
                                		</a>
                            		</li>
                            	
                            	<%}else{ %>
                            	<!-- 일반로그인 인경우 -->
                            		<li>
                                		<a href="MemberInfo.se?id=<%=session.getAttribute("id")%>" class="dropdown-toggle" >
                                    		<i class="material-icons">person</i>
                                    		<p class="hidden-lg hidden-md">내 프로필 보기</p>
                                		</a>
                            		</li>
                            		<%} %>
                              <%} else{%>
                              <!-- 비 로그인인 경우 -->
                              		<li>
                                		<a href="MemberLoginForm.se" class="dropdown-toggle" >
                                    		<i class="material-icons">person</i>
                                    		<p class="hidden-lg hidden-md">로그인</p>
                                		</a>
                            		</li>
                            		
                              
                              <%} %>
                            <li class="separator hidden-lg hidden-md"></li>
                        </ul>
                         <!-- 검색기능을 위한  form input으로 검색어를 입력 받아 SearchAction.se으로 전달한다-->
                        <form class="navbar-form navbar-right" role="search" action="SearchAction.se?id=<%=session.getAttribute("id")%>">
                            <div class="form-group form-search is-empty">
                                <input type="text" class="form-control" placeholder="Search" name="keyword">
                                <span class="material-input"></span>
                            </div>
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
            
            <!-- 강의 등록을 위한 form -->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                       			<!-- 입력 받은 정보를 AddPlayList.ac로 넘겨준다-->
                                <form name="ModifyPlayList" action="ModifyPlayList.ac" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="playlist_num" value="${playList_num_Info.playlist_num}">
                                    <div class="card-header card-header-icon" data-background-color="rose">
                                        <i class="material-icons">contacts</i>
                                    </div>
                                    
                                    <div class="card-content">
                                        <h4 class="card-title">강의 수정</h4>
                                       <div class="progress progress-line-info">
                                                <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                            <br>
                                        <br>
                                        <br>
                                        <br>
                                        <p class="text-warning">카테고리</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                        <div class="form-group label-floating">
                                        <!-- 카테고리 선택. 나타나는 옵션 목록은 현재 등록되어 있는 카테고리에 따라 자동으로 추가되어 나타나도록 한다.  -->
                                        <!-- 직접입력으로 새로운 카테고리 등록시 다음번 강의 등록 시에 카테고리 목록에 추가되어 나타난다. -->
                                        <!-- checkcategory()메소드로 옵션에 나타난 목록을 선택 하면 자동으로 입력창에 적용된다. -->
                                        <!-- 직접입력을 통해 새로운 카테고리를 등록 가능하다. -->
                                            <select name="category_select" class="form-control" id="category_select" onChange="checkcategory();">
   											<option value="" selected>카테고리선택</option>
   											<c:forEach var = "catelist" items = "${categoryList }">
  			 								<option value="${catelist.category }">${catelist.category }</option>
  			 								</c:forEach>
  											<option value="1">현재 카테고리</option>
											</select>
											<input name="category" type="text" class="form-control active" id="category" size="20">
                                        </div>
                  							<br>
                                        <br>
                                        <br>
                                        <br>
                                        <p class="text-warning">강의등급</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                            <!-- 강의 등급입력 또한 카테고리와  같은 기능을 한다. -->
                                        <div class="form-group label-floating">
                                            <select name="lecture_level_select" size="1" class="form-control" id="lecture_level_select" onChange="checklecture_level();" required="required"  >
											<option value="" selected>강의등급선택...</option>
											<c:forEach var="list" items="${LectureList}">
											<option value='${list.lecture_level }'>${list.lecture_level }</option>
											</c:forEach>
											
											<option value="1">현재 강의 등급</option>
											</select>
											<input name="lecture_level" type="text" class="form-control" id="lecture_level" size="20" placeholder="영문입력...">
										</div>
										<br>
                                        <br>
                                        <br>
                                        <br>
                                        <p class="text-warning">강의등급 이미지(새로 등록 해주세요)</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                            <!-- 이미지를 추가 할 수 있다. 현재 업로드 하고자 하는 이미지를 선택 할 시 어떠한 이미지가 업로드 되는지 미리보기 할 수 있다. -->
                                            <!-- 미리보기후 다른 이미지로 변경 가능하다. -->
                                        <div class="form-group label-floating">
                                            <div class="fileinput fileinput-new text-center" data-provides="fileinput">
                                                <!-- 업로드 하고자 하는 이미지 미리보기 -->
                                                <div class="fileinput-new thumbnail">
                                                    <img src="/boot/imageUpload/${playList_num_Info.lecture_image}" alt="...">
                                                </div>
                                                <div class="fileinput-preview fileinput-exists thumbnail"></div>
                                                <div>
                                                    <span class="btn btn-rose btn-round btn-file">
                                                        <span class="fileinput-new">강의 등급 이미지</span>
                                                        <span class="fileinput-exists">바꾸기</span>
                                                        <input type="file" name="lecture_image" class="form-control"/>
                                                    </span>
                                                    <a href="#pablo" class="btn btn-danger btn-round fileinput-exists" data-dismiss="fileinput"><i class="fa fa-times"></i>지우기</a>
                                                </div>
                                            </div>
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        
                                        <!-- 챕터 제목 입력 -->
                                        <p class="text-warning">챕터 제목</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                        <div class="form-group label-floating">
                                            <label class="control-label">챕터 제목
                                                <star>*</star>
                                            </label>
                                           <input type="text" name="chapter_subject" id="chapter_subject" class="form-control" value="${playList_num_Info.chapter_subject}">
				
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <!-- 강의 영상 입력 소스코드 형태로 입력 받는다 -->
                                        <p class="text-warning">강의영상 등록</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                        <div class="form-group label-floating">
                                        
                                            <label class="control-label">강의영상 등록(소스코드)...
                                                <star>*</star>
                                            </label>
                                            <textarea cols="50" rows="5" name="chapter_url" id="chapter_url" class="form-control" >${playList_num_Info.chapter_url}</textarea>
				
                                        </div>
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <!-- 챕터목표 입력 -->
                                        <p class="text-warning">챕터목표</p>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                        <div class="form-group label-floating">
                                            <label class="control-label">챕터 목표
                                                <star>*</star>
                                            </label>
                                           <textarea cols="50" rows="5" name="chapter_objectives" class="form-control" >${playList_num_Info.chapter_objectives}</textarea>
										</div>
										<br>
                                        <br>
                                        <br>
                                        <br>
                                        <div class="progress progress-line-warning">
                                                <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
                                        <div class="category form-category">
                                            <star>*</star> Required fields</div>
                                        <div class="text-center">
                                            <button type="submit" class="btn btn-rose btn-fill btn-wd">강의 등록</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="./MainAction.ac">
                                    	메인화면
                                </a>
                            </li>
                            <li>
                                <a href="boardList.bo">
                                    	자유게시판
                                </a>
                            </li>
                            <li>
                                <a href="playList.ac">
                                    	강의 목록
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="#" onclick="javascript:window.open('Academy/Member/cookie_chekbox_popup.jsp','notice','toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=1400,height=850')">Team Academy</a>, made with love for a better web
                    </p>
                </div>
            </footer>
        </div>
    </div>
    <div class="fixed-plugin">
        <div class="dropdown show-dropdown">
            <a href="#" data-toggle="dropdown">
                <i class="fa fa-cog fa-2x"> </i>
            </a>
            <ul class="dropdown-menu">
                <li class="header-title">메뉴 필터변경</li>
                <li class="adjustments-line">
                    <a href="javascript:void(0)" class="switch-trigger active-color">
                        <div class="badge-colors text-center">
                            <span class="badge filter badge-purple" data-color="purple"></span>
                            <span class="badge filter badge-blue" data-color="blue"></span>
                            <span class="badge filter badge-green" data-color="green"></span>
                            <span class="badge filter badge-orange" data-color="orange"></span>
                            <span class="badge filter badge-red" data-color="red"></span>
                            <span class="badge filter badge-rose active" data-color="rose"></span>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </li>
                <li class="header-title">메뉴 배경 변경</li>
                <li class="adjustments-line">
                    <a href="javascript:void(0)" class="switch-trigger background-color">
                        <div class="text-center">
                            <span class="badge filter badge-white" data-color="white"></span>
                            <span class="badge filter badge-black active" data-color="black"></span>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </li>
                <li class="adjustments-line">
                    <a href="javascript:void(0)" class="switch-trigger">
                        <p>Sidebar Mini</p>
                        <div class="togglebutton switch-sidebar-mini">
                            <label>
                                <input type="checkbox" unchecked="">
                            </label>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </li>
                <li class="adjustments-line">
                    <a href="javascript:void(0)" class="switch-trigger">
                        <p>Sidebar Image</p>
                        <div class="togglebutton switch-sidebar-image">
                            <label>
                                <input type="checkbox" checked="">
                            </label>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </li>
                <li class="header-title">배경이미지</li>
                <li class="active">
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="assets/img/sidebar-1.jpg" alt="" />
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="assets/img/sidebar-2.jpg" alt="" />
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="assets/img/sidebar-3.jpg" alt="" />
                    </a>
                </li>
                <li>
                    <a class="img-holder switch-trigger" href="javascript:void(0)">
                        <img src="assets/img/sidebar-4.jpg" alt="" />
                    </a>
                </li>
                <!-- 톱니 모양을 클릭시 나오는 메뉴 화면 -->
                <li class="button-container">
                <!-- admin, 일반로그인, 비로그인에 따라 다른 메뉴가 출력 된다 -->
                <%if(session.getAttribute("id")!=null) {
                		if(session.getAttribute("id").equals("admin")){ %>
                			<div class="">
                        		<a href="AdminInfo.se?id=<%=session.getAttribute("id")%>" class="btn btn-rose btn-block">회원 목록 보기</a>
                    		</div>
                    		<div class="">
                        		<a href="MemberLogout.se" class="btn btn-info btn-block">로그아웃</a>
                    		</div>
                		
                		<%}else{ %>
                    		<div class="">
                        		<a href="MemberInfo.se?id=<%=session.getAttribute("id")%>" class="btn btn-rose btn-block">내 프로필 보기</a>
                    		</div>
                    		<div class="">
                        		<a href="MemberLogout.se" class="btn btn-info btn-block">로그아웃</a>
                    		</div>
                    		<%} %>
                    <%}else{ %>
                    <div class="">
                        <a href="MemberJoinForm.se" class="btn btn-rose btn-block">회원가입</a>
                    </div>
                    <div class="">
                        <a href="MemberLoginForm.se" class="btn btn-info btn-block">로그인</a>
                    </div>
                    <%} %>
                </li>
            </ul>
        </div>
    </div>
</body>
<!--   Core JS Files   -->
<script src="assets/js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/material.min.js" type="text/javascript"></script>
<script src="assets/js/perfect-scrollbar.jquery.min.js" type="text/javascript"></script>
<!-- Forms Validations Plugin -->
<script src="assets/js/jquery.validate.min.js"></script>
<!--  Plugin for Date Time Picker and Full Calendar Plugin-->
<script src="assets/js/moment.min.js"></script>
<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>
<!--  Plugin for the Wizard -->
<script src="assets/js/jquery.bootstrap-wizard.js"></script>
<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>
<!--   Sharrre Library    -->
<script src="assets/js/jquery.sharrre.js"></script>
<!-- DateTimePicker Plugin -->
<script src="assets/js/bootstrap-datetimepicker.js"></script>
<!-- Vector Map plugin -->
<script src="assets/js/jquery-jvectormap.js"></script>
<!-- Sliders Plugin -->
<script src="assets/js/nouislider.min.js"></script>
<!--  Google Maps Plugin    -->
<!--<script src="https://maps.googleapis.com/maps/api/js"></script>-->
<!-- Select Plugin -->
<script src="assets/js/jquery.select-bootstrap.js"></script>
<!--  DataTables.net Plugin    -->
<script src="assets/js/jquery.datatables.js"></script>
<!-- Sweet Alert 2 plugin -->
<script src="assets/js/sweetalert2.js"></script>
<!--	Plugin for Fileupload, full documentation here: http://www.jasny.net/bootstrap/javascript/#fileinput -->
<script src="assets/js/jasny-bootstrap.min.js"></script>
<!--  Full Calendar Plugin    -->
<script src="assets/js/fullcalendar.min.js"></script>
<!-- TagsInput Plugin -->
<script src="assets/js/jquery.tagsinput.js"></script>
<!-- Material Dashboard javascript methods -->
<script src="assets/js/material-dashboard.js"></script>
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>
<script type="text/javascript">
    function setFormValidation(id) {
        $(id).validate({
            errorPlacement: function(error, element) {
                $(element).parent('div').addClass('has-error');
            }
        });
    }

    $(document).ready(function() {
        setFormValidation('#RegisterValidation');
        setFormValidation('#TypeValidation');
        setFormValidation('#LoginValidation');
        setFormValidation('#RangeValidation');
    });
</script>

</html>