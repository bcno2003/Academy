<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="bean.PlayListInfo" %>
<%@ page import="bean.playListBean" %>
<%@ page import="bean.QAPageInfo" %>
<%
//현재 페이지의 강의 영상 출력 순서를 위한 변수 선언
playListBean playChapter = (playListBean)request.getAttribute("playChapter");

int nowOrder_num = playChapter.getOrder_num();
int maxOrder_num = (int)request.getAttribute("maxOrder_num");


%>
<%
//QA글 페이징 처리를 위한 변수 선언
QAPageInfo QApageInfo = (QAPageInfo)request.getAttribute("QApageInfo");

int nowQAPage = QApageInfo.getQApage();

int startQAPage = QApageInfo.getStartQAPage();
int endQAPage = QApageInfo.getEndQAPage();
int maxQAPage = QApageInfo.getMaxQAPage();
int QAlistCount = QApageInfo.getQAlistCount();
%>
<!doctype html>
<html>


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/components/notifications.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 20 Mar 2017 21:33:48 GMT -->
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Semi Project</title>
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
    <meta itemprop="image" content="../../s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
    <!-- Twitter Card data -->
    <meta name="twitter:card" content="summary_large_image">
    <meta name="twitter:site" content="@creativetim">
    <meta name="twitter:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template">
    <meta name="twitter:description" content="Material Dashboard PRO is a Premium Material Bootstrap Admin with a fresh, new design inspired by Google's Material Design.">
    <meta name="twitter:creator" content="@creativetim">
    <meta name="twitter:image" content="../../s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg">
    <!-- Open Graph data -->
    <meta property="fb:app_id" content="655968634437471">
    <meta property="og:title" content="Material Dashboard PRO by Creative Tim | Premium Bootstrap Admin Template" />
    <meta property="og:type" content="article" />
    <meta property="og:url" content="http://www.creative-tim.com/product/material-dashboard-pro" />
    <meta property="og:image" content="../../s3.amazonaws.com/creativetim_bucket/products/51/opt_mdp_thumbnail.jpg" />
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
</head>
<style>
.embed-container { position: relative; padding-bottom: 56.25%; height: 0; overflow: hidden; max-width: 100%; height: auto; }
.embed-container iframe,
.embed-container object,
.embed-container embed { position: absolute; top: 0; left: 0; width: 100%; height: 100%; }
</style>


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
                    Semi Project
                </a>
            </div>
            <div class="logo logo-mini">
                <a href="./MainAction.ac" class="simple-text">
                    Semi
                </a>
            </div>
            
            <!-- 로그인 상태확인을 위해 if문을 사용, admin, 일반로그인, 비 로그인상태에 따라 서로 다른 메뉴가 나타나게 한다. -->
            <div class="sidebar-wrapper">
                <div class="user">
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
                                <li >
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
                    <li>
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
                                	<li>
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
                        <a class="navbar-brand" href="./MainAction.ac"> Semi Project </a>
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
                            			<!-- 회원목록보기 과정을 위해 AdminInfo.se로 이동  -->
                                		<a href="AdminInfo.se?id=<%=session.getAttribute("id")%>" class="dropdown-toggle" >
                                    		<i class="material-icons">content_paste</i>
                                    		<p class="hidden-lg hidden-md">회원 목록 보기</p>
                                		</a>
                            		</li>
                            	
                            	<%}else{ %>
                            		<li>
                            			<!-- id 정보를 MemberInfo.se에 전달 하여 내 프로필 보기위한 과정을 진행한다. -->
                                		<a href="MemberInfo.se?id=<%=session.getAttribute("id")%>" class="dropdown-toggle" >
                                    		<i class="material-icons">person</i>
                                    		<p class="hidden-lg hidden-md">내 프로필 보기</p>
                                		</a>
                            		</li>
                            		<%} %>
                              <%} else{%>
                              		<li>
                              			<!-- 로그인 폼을 불러 오기 위해 MemberLoginForm.se로 이동한다.-->
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
            <div class="content" >
                <div class="container-fluid">
                    <div class="row">
                    <div class="col-md-12">
                            <div class="card">
                                <div class="card-content">
                                    
                                    <div class="row">
                                        <div class="col-md-12 text-center">
                                        <!-- 챕터 이동 메뉴 -->
                                            <% if(nowOrder_num <= 1){ %>
                                            <!-- 현재 출력 중인 영상이 가장 처음일 경우 -->
                                            <!-- 메시지 출력 -->
     		 								<a href="#" onclick="javascript:alert('강의의 첫 챕터 입니다')">
     		 									<button class="btn btn-primary btn-raised btn-round" >
                                                	<h4>이전 챕터</h4>
                                            	</button>
                                            </a>
                                             &nbsp;&nbsp;&nbsp;&nbsp;
   											<% }else{ %>
   											<!-- 가장 처음이 아닐 경우 이전 챕터로 이동 -->
   											<!-- playChapterViewAction.ac에 필요한 정보를 전달한다. -->
     		 									<a href ="playChapterViewAction.ac?category=${playChapter.category }&order_num=<%=nowOrder_num-1 %>&lecture_level=${playChapter.lecture_level }&id=<%=session.getAttribute("id") %>">
     		 									<button class="btn btn-primary btn-raised btn-round" >
                                                <h4>이전 챕터</h4>
                                            	</button>
     		 									</a>
     		 									 &nbsp;&nbsp;&nbsp;&nbsp;
   												<%} %>
   											<!-- 챕터 목록을 팝업 형식으로 띄우는 버튼 -->
   											<button class="btn btn-raised btn-round btn-info" data-toggle="modal" data-target="#ChapterList">
                                                <h4>챕터 목록</h4>
                                            </button>
  											 &nbsp;&nbsp;&nbsp;&nbsp;
  		 									<% if(nowOrder_num>=maxOrder_num){ %>
  		 									<!-- 현재 출력 중인 영상이 가장 마지막일 경우 -->
  		 									<a href="#" onclick="javascript:alert('강의의 마지막챕터 입니다')">
  		 										<button class="btn btn-raised btn-round btn-rose" >
                                                <h4>다음 챕터</h4>
                                            	</button>
                                            </a>
                                             
  		 									<%}else{ %>
  		 									<!-- 마지막이 아닐 경우 다음 챕터로 이동 -->
  		 									<!-- playChapterViewAction.ac에 필요한 정보를 전달한다. -->
  		 										<a href="playChapterViewAction.ac?category=${playChapter.category }&order_num=<%=nowOrder_num+1 %>&lecture_level=${playChapter.lecture_level }&id=<%=session.getAttribute("id") %>" >
  		 										<button class="btn btn-raised btn-round btn-rose" >
                                                <h4>다음 챕터</h4>
                                           		 </button>
  		 										</a>
  		 									<%} %>
                                           
                                           
                                            <!-- 챕터 목록 버튼을 누르면 나타나는 팝업창 -->
                                            <div class="modal fade" id="ChapterList" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog modal-notice">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                                                            <button type="button" class="btn btn-info btn-round" data-dismiss="modal"><b>챕터 목록</b></button>
                                                        </div>
                                                        <div class="modal-body">
                                                        <!-- request 영역으로 전달 받은 playChapterList를 el태그 형식으로 출력 -->
                                                        	<c:forEach var = "list" items = "${playChapterList}" >
                                                            <div class="instruction">
                                                                <div class="row">
                                                                    <div class="col-md-8">
                                                                        <strong>챕터 ${list.order_num }.</strong>
                                                                        <!-- 챕터 제목 클릭시 해당 챕터로 이동한다. -->
                                                                        <p><a href="playChapterViewAction.ac?playlist_num=${list.playlist_num }&category=${list.category }&order_num=${list.order_num }&lecture_level=${list.lecture_level }&id=<%=session.getAttribute("id")  %>">${list.chapter_subject }</a></p>
                                                                    </div>
                                                                    <div class="col-md-4">
                                                                        <div class="picture">
                                                                        <!-- 수강완료 목록을 request 영역으로 전달 받고 현재 출력 중인 챕터 영상의 번호가 수강완료목록의 챕터 영상 번호와 같을 경우  -->
                                                                        <!-- 수강완료를 알려주는 완료 출력-->
                                                                        <c:forEach var = "clist" items = "${completeList }" >
																	<c:if test="${clist.playlist_num == list.playlist_num }"> <p class="text-danger">완료</p></c:if>
																		</c:forEach>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            </c:forEach>
                                                            
                                                        </div>
                                                        <div class="modal-footer text-center">
                                                            <button type="button" class="btn btn-info btn-round" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- end notice modal -->
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">
                                    <!-- 강의 영상 출력 -->
                                    <div class="alert alert-info">
                                    <!-- request 영역으로 전달 받은  chapter_url-->
                                    <div class="embed-container">
    								${playChapter.chapter_url }
										</div>
                                        
                                    </div>
                                    <button class="btn btn-primary btn-raised btn-warning"><h4><b>${playChapter.chapter_subject }</b></h4></button>
                                    <!-- 로그인 된 상태일 경우 수강완료를 체크한다 -->
                                    <%if(session.getAttribute("id")!=null){%>
                                    
										<c:choose>
										<c:when test="${chapterCheck.id !=null }">
										<!-- 로그인중인 아이디가 수강완료목록에 해당할 경우 수강완료 츌력 -->
											<button class="btn btn-primary btn-raised btn-danger" style=float:right><h4>수강완료</h4></button>
										</c:when>
										<c:otherwise>
										<!-- 로그인중인 아이디가 수강완료되지 않았을 경우 수강확인버튼 출력 -->
										<!-- 해당 버튼을 클릭시 ChapterCheckAction.ac로 필요한 정보를 전달 하여 해당 아이디를 수강완료한다 -->
											<a href="ChapterCheckAction.ac?id=<%=session.getAttribute("id") %>&order_num=${playChapter.order_num }&category=${playChapter.category}&playlist_num=${playChapter.playlist_num}&lecture_level=${playChapter.lecture_level}&lecture_image=${playChapter.lecture_image}&chapter_subject=${playChapter.chapter_subject }" class="btn btn-primary btn-raised btn-danger" style=float:right><h4>수강확인버튼</h4></a>
										</c:otherwise>
										</c:choose> 
									<% }else{%>
										<!-- 비로그인인 경우 미완료 출력 -->
											<button class="btn btn-primary btn-raised btn-danger" style=float:right><h4>미완료</h4></button>
									<%}%>
                                    </h4>
                                </div>
                                
                            </div>
                        </div>
                       
                        <div class="col-md-6">
                            <div class="card">
                                <!-- 챕터 목표와 QA게시판  토글 기능  -->
                                <div class="card-content">
                                    <ul class="nav nav-pills nav-pills-warning">
                                        <li >
                                            <a href="#pill1" data-toggle="tab"><b>챕터 목표</b></a>
                                        </li>
                                      
                                        <li class="active">
                                            <a href="#pill3" data-toggle="tab"><b>QA게시판</b></a>
                                        </li>
                                    </ul>
                                    <!-- 챕터 목표 버튼 클릭시 챕터 목표가 나타난다 -->
                                    <div class="tab-content">
                                        <div class="tab-pane" id="pill1">
                                            <h3><b>${playChapter.chapter_objectives }</b></h3>
                                        </div>
                                        <!-- QA게시판 버튼 클릭시 QA에 게시판이 나타난다 -->
                                        <div class="tab-pane active" id="pill3">
                                        	<!-- 현재 출력중인 챕터영상에 해당하는 QA글 목록을 출력 -->
                                        	<!-- QA글 내용과 작성자, 작성일 순으로 나타난다 -->
                                           <c:forEach var = "qaboard_list" items = "${chapterQAView}">
                                            <p>${qaboard_list.qaboard_content }</p>
                                           <small class="text-muted">Posted by ${qaboard_list.qaboard_name } on ${qaboard_list.qaboard_date }</small>
                                           <hr>
                                           </c:forEach>
                                           <hr>
                                           <!-- QA글 페이징 처리 -->
                                           <% if(nowQAPage <= 1){ %>
      											[이전]&nbsp;
   											<% }else{ %>
     											 <a href ="playChapterViewAction.ac?page=<%=nowQAPage-1 %>&order_num=${playChapter.order_num }&category=${playChapter.category}&playlist_num=${playChapter.playlist_num}&lecture_level=${playChapter.lecture_level}&id=<%=session.getAttribute("id") %>">[이전]</a>&nbsp;
   											<%} %>
   
   											<% for(int a=startQAPage;a<=endQAPage;a++) {
        									 if(a==nowQAPage){%>
        									 [<%=a %>]
         										<%}else{ %>
         									<a href="playChapterViewAction.ac?page=<%=a %>&order_num=${playChapter.order_num }&category=${playChapter.category}&playlist_num=${playChapter.playlist_num}&lecture_level=${playChapter.lecture_level}&id=<%=session.getAttribute("id") %>">[<%=a %>]</a>&nbsp;
         										<%} %>
         									<%} %>
         
   											<% if(nowQAPage>=maxQAPage){ %>
   												[다음]
   											<%}else{ %>
   												<a href="playChapterViewAction.ac?page=<%=nowQAPage+1 %>&order_num=${playChapter.order_num }&category=${playChapter.category}&playlist_num=${playChapter.playlist_num}&lecture_level=${playChapter.lecture_level}&id=<%=session.getAttribute("id") %>">[다음]</a>
   												<%} %>
   												<hr>
   												<!-- 목록 이후 새로운 QA글 작성을 위한 form -->
   												<!-- 로그인인 경우에만 가능하다 -->
   												<%if(session.getAttribute("id")!=null) {%>
												<div class="">
												
												<p class="text-success">Q&A작성하기</p>
                                       			 <div class="progress progress-line-success">
                                                <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%; ">
                                                </div>
                                            </div>
												</div>
												<hr>
												<div class="card-body" >
												<!-- 입력받은 정보를  /QAboardWrite.ac로 전달한다.-->
													<form name="QAboardWrite" action="./QAboardWrite.ac" method="post">
													<input type="hidden" value='${playChapter.playlist_num }' name="playlist_num">
													<input type="hidden" value='${playChapter.order_num }' name="order_num">
													<input type="hidden" value='${playChapter.lecture_level }' name="lecture_level">
													<input type="hidden" value='${playChapter.category }' name="category">
													<input type="hidden" name="qaboard_name" value=<%=session.getAttribute("id") %>>
													
													<textarea cols="80" rows="2" name="qaboard_content" placeholder="질문을 남겨주세요" class="list-group"></textarea>
													<br>
													<a href="#" onclick="javascript:QAboardWrite.submit()" class="btn btn-success">[댓글등록]</a>
													</form>
													<hr>
													</div>
	
	
											<%}else{%>
											<!-- 비로그인인 경우 버튼을 누르면 팝업창 형식으로 로그인 화면이 나타난다 -->
											<center>
											<button class="btn btn-raised btn-round btn-success" data-toggle="modal" data-target="#QALogin">
                                                <h4>로그인후 작성 가능합니다.</h4>
                                            </button>
                                            </center>
											<%} %>
                                        </div>
                                        <!-- QALogin 팝업창 -->
                                            <div class="modal fade" id="QALogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                                <div class="modal-dialog">
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                                <i class="material-icons">clear</i>
                                                            </button>
                                                            <h4 class="modal-title">로그인</h4>
                                                        </div>
                                                        <div class="modal-body">
                                                        <!-- 로그인후 해당 챕터영상을 바로 출력 할 수 있도록 /MemberQALoginAction.ac로 이동-->
                                                            <form action="./MemberQALoginAction.ac" method="post" class="form-signin" role="form">
                  											<input type="text" name="id" class="form-control" placeholder="Id" id="name" required="required">
                  											<input type="password" name="pass" class="form-control" placeholder="Password" required="required">
                  											<input type="submit" value="Sigh In" class="btn btn-lg btn-primary btn-block" >
                  											<input type="hidden" value='${playChapter.category}' name="category">
                  											<input type="hidden" value='${playChapter.playlist_num}' name="playlist_num">
                  											<input type="hidden" value='${playChapter.lecture_level}' name="lecture_level">
                  											<input type="hidden" value='${playChapter.order_num }' name="order_num">
                  											</form>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Close</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
           <!--화면 좌측 하단부에 작은 메뉴  -->
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


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/components/notifications.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 20 Mar 2017 21:33:48 GMT -->
</html>