<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
 %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Academy</title>
        <!-- CSS -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,500,500i">
        <link rel="stylesheet" href="Academy/Board/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Academy/Board/assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="Academy/Board/assets/css/animate.css">
        <link rel="stylesheet" href="Academy/Board/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="Academy/Board/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="Academy/Board/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="Academy/Board/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="Academy/Board/assets/ico/apple-touch-icon-57-precomposed.png">
        
    </head>

    <body>
		<!-- Top menu -->
		<nav class="navbar navbar-inverse navbar-fixed-top navbar-no-bg" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp">Academy</a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="top-navbar-1">
					<ul class="nav navbar-nav navbar-right navbar-search-button">
						<li><a class="search-button" href="#"><i class="fa fa-search"></i></a></li>
					</ul>
					<form class="navbar-form navbar-right navbar-search-form disabled wow fadeInLeft" role="form" action="" method="post">
						<div class="form-group">
							<input type="text" name="search" placeholder="Search..." class="search form-control">
						</div>
					</form>
					<ul class="nav navbar-nav navbar-right navbar-menu-items wow fadeIn">
					   <li>${memberBean.ID}님 환영합니다.</li>
						<li><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="ContentsWrite.jsp">Contents</a></li>
						<li><a href="MemberInfo.se?id=${memberBean.ID}">My Page</a></li>
						<li><a href="./MemberLogout.se">logout</a></li>
					</ul>
				</div>
			</div>
		</nav>

        <!-- Top content  쓰기 -->
        <div class="top-content">
        <div class="container">
        <div class="row">
        <form action="re_commentAction.bo" method="post">
                <table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
        <thead>
           <tr>
              <th colspan="1" style="background-color:#eeeeee;text-align:center;" >답글 작성</th>
           </tr>
        </thead>
        
        <tbody>
           <tr>
           <!-- 제목 -->
              <td><input type="text" class="form-control" placeholder="답글" name="BOARD_SUBJECT" maxlenght="200">
                 <input type="hidden" name="BOARD_NUM" value="${at.BOARD_NUM}">
                 <input type="hidden" name="BOARD_RE_REF" value="${at.BOARD_RE_REF}">
                 <input type="hidden" name="BOARD_RE_LEV" value="${at.BOARD_RE_LEV}">
                 <input type="hidden" name="BOARD_RE_SEQ" value="${at.BOARD_RE_SEQ}"></td>
          </tr>
          <tr>
          <!-- 내용 -->
          
            <td><textarea  type="text" class="form-control" placeholder="내용" name="BOARD_CONTENT" maxlenght="2000" style="height:350px;"></textarea></td>
          </tr>
        </tbody>
        </table>
        <input type="hidden" value="id">
        <input type="submit" class="btn btn-primary pull-right" value="작성">
        </form>
        </div>
        
        
        </div>
        </div>
        <!-- Footer -->
        <footer>
	        <div class="container">
	        	<div class="row">
	        		<div class="col-sm-12 footer-copyright">
                    	&copy; Academy
                    </div>
                </div>
	        </div>
        </footer>
        <!-- Javascript -->
        <script src="Academy/Board/assets/js/jquery-1.11.1.min.js"></script>
        <script src="Academy/Board/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="Academy/Board/assets/js/jquery.backstretch.min.js"></script>
        <script src="Academy/Board/assets/js/wow.min.js"></script>
        <script src="Academy/Board/assets/js/waypoints.min.js"></script>
        <script src="Academy/Board/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>