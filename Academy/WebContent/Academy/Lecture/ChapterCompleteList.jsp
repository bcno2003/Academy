<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.playListBean" %>

<!doctype html>
<html>


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/tables/datatables.net.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 20 Mar 2017 21:34:01 GMT -->
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
                        <div class="collapse in" id="LoginMenu">
                            <ul class="nav">
                                <li>
                                    <a href="MemberInfo.se?id=<%=session.getAttribute("id")%>">내 프로필 보기</a>
                                </li>
                                <li class="active">
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
                        <div class="collapse" id="LectureList">
                            <ul class="nav">
                                <li>
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
                                	<li>
                                    	<a href="#">강의 수정 삭제</a>
                                	</li>
                                </ul>
                        	</div>
                    		</li>
                    
                    	<%}else{ %>
                    	<!-- 일반로그인인 경우 -->
                    	<li class="active">
                        	<a data-toggle="collapse" href="#MyPage">
                            	<i class="material-icons">content_paste</i>
                            	<p>회원정보관리
                                	<b class="caret"></b>
                            	</p>
                        	</a>
                        	<div class="collapse in" id="MyPage">
                            	<ul class="nav">
                                	<li>
                                		<!-- id 정보를 MemberInfo.se에 전달 하여 내 프로필 보기위한 과정을 진행한다. -->
                                    	<a href="MemberInfo.se?id=<%=session.getAttribute("id")%>">내 프로필 보기</a>
                                	</li>
                                	<li>
                                		<!-- id 정보를 MemberAlterForm.se에 전달 하여 내 프로필 수정을 위한 과정을 진행한다. -->
                                    	<a href="MemberAlterForm.se?id=<%=session.getAttribute("id")%>">내 프로필 수정</a>
                                	</li>
                                	<li class="active">
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
            
            <!-- 수강완료 목록 보기 -->
            <div class="content" >
                <div class="container-fluid">
                    <div class="row" >
                        <div class="col-md-12">
                            <div class="card" >
                                <div class="card-header card-header-icon" data-background-color="purple">
                                    <i class="material-icons">assignment</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">수강완료 목록 보기</h4>
                                    <div class="toolbar">
                                        <!--        Here you can write extra buttons/actions for the toolbar              -->
                                    </div>
                                    <div class="material-datatables">
                                        <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                                            <thead>
                                                <tr>
                                                    <th>등록 번호</th>
                                                    <th>이미지</th>
                                                    <th>챕터 제목</th>
                                                    <th>강의 등급</th>
                                                    <th>카테고리</th>
                                                    <th>수강완료일</th>
                                                   
                                                </tr>
                                            </thead>
                                            <tfoot>
                                                <tr>
                                                    <th>등록 번호</th>
                                                    <th>이미지</th>
                                                    <th>챕터 제목</th>
                                                    <th>강의 등급</th>
                                                    <th>카테고리</th>
                                                    <th>수강완료일</th>
                                                   
                                                </tr>
                                            </tfoot>
                                            <tbody>
                                            <!-- request 영역으로 전달받은 수강완료 목록 list를 el태그 형식으로 출력 한다. -->
                                            <!-- 챕터 제목 클릭시 해당 챕터영상 출력을 위해 SearchChapterViewAction.ac로 이동 -->
                                            <!-- 강의 등급 클릭시 해당 강의에 대한 챕터 목록을 보기위한 playChapterListAction.ac  -->
                                            <!-- 카테고리 클릭시 해당 카테고리에 해당하는 강의 목록 보기 위한 playList.ac로 이동 -->
                                           <c:forEach var = "list" items = "${CompleteList}" >
                                                <tr>
                                                    <th><p class="text-info">${list.playlist_num }</p></th>
                                                    <td height="50" width="100"><img class="photo" src="/Academy/imageUpload/${list.lecture_image }"  alt="강의등급이미지"></td>
                                                    <td><a href="SearchChapterViewAction.ac?playlist_num=${list.playlist_num }&category=${list.category }&lecture_level=${list.lecture_level }&id=<%=session.getAttribute("id")  %>">${list.chapter_subject }</a></td>
                                                    <td><a href="playChapterListAction.ac?category=${list.category }&lecture_level=${list.lecture_level }&id=<%=session.getAttribute("id")%>&lecture_image=${list.lecture_image }">${list.lecture_level }</a></td>
                                                    <td><a href="playList.ac?category=${list.category }&id=<%=session.getAttribute("id")  %>">${list.category }</a></td>
                                                   <td>
                                                    	${list.complete_date }
													</td>
                                                    
                                                </tr>
                                                </c:forEach> 
                                                
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <!-- end content-->
                            </div>
                            <!--  end card  -->
                        </div>
                        <!-- end col-md-12 -->
                    </div>
                    <!-- end row -->
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
<script type="text/javascript">
    $(document).ready(function() {
        $('#datatables').DataTable({
            "pagingType": "full_numbers",
            "lengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "All"]
            ],
            responsive: true,
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search records",
            }

        });


        var table = $('#datatables').DataTable();

        // Edit record
        table.on('click', '.edit', function() {
            $tr = $(this).closest('tr');

            var data = table.row($tr).data();
            alert('You press on Row: ' + data[0] + ' ' + data[1] + ' ' + data[2] + '\'s row.');
        });

        // Delete a record
        table.on('click', '.remove', function(e) {
            $tr = $(this).closest('tr');
            table.row($tr).remove().draw();
            e.preventDefault();
        });

        //Like record
        table.on('click', '.like', function() {
            alert('You clicked on Like button');
        });

        $('.card .material-datatables label').addClass('form-group');
    });
</script>


<!-- Mirrored from demos.creative-tim.com/material-dashboard-pro/examples/tables/datatables.net.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 20 Mar 2017 21:34:01 GMT -->
</html>